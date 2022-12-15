package eapli.base.app.other.console.tcp;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Request.model.Request;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.infrastructure.persistence.PersistenceContext;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class TcpServer {

	private static HashMap<Socket,DataOutputStream> cliList = new HashMap<>();

	public static synchronized void sendToAll(int len, byte[] data) throws Exception {

		String colabNum = new String(data, StandardCharsets.UTF_8).trim();

		Collaborator collaborator = PersistenceContext.repositories().collaborators().findByMecanographicNumber(MecanographicNumber.valueOf(colabNum));

		String textHtml = "<p>" +"Account: " +collaborator.getFirstName() +" "
				+collaborator.getLastName() +" (" +collaborator.getNumMechanographic() +") " +"</p>";
		textHtml = textHtml +"<hr><ul align=left>";

		for (final Request request : PersistenceContext.repositories().requests().findByRequester(collaborator)) {
			textHtml = textHtml + "<li>" + request.getCodeRequest() +" requested by: " +request.getRequester().getFirstName() +" "
					+request.getRequester().getLastName() +" (" +request.getRequester().getNumMechanographic() +") " +"</li>";
		}

		int length = textHtml.getBytes().length;
		String res = "03" + length + textHtml;
		byte[] response = res.getBytes();

		for(DataOutputStream cOut: cliList.values()) {
			cOut.write(len);
			cOut.write(response,0,response.length);
		}
	}

	public static synchronized void addCli(Socket s) throws Exception {
		cliList.put(s,new DataOutputStream(s.getOutputStream()));
	}

	public static synchronized void remCli(Socket s) throws Exception {
		cliList.get(s).write(0);
		cliList.remove(s);
		s.close();
	}



	private static ServerSocket sock;

	public static void runExecutor() throws Exception {
		try {
			sock = new ServerSocket(9999);
		}
		catch(IOException ex) {
			System.out.println("Local port number not available.");
			System.exit(1);
		}

		while(true) {
			Socket s = sock.accept(); // wait for a new client connection request
			addCli(s);
			Thread cli = new TcpChatSrvClient(s);
			cli.start();
		}
	}
}


class TcpChatSrvClient extends Thread {
	private Socket myS;
	private DataInputStream sIn;

	public TcpChatSrvClient(Socket s) {
		myS = s;
	}

	public void run() {
		int nChars;
		byte[] data = new byte[300];

		try {
			sIn = new DataInputStream(myS.getInputStream());
			while(true) {
				nChars=sIn.read();
				if(nChars == 0)
					break; // empty line means client wants to exit
				sIn.read(data,0,nChars);
				TcpServer.sendToAll(nChars,data);
			}
			// the client wants to exit
			TcpServer.remCli(myS);
		}
		catch(Exception ex) {
			System.out.println("Error");
			System.out.println(ex.getMessage());
		}
	}
}



