package eapli.base.app.user.console.dashboard;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author asc@isep.ipp.pt
 */
public class LogInGSH {

    static private final String IP = "localhost";
    static private final String PORT = "9998";

    public static void doLogin() throws Exception {

        Socket sock = null;
        InetAddress serverIP = null;
        int serverPort = 0;
        DataOutputStream sOut = null;
        DataInputStream sIn = null;

        try {
            serverIP = InetAddress.getByName(IP);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid SERVER-ADDRESS.");
            System.out.println("Connection to Dashboard aborted.");
        }

        try {
            serverPort = Integer.parseInt(PORT);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid SERVER-PORT.");
            System.out.println("Connection to Dashboard aborted.");
        }

        HTTPmessage request = new HTTPmessage();
        request.setRequestMethod("GET");
        request.setURI("/login");

        CollaboratorController collaboratorController = new CollaboratorController();
        AuthorizationService authz = AuthzRegistry.authorizationService();
        Collaborator col = collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(authz.session().get().authenticatedUser().identity().toString()));
        String mecNumCol = col.identity().toString();

        //String mecNumCol = "106";

        request.setContentFromString(mecNumCol, "text/plain");

        connect(sock, serverIP, serverPort, sOut, sIn, request);
    } // MAIN METHOD

    public static void doLogout() throws Exception {
        Socket sock = null;
        InetAddress serverIP = null;
        int serverPort = 0;
        DataOutputStream sOut = null;
        DataInputStream sIn = null;

        try {
            serverIP = InetAddress.getByName(IP);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid SERVER-ADDRESS.");
            System.out.println("Connection to Dashboard aborted.");
        }

        try {
            serverPort = Integer.parseInt(PORT);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid SERVER-PORT.");
            System.out.println("Connection to Dashboard aborted.");
        }

        HTTPmessage request = new HTTPmessage();
        request.setRequestMethod("GET");
        request.setURI("/logout");

        connect(sock, serverIP, serverPort, sOut, sIn, request);
    } // MAIN METHOD

    private static void connect(Socket sock, InetAddress serverIP, int serverPort, DataOutputStream sOut, DataInputStream sIn, HTTPmessage request) {
        System.out.println("Connecting to http://" + IP + ":" + serverPort + "/");
        try {
            sock = new Socket(serverIP, serverPort);
        } catch (IOException ex) {
            System.out.println("Failed to connect to provided SERVER-ADDRESS and SERVER-PORT.");
            System.out.println("Connection to Dashboard aborted.");
        }

        try {
            sOut = new DataOutputStream(sock.getOutputStream());
            sIn = new DataInputStream(sock.getInputStream());
        } catch (IOException ex) {
            System.out.println("Error accessing socket's streams. Aborted.");
            try {
                sock.close();
            } catch (IOException ex2) {
                System.out.println("Error closing socket.");
            }
            System.out.println("Connection to Dashboard aborted.");
        }

        try {
            System.out.println("Connecting");
            request.send(sOut);                // send HTTP request
            HTTPmessage response = new HTTPmessage(sIn);    // receive HTTP response
            System.out.println("HTTP server response status: " + response.getStatus());
            try {
                sock.close();
            } catch (IOException ex2) {
                System.out.println("Error closing socket.");
            }
        } catch (IOException ex2) {
            System.out.println("Error getting response.");
        }
    }
} // CLASS
