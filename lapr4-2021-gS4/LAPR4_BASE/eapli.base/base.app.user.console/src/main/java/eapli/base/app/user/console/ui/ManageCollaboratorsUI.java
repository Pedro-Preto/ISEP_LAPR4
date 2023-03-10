package eapli.base.app.user.console.ui;

import eapli.framework.io.util.Console;

import java.text.ParseException;
import java.util.Scanner;

public class ManageCollaboratorsUI {
    private static CollaboratorsOptionsUI collaboratorsOptionsUI = new CollaboratorsOptionsUI();

    public static void showMenu()  {
        Scanner in = new Scanner(System.in);
        int option = 0;
        do {
            option = showOptions();

            switch (option) {
                case 0:
                    System.out.println("Exiting ...");
                    break;
                case 1:
                    collaboratorsOptionsUI.addCollaborator();
                    break;
                case 2:

                    collaboratorsOptionsUI.getlistCollaborators();
                    break;
                default:
                    System.out.println("Option does not exist!");
                    break;
            }
        } while (option != 0);
    }

    private static int showOptions() {
        int option = -1;
        System.out.println("");
        System.out.println("=============================");
        System.out.println(" Manage Collaborators Menu: ");
        System.out.println("=============================\n");
        System.out.println("1.Register Collaborator");
        System.out.println("2.Collaborator's List");
        System.out.println("=================================");
        System.out.println("0.Back\n");

        option = Console.readInteger("Please select an option");
        return option;
    }


}
