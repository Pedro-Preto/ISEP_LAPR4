package eapli.base.app.user.console.dashboard;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Request.model.Request;
import eapli.base.Task.domain.Manual.TaskManualRequest;
import eapli.base.app.user.console.TCP.TcpChatClient;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RRH {
    static private final String BASE_FOLDER = "base.app.user.console/src/main/java/eapli/base/app/user/console/www";
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
            HttpAjaxVotingTasks req = new HttpAjaxVotingTasks(cliSock, BASE_FOLDER);
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


    public static synchronized String getTasksInHTML() {
        Collaborator collaborator = PersistenceContext.repositories().collaborators().findByMecanographicNumber(MecanographicNumber.valueOf(mecNumber));

        String textHtml = "<p>" +"Account: " +collaborator.getFirstName() +" "
                +collaborator.getLastName() +" (" +collaborator.getNumMechanographic() +") " +"</p>";
        textHtml = textHtml +"<hr><ul align=left>";

        for (final TaskManualRequest request : PersistenceContext.repositories().taskManualRequest().getManualTasksOfCollaborator(collaborator)) {
            textHtml = textHtml + "<li>" +"Task Code: "+ request.getCode() +" Responsible Collaborator: " +request.getResponsibleCollaborator().getFirstName() +" "
                    +request.getResponsibleCollaborator().getLastName() +" Task State: "+request.getTaskState()+" (" +request.getResponsibleCollaborator().getNumMechanographic() +") " +"</li>";
        }
        //textHtml = textHtml + "</ul><hr><p>HTTP server accesses counter: " + accessesCounter + "</p><hr>";


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