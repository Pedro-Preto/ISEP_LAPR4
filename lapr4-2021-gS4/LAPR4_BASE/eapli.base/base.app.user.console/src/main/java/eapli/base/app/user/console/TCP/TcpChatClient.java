package eapli.base.app.user.console.TCP;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Task.application.Automatic.TaskAutomaticRequestController;
import eapli.base.app.user.console.dashboard.RRH;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpChatClient {
	static InetAddress serverIP;
	static Socket sock;

	public static void send() throws Exception {
		String frase;
		byte[] data = new byte[300];


		try {
			serverIP = InetAddress.getByName("127.0.0.1");
		} catch(UnknownHostException ex) {
			System.out.println("Invalid server: 127.0.0.1");
			System.exit(1); }

		try {
			sock = new Socket(serverIP, 9997);
		} catch(IOException ex) {
			System.out.println("Failed to connect.");
			System.exit(1); }

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());

		// start a thread to read incoming messages from the server
		Thread serverConn = new Thread(new TcpChatCliConn(sock));
		serverConn.start();

		while(true) {
			CollaboratorController collaboratorController = new CollaboratorController();
			AuthorizationService authz = AuthzRegistry.authorizationService();
			Collaborator col = collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(authz.session().get().authenticatedUser().identity().toString()));
			String mecNumCol = col.identity().toString();
			frase = mecNumCol;
			data = frase.getBytes();
			sOut.write((byte) frase.length());
			sOut.write(data, 0, (byte) frase.length());

			if(false)
				break;
		}
		serverConn.join();
		sock.close();
	}
}


class TcpChatCliConn implements Runnable {
	private Socket s;
	private DataInputStream sIn;

	public TcpChatCliConn(Socket tcp_s) { s=tcp_s;}

	public void run() {
		int nChars;
		byte[] data = new byte[300];
		String frase;

		TaskAutomaticRequestController taskAutomaticController = new TaskAutomaticRequestController();

		try {
			sIn = new DataInputStream(s.getInputStream());
			while(true) {
				nChars = sIn.read();
				if(nChars == 0)
					break;

				sIn.read(data, 0, nChars);
				frase = new String(data, 0, nChars).trim();

				String[] dataSplit = frase.split("====");
				String response ="";

				for (String s : dataSplit) {
					response = response + s;
				}
				//Portal.setRequests(response);
			}
		}catch(IOException ex) {
			System.out.println("Client disconnected.");
		}
	}
}