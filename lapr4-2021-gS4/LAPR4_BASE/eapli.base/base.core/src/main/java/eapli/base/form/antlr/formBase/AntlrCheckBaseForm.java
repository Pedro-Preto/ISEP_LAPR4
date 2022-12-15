package eapli.base.form.antlr.formBase;

import eapli.base.form.domain.BaseForm;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AntlrCheckBaseForm {

    public boolean checkBaseForm(BaseForm baseForm) {

        try {
            FileInputStream file = null;
            try {
                file = new FileInputStream(new File("baseForms//" + baseForm.id().toString() + "_baseForm.txt"));
            } catch (FileNotFoundException e) {
                System.out.println("ERROR - FILE");
                e.printStackTrace();
            }
            FormBaseCheckerLexer lexer = null;
            try {
                lexer = new FormBaseCheckerLexer(new ANTLRInputStream(file));
            } catch (IOException e) {
                System.out.println("ERROR - LEXER");
                e.printStackTrace();
            }
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            FormBaseCheckerParser parser = new FormBaseCheckerParser((org.antlr.v4.runtime.TokenStream) tokens);//parse
            FormBaseCheckerParser.LprogContext tree = parser.lprog(); // tree

        } catch (Exception e) {
            System.out.println("NotOk");
            new File("baseForms//" + baseForm.id().toString() + "_baseForm.txt").delete();
            return false;
        }
        System.out.println("Ok");
        return true;
    }
}
