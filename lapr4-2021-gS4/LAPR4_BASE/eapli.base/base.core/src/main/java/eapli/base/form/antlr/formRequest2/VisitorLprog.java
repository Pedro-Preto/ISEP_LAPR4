package eapli.base.form.antlr.formRequest2;

import java.util.ArrayList;
import java.util.List;

public class VisitorLprog extends FormChecker2BaseVisitor<List<String>> {

    private List<String> errors;

    @Override public List<String> visitStart(FormChecker2Parser.StartContext ctx) {
        errors = new ArrayList<>();
        VisitorErrors ve = new VisitorErrors();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (i == ctx.getChildCount()) {
                //Last Child is EOF
            } else {
                try {
                    ve.visit(ctx.getChild(i));
                } catch (Exception e) {

                }
            }
        }
        this.errors = ve.getErrors();
        return errors;
    }

    public List<String> getErrors(){
        return errors;
    }

}
