package eapli.base.form.antlr.formRequestedUnused;

import eapli.base.form.domain.RequestForm;
import eapli.base.form.domain.TaskRequestForm;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AntlrCheckRequestForm {

    public boolean checkRequestForm(RequestForm requestForm) {

        try {
            FileInputStream file = null;
            try {
                file = new FileInputStream(new File("requestForms//" + requestForm.id().toString() + "_requestForm.txt"));
            } catch (FileNotFoundException e) {
                System.out.println("ERROR - FILE");
                e.printStackTrace();
            }
            FormCheckerLexer lexer = null;
            try {
                lexer = new FormCheckerLexer(new ANTLRInputStream(file));
            } catch (IOException e) {
                System.out.println("ERROR - LEXER");
                e.printStackTrace();
            }
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            FormCheckerParser parser = new FormCheckerParser((org.antlr.v4.runtime.TokenStream) tokens);//parse
            FormCheckerParser.LprogContext tree = parser.lprog(); // tree

        } catch (Exception e) {
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
            FormCheckerParser parser = new FormCheckerParser((org.antlr.v4.runtime.TokenStream) tokens);//parse
            FormCheckerParser.LprogContext tree = parser.lprog(); // tree

        } catch (Exception e) {
            System.out.println("NotOk");
            new File("taskForms//" + requestForm.id().toString() + "taskForm.txt").delete();
            return false;
        }
        System.out.println("Ok");
        return true;
    }

    public static void parseWithVisitor(RequestForm requestForm) throws IOException {
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File("requestForms//" + requestForm.id().toString() + "_requestForm.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR - FILE");
            e.printStackTrace();
        }

        FormCheckerLexer lexer = null;
        try {
            lexer = new FormCheckerLexer(new ANTLRInputStream(file));
        } catch (IOException e) {
            System.out.println("ERROR - LEXER");
            e.printStackTrace();
        }
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormCheckerParser parser = new FormCheckerParser(tokens);

        FormCheckerParser.LprogContext tree = parser.lprog(); // tree
        //FormCheckerVisitor eval = new FormCheckerVisitor();
        //eval.visit(tree);
    }


}
