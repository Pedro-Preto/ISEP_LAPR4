package eapli.base.app.portal.dashboard;

import TCP.TcpChatCli;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Request.model.Request;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class Portal {

    static private final String BASE_FOLDER = "base.app.portal.dashboard/src/main/java/www";
    static private ServerSocket sock;

    public static void main(String args[]) throws Exception {
        Socket cliSock;

        if(args.length!=1) {
            System.out.println("Local port number required at the command line.");
            System.exit(1);
        }

        accessesCounter = 0;

        try
        {
            sock = new ServerSocket(Integer.parseInt(args[0]));
        }
        catch(IOException ex) {
            System.out.println("Server failed to open local port " + args[0]);
            System.exit(1);
        }
        while(true) {
            cliSock = sock.accept();
            HttpAjaxVotingRequest req = new HttpAjaxVotingRequest(cliSock, BASE_FOLDER);
            req.start();
            incAccessesCounter();
        }
    }

    // DATA ACCESSED BY THREADS - LOCKING REQUIRED

    private static int accessesCounter;
    private static String mecNumber;
    private static String requests;

    private static synchronized void incAccessesCounter() {
        accessesCounter++;
    }


    public static synchronized String getRequestsInHTML() {
        Collaborator collaborator = PersistenceContext.repositories().collaborators().findByMecanographicNumber(MecanographicNumber.valueOf(mecNumber));

        String textHtml = "<p>" +"Account: " +collaborator.getFirstName() +" "
                +collaborator.getLastName() +" (" +collaborator.getNumMechanographic() +") " +"</p>";
        textHtml = textHtml +"<hr><ul align=left>";

        for (final Request request : PersistenceContext.repositories().requests().findByRequester(collaborator)) {
            textHtml = textHtml + "<li>" + request.getCodeRequest() +" requested by: " +request.getRequester().getFirstName() +" "
            +request.getRequester().getLastName() +" (" +request.getRequester().getNumMechanographic() +") " +"</li>";
        }
        //textHtml = textHtml + "</ul><hr><p>HTTP server accesses counter: " + accessesCounter + "</p><hr>";


        return textHtml;
    }

/*
    public static synchronized String getRequestsInHTML() {
        byte[] aux = requests.getBytes();
        byte[] html = new byte[aux[2]];
        for (int i =2; i<aux.length; i++){
            html[i-2] = aux[i];
        }
        String req = new String(html,0, html.length).trim();
        return req;
    }

    public static void setRequests(String req){
        requests = req;
    }

 */

    public static synchronized String getRequestsFromMotor() {
        Collaborator collaborator = PersistenceContext.repositories().collaborators().findByMecanographicNumber(MecanographicNumber.valueOf(mecNumber));
        String mecNumber = collaborator.getNumMechanographic().toString();
        String textHtml="";

        //FAZER REQUEST PELO TCP ENVIAR NUM MEC E RECEBER REQUESTS - recebe um array de bytes
        try {
            TcpChatCli.send();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //String dataString = new String(data, StandardCharsets.UTF_8);

        //String[] dataSplit = dataString.split("====");


        //for (String s : dataSplit) {
        //    textHtml = textHtml + s;
        //}
        return textHtml;
    }

    public static synchronized String getUserInHTML(String number) {
        String textHtml = "<hr><ul>";
        mecNumber = number;
        Collaborator collaborator = PersistenceContext.repositories().collaborators().findByMecanographicNumber(MecanographicNumber.valueOf(mecNumber));

        //textHtml = textHtml + "</ul><hr><p>HTTP server accesses counter: " + accessesCounter + "</p><hr>";
        return textHtml;
    }

    public static synchronized String logOut() {
        String textHtml = "<hr><ul>";
        mecNumber = null;
        requests = null;
        return textHtml;
    }

}
