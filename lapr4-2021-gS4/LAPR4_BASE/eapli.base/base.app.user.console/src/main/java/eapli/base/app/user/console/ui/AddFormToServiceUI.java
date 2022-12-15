package eapli.base.app.user.console.ui;

import eapli.base.form.application.FormController;
import eapli.base.form.application.FormServiceRelationController;
import eapli.base.form.domain.BaseForm;
import eapli.base.form.domain.FormAttribute;
import eapli.base.form.domain.BaseFormId;
import eapli.base.service.application.ServiceController;
import eapli.base.service.domain.Service;
import eapli.framework.io.util.Console;

import java.util.Scanner;

public class AddFormToServiceUI {

    FormController formController = new FormController();
    ServiceController serviceController = new ServiceController();
    FormServiceRelationController formServiceRelationController = new FormServiceRelationController();
    Scanner in = new Scanner(System.in);

    public void showMenu(Service service) {
        String formId;
        String formName;
        String attributeType = "";
        String attributeName;
        String attributeLabel;
        String option;

        System.out.println("============================================");
        System.out.println("Specify a new Form to add to a Service: ");
        System.out.println("============================================\n");

        System.out.println("Please insert the ID of the form you want to create:");
        formId = in.nextLine();
        System.out.println("Please insert the Name of the form you want to create:");
        formName = in.nextLine();

        BaseForm baseForm = new BaseForm(BaseFormId.valueOf(formId), formName);

        do {
            int isMandatory;
            System.out.println("\nDo you want the attribute to be:\n1- Mandatory\n2- Optional\n" +
                    "=================================\n0-Back");
            try {
                isMandatory = in.nextInt();
            }catch(Exception e) {
                System.out.println("Invalid Option!");
                continue;
            }
            if (isMandatory > 2){
                System.out.println("Invalid Option!");
                continue;
            }
            if (isMandatory == 0){
                break;
            }

            in.nextLine();
            System.out.println("\nPlease insert the type of the attribute you want to request: \n" +
                    "Insert \"0\" when all the desired attributes have been added");
            System.out.println("1-String\n2-Integer\n3-Date\n4-Bool\n5-Name\n6-Address\n7-PostalCode\n8-PhoneNumber\n");
            option = in.nextLine();
            option.trim();

            switch(option) {
                case "0":
                    break;
                case "1":
                    if (isMandatory == 1) {
                        attributeType = "String";
                    } else {
                        attributeType = "OptionalString";
                    }
                    break;
                case "2":
                    if (isMandatory == 1) {
                        attributeType = "Integer";
                    } else {
                        attributeType = "OptionalInteger";
                    }
                    break;
                case "3":
                    if (isMandatory == 1) {
                        attributeType = "Date";
                    } else {
                        attributeType = "OptionalDate";
                    }
                    break;
                case "4":
                    if (isMandatory == 1) {
                        attributeType = "Bool";
                    } else {
                        attributeType = "OptionalBool";
                    }
                    break;
                case "5":
                    if (isMandatory == 1) {
                        attributeType = "Name";
                    } else {
                        attributeType = "OptionalName";
                    }
                    break;
                case "6":
                    if (isMandatory == 1) {
                        attributeType = "Address";
                    } else {
                        attributeType = "OptionalAddress";
                    }
                    break;
                case "7":
                    if (isMandatory == 1) {
                        attributeType = "PostalCode";
                    } else {
                        attributeType = "OptionalPostalCode";
                    }
                    break;
                case "8":
                    if (isMandatory == 1) {
                        attributeType = "PhoneNumber";
                    } else {
                        attributeType = "OptionalPhoneNumber";
                    }
                    break;
                default :
                    System.out.println("Error selecting attribute type!");
                    return;
            }

            if (option.equals("0")) {
                break;
            }

            System.out.println("Please insert the name of the attribute you want to request: ");
            attributeName = in.nextLine();
            attributeName.trim();

            System.out.println("Please insert what you want to be displayed when asking the user to fill this field of the Form: ");
            if(isMandatory == 2){
                attributeLabel = in.nextLine()+" (Optional):";
            } else {
                attributeLabel = in.nextLine() + ":";
            }
            baseForm.addAttribute(FormAttribute.valueOf(attributeType, attributeName, attributeLabel));

        } while(true);

        if(!baseForm.getAttributes().isEmpty()) {
            formController.addForm(baseForm);
            serviceController.addFormToService(baseForm, service);
            System.out.println("Form added!");
        } else {
            System.out.println("Leaving");
        }
    }

}
