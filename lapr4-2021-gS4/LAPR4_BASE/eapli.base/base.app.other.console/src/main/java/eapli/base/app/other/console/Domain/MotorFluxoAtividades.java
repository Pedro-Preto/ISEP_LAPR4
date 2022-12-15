package eapli.base.app.other.console.Domain;

import eapli.base.Request.application.RequestController;
import eapli.base.Request.model.Request;
import eapli.base.Task.application.Automatic.TaskAutomaticBaseController;
import eapli.base.Task.domain.Automatic.TaskAutomaticBase;
import eapli.base.Task.domain.Manual.TaskState;
import eapli.base.Task.repository.Automatic.TaskAutomaticBaseRepository;
import eapli.base.app.other.console.tcp.TcpChatCli;

import java.util.List;
import java.util.Set;

public class MotorFluxoAtividades {

    private static RequestController requestController = new RequestController();

    public static synchronized void manageTasks() throws Exception {
        TcpChatCli.sendTasks(); //send to Executor Tarefas Automaticas
    }

    /*public static synchronized String getRequestsinHTML() {
        String textHtml = "";

        for (final Request request : PersistenceContext.repositories().requests().findAll()) {
            textHtml = textHtml + "<li>" + request.getCodeRequest() +" requested by: " +request.getRequester().getFirstName() +" "
                    +request.getRequester().getLastName() +" (" +request.getRequester().getNumMechanographic() +") " +"</li>";
        }
        //textHtml = textHtml + "</ul><hr><p>HTTP server accesses counter: " + accessesCounter + "</p><hr>";
        return textHtml;
    }  */
}
