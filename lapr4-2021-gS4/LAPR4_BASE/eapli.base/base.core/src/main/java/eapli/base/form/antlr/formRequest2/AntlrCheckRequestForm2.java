package eapli.base.form.antlr.formRequest2;

import eapli.base.form.antlr.formRequestedUnused.FormCheckerLexer;
import eapli.base.form.antlr.formRequestedUnused.FormCheckerParser;
import eapli.base.form.domain.RequestForm;
import eapli.base.form.domain.TaskRequestForm;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AntlrCheckRequestForm2 {

    public boolean checkRequestForm(RequestForm requestForm) {
        boolean wellWritten = true;
        try {
            FileInputStream file = null;
            try {
                file = new FileInputStream(new File("requestForms//" + requestForm.id().toString() + "_requestForm.txt"));
            } catch (FileNotFoundException e) {
                System.out.println("ERROR - FILE");
                e.printStackTrace();
            }
            FormChecker2Lexer lexer = null;
            try {
                lexer = new FormChecker2Lexer(new ANTLRInputStream(file));
            } catch (IOException e) {
                System.out.println("ERROR - LEXER");
                e.printStackTrace();
            }
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            FormChecker2Parser parser = new FormChecker2Parser(tokens);//parse
            FormChecker2Parser.LprogContext tree = parser.lprog(); // tree

            VisitorLprog vLprog = new VisitorLprog();
            vLprog.visit(tree);
            List<String> listErrors = new ArrayList<>();
            try {
                listErrors = vLprog.getErrors();
            } catch(Exception e) {
            }

            if (!listErrors.isEmpty()) {
                wellWritten = false;
                /*
                for (String s: listErrors) {
                    System.out.println(s);
                }
                */
            }
            VisitorErrors visitorErrors = new VisitorErrors();
            visitorErrors.resetErrors();

        } catch (Exception e) {
            wellWritten = false;
        }
        if (!wellWritten) {
            System.out.println("NotOk");
            new File("requestForms//" + requestForm.id().toString() + "_requestForm.txt").delete();
            return false;
        }
        System.out.println("Ok");
        return true;
    }


    public boolean checkTaskRequestForm(TaskRequestForm requestForm) {

        try {
            FileInputStream file = null;
            try {
                file = new FileInputStream(new File("taskForms//" + requestForm.id().toString() + "taskForm.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            FormCheckerLexer lexer = null;
            try {
                lexer = new FormCheckerLexer(new ANTLRInputStream(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            FormCheckerParser parser = new FormCheckerParser((TokenStream) tokens);//parse
            FormCheckerParser.LprogContext tree = parser.lprog(); // tree

        } catch (Exception e) {
            System.out.println("NotOk");
            new File("taskForms//" + requestForm.id().toString() + "taskForm.txt").delete();
            return false;
        }
        System.out.println("Ok");
        return true;
    }

}
