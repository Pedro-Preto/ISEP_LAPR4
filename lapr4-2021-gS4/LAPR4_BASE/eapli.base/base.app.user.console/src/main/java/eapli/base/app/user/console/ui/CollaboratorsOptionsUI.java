package eapli.base.app.user.console.ui;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.*;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.io.util.Console;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CollaboratorsOptionsUI {
    CollaboratorController collaboratorController = new CollaboratorController();
    Scanner in = new Scanner(System.in);

    public boolean addCollaborator()  {
        try {
            System.out.println("Insert the Collaborator's email...");
            String email = in.nextLine();
            EmailAddress emailAddress = EmailAddress.valueOf(email);
            System.out.println("==================================================");
            System.out.println("Insert the Collaborator's First name...");
            String shortN = in.nextLine();
            CollaboratorFirstName collaboratorFirstName=CollaboratorFirstName.valueOf(shortN);
            System.out.println("==================================================");
            System.out.println("Insert the Collaborator's Last name");
            String fullN = in.nextLine();
            CollaboratorLastName collaboratorLastName = CollaboratorLastName.valueOf(fullN);
            System.out.println("==================================================");
            System.out.println("Insert the Collaborator's Phone Number");
            String phoneN = in.nextLine();
            CollaboratorPhoneNumber phoneNumber = CollaboratorPhoneNumber.valueOf(phoneN);
            System.out.println("==================================================");
            System.out.println("Insert the Collaborator's Birth day (Use this format: dd/MM/yyyy)");
            String sDate1 = in.nextLine();
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            CollaboratorBirthDay collaboratorBirthDay = CollaboratorBirthDay.valueOf(date1);
            System.out.println("==================================================");
            System.out.println("Insert the Collaborator's Address (Street)");
            String street = in.nextLine();
            System.out.println("==================================================");
            System.out.println("Insert the Collaborator's Address (Location)");
            String location = in.nextLine();
            System.out.println("==================================================");
            System.out.println("Insert the Collaborator's Address (Country)");
            String country = in.nextLine();
            CollaboratorAddress collaboratorAddress = CollaboratorAddress.valueOf(street, location, country);
            System.out.println("==================================================");
            System.out.println("Insert the Collaborator's Mechanographic Number");
            String numMec = in.nextLine();
            MecanographicNumber mecanographicNumber = MecanographicNumber.valueOf(numMec);
            System.out.println("==================================================");
            Set <CollaboratorFunctions>collaboratorFunctions =collaboratorFunction();
            System.out.println("==================================================");
            System.out.println("Insert the Collaborator's Role-> Type 1 for RRH,Type 2 for GSH");
            int role=in.nextInt();
            collaboratorController.addAnRRHOrGSHCollaborator(mecanographicNumber,collaboratorFirstName ,collaboratorLastName, emailAddress, phoneNumber, collaboratorBirthDay, collaboratorAddress, collaboratorFunctions,role);
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return false;
        }
    }

    public static Set<CollaboratorFunctions> collaboratorFunction() {
        Scanner in = new Scanner(System.in);
        Set<CollaboratorFunctions> functions = new HashSet<>();
        System.out.println("Insert Collaborator Functions (Type 0 when you no longer wish to add functions)");
        String fun = null;
        while (fun != "0") {
            fun = null;
            fun = in.nextLine();
            if (!fun.equals("0")) {
                System.out.println(fun + " Was Added...");
                System.out.println("========================================");
                System.out.println("Insert Another Function (Type 0 to Exit)");
                System.out.println("=========================================");
                functions.add(CollaboratorFunctions.valueOf(fun));
            }else {
                break;
            }

        }
        return functions;
    }

    public boolean getlistCollaborators() {
        System.out.println("List Of Collaborators ...");
        System.out.println("==========================");
        try {
            for (Collaborator c : collaboratorController.getAllCollaborators()){
                System.out.println(c.toString());
            }
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return false;
        }
    }
}
