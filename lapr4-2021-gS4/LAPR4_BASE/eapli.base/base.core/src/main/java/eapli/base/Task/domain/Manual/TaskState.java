package eapli.base.Task.domain.Manual;

public enum TaskState {

    Completed,
    WaitingApproval,    //Nao esta aprovado
    Uncompleted,        //Depois de aprovado
    InCourse;
}
