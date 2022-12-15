package eapli.base.app.other.console.tcp;

import eapli.base.Request.application.RequestController;
import eapli.base.Request.model.Request;
import eapli.base.Task.application.Automatic.TaskAutomaticRequestController;
import eapli.base.Task.domain.Automatic.CodeTaskAutomaticRequest;
import eapli.base.Task.domain.Automatic.TaskAutomaticRequest;
import eapli.base.Task.domain.Manual.TaskState;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class TcpChatCli {
    static InetAddress serverIP;
    static Socket sock;
    static TaskAutomaticRequestController taskAutomaticController = new TaskAutomaticRequestController();

    public static void sendTasks() throws Exception {
        String nick, frase, aux;
        byte[] data = new byte[300];


        try {
            serverIP = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server: 127.0.0.1");
            System.exit(1);
        }

        try {
            sock = new Socket(serverIP, 9999);
        } catch (IOException ex) {
            System.out.println("Failed to connect.");
            System.exit(1);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());

        // start a thread to read incoming messages from the server
        Thread serverConn = new Thread(new TcpChatCliConn(sock));
        serverConn.start();

        while (true) {
            List<TaskAutomaticRequest> tasks = taskAutomaticController.getUncompletedTasks();
            for (TaskAutomaticRequest task : tasks) {

                taskAutomaticController.setInCourse(task);
                aux = "====" + task.identity().toString() + "====" + task.getScript().contentOfScript();

                frase = "03" + aux.length(); //protocol

                frase = frase + aux;

                data = frase.getBytes();
                sOut.write((byte) frase.length());
                sOut.write(data, 0, (byte) frase.length());

            }
            if (false)
                break;
        }
        serverConn.join();
        sock.close();
    }
}


class TcpChatCliConn implements Runnable {
    private Socket s;
    private DataInputStream sIn;

    public TcpChatCliConn(Socket tcp_s) {
        s = tcp_s;
    }

    public void run() {
        int nChars;
        byte[] data = new byte[300];
        String frase;

        TaskAutomaticRequestController taskAutomaticController = new TaskAutomaticRequestController();

        try {
            sIn = new DataInputStream(s.getInputStream());
            while (true) {
                nChars = sIn.read();
                if (nChars == 0)
                    break;

                sIn.read(data, 0, nChars);
                frase = new String(data, 0, nChars).trim();
                try {
                    TaskAutomaticRequest task = taskAutomaticController.getTaskByCode(CodeTaskAutomaticRequest.valueOf(frase.trim()));
                    taskAutomaticController.completeTask(task); //grava na base de dados as tasks que recebeu a indicacao que estao feitas como feitas
                    System.out.println(frase.trim() + " feita.");
                } catch (Exception e) {
                    System.out.println("!");
                }
            }
        } catch (IOException ex) {
            System.out.println("Client disconnected.");
        }
    }
}




