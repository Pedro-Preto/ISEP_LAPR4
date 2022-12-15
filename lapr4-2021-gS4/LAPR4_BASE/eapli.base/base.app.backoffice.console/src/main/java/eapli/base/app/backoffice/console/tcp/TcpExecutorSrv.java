package eapli.base.app.backoffice.console.tcp;

import javax.script.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class TcpExecutorSrv {

	private static HashMap<Socket,DataOutputStream> cliList = new HashMap<>();

	public static synchronized void sendToAll(int len, byte[] data) throws Exception {

		String dataString = new String(data, StandardCharsets.UTF_8);

		String[] dataSplit = dataString.split("====");

		//System.out.println("Tamanho: " +dataSplit[0]);
		//System.out.println("TaskId: " +dataSplit[1]);
		//System.out.println("Script: " +dataSplit[2].trim());

		String auxId = dataSplit[1];
		byte[] response = auxId.getBytes();

		System.out.println("A executar " +auxId +"!");

		//Executing the Script
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			//engine.eval(file);
			engine.eval(dataSplit[2].trim());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		//====================

		for(DataOutputStream cOut: cliList.values()) {
			cOut.write(len);
			cOut.write(response,0,response.length);
		}
		System.out.println(auxId +" feita!");
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
				TcpExecutorSrv.sendToAll(nChars,data);
			}
		}
		catch(Exception ex) {
			try {
				TcpExecutorSrv.remCli(myS);
				return;
			} catch (Exception e) {
				System.out.println("Error");
				System.out.println(ex.getMessage());
			}
		}
	}
}



