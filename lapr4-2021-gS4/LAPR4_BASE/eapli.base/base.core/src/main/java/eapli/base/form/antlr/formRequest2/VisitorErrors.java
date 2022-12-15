package eapli.base.form.antlr.formRequest2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class VisitorErrors<T> extends FormChecker2BaseVisitor<T> {

@Override public T visitLprog(FormChecker2Parser.LprogContext ctx) { return visitChildren(ctx); }

	private final int LAST_CHILD = 5;
	private final int QUESTION = 3;

    private static List<String> errors = new ArrayList<>();

	public VisitorErrors() {
	}

	public List<String> getErrors() {
		return errors;
	}

	public List<String> resetErrors() {
		return errors = new ArrayList<>();
	}

	@Override public T visitStart(FormChecker2Parser.StartContext ctx) { return visitChildren(ctx); }

	@Override public T visitAllParameters(FormChecker2Parser.AllParametersContext ctx) { return visitChildren(ctx); }

	@Override public T visitParameterDate(FormChecker2Parser.ParameterDateContext ctx) {
		String optional = ctx.getChild(0).getText();
        String value;
        if (optional.compareToIgnoreCase("Date") == 0) {
			if (ctx.getChildCount() < LAST_CHILD) {
				value = ctx.getChild(QUESTION - 1).getText();
				addErrorOptional(value);
			} else {
            	value = ctx.getChild(LAST_CHILD - 1).getText();
				if (!value.matches("(([0]?[1-9])|([1][0-9])|([2][0-9])|([3][0-1]))")) {
					addErrorFormat(value, "Date (dd)");
				}
				value = ctx.getChild(LAST_CHILD + 1).getText();
				if (!value.matches("(([0]?[1-9])|([1][0-2]))")) {
					addErrorFormat(value, "Date (mm)");
				}
				value = ctx.getChild(LAST_CHILD + 3).getText();
				if (!value.matches("([2-9][0-9][0-9][0-9])")) {
					addErrorFormat(value, "Date (yyyy)");
				}
			}
        } else if (optional.compareToIgnoreCase("OptionalDate") == 0) {
			if (ctx.getChildCount() >= LAST_CHILD) {
				value = ctx.getChild(LAST_CHILD - 1).getText();
				if (!value.matches("(([0]?[1-9])|([1][0-9])|([2][0-9])|([3][0-1]))")) {
					addErrorFormat(value, "Date (dd)");
				}
				value = ctx.getChild(LAST_CHILD + 1).getText();
				if (!value.matches("(([0]?[1-9])|([1][0-2]))")) {
					addErrorFormat(value, "Date (mm)");
				}
				value = ctx.getChild(LAST_CHILD + 3).getText();
				if (!value.matches("([2-9][0-9][0-9][0-9])")) {
					addErrorFormat(value, "Date (yyyy)");
				}
			}
        }
        return visitChildren(ctx); 
    }

	@Override public T visitParameterInt(FormChecker2Parser.ParameterIntContext ctx) {
		String optional = ctx.getChild(0).getText();
		String value;
		if (optional.compareToIgnoreCase("Integer") == 0) {
			if (ctx.getChildCount() < LAST_CHILD) {
				value = ctx.getChild(QUESTION - 1).getText();
				addErrorOptional(value);
			} else {
				value = ctx.getChild(LAST_CHILD - 1).getText();
				if (!value.matches("[0-9]+")) {
					addErrorFormat(value, "Integer");
				}
			}
		} else if (optional.compareToIgnoreCase("OptionalInteger") == 0) {
			if (ctx.getChildCount() >= LAST_CHILD) {
				value = ctx.getChild(LAST_CHILD - 1).getText();
				if (!value.matches("[0-9]+")) {
					addErrorFormat(value, "Integer");
				}
			}
		}
		return visitChildren(ctx);
	}

	@Override public T visitParameterBool(FormChecker2Parser.ParameterBoolContext ctx) {
		String optional = ctx.getChild(0).getText();
		String value;
		if (optional.compareToIgnoreCase("Bool") == 0) {
			if (ctx.getChildCount() < LAST_CHILD) {
				value = ctx.getChild(QUESTION - 1).getText();
				addErrorOptional(value);
			} else {
				value = ctx.getChild(LAST_CHILD - 1).getText();
				if (!value.equals("true") && !value.equals("TRUE") && !value.equals("false") && !value.equals("FALSE")) {
					addErrorFormat(value, "Boolean");
				}
			}
		} else if (optional.compareToIgnoreCase("OptionalBool") == 0) {
			if (ctx.getChildCount() >= LAST_CHILD) {
				value = ctx.getChild(LAST_CHILD - 1).getText();
				if (!value.equals("true") && !value.equals("TRUE") && !value.equals("false") && !value.equals("FALSE")) {
					addErrorFormat(value, "Boolean");
				}
			}
		}
		return visitChildren(ctx); }

	@Override public T visitParameterString(FormChecker2Parser.ParameterStringContext ctx) {
		String optional = ctx.getChild(0).getText();
		String value;
		if (optional.compareToIgnoreCase("String") == 0) {
			if (ctx.getChildCount() < LAST_CHILD) {
				value = ctx.getChild(QUESTION - 1).getText();
				addErrorOptional(value);
			} else {
				for (int i = LAST_CHILD - 1; i < ctx.getChildCount(); i++) {
					value = ctx.getChild(i).getText();
					if (!value.matches("(([A-Za-z0-9]+( |$))*)|$")) {
						addErrorFormat(value, "String");
					}
				}
			}
		} else if (optional.compareToIgnoreCase("OptionalString") == 0) {
			if (ctx.getChildCount() >= LAST_CHILD) {
				for (int i = LAST_CHILD - 1; i < ctx.getChildCount(); i++) {
					value = ctx.getChild(i).getText();
					if (!value.matches("(([A-Za-z0-9]+( |$))*)|$")) {
						addErrorFormat(value, "String");
					}
				}
			}
		}
		return visitChildren(ctx); }

	@Override public T visitParameterAddress(FormChecker2Parser.ParameterAddressContext ctx) {
		String optional = ctx.getChild(0).getText();
		String value;
		if (optional.compareToIgnoreCase("Address") == 0) {
			if (ctx.getChildCount() < LAST_CHILD) {
				value = ctx.getChild(QUESTION - 1).getText();
				addErrorOptional(value);
			} else {
				for (int i = LAST_CHILD - 1; i < ctx.getChildCount(); i++) {
					value = ctx.getChild(LAST_CHILD - 1).getText();
					if (!value.matches("(([A-Za-z0-9]+( |$))*)|$")) {
						addErrorFormat(value, "Address");
					}
				}
			}
		} else if (optional.compareToIgnoreCase("OptionalAddress") == 0) {
			if (ctx.getChildCount() >= LAST_CHILD) {
				for (int i = LAST_CHILD - 1; i < ctx.getChildCount(); i++) {
					value = ctx.getChild(LAST_CHILD - 1).getText();
					if (!value.matches("(([A-Za-z0-9]+( |$))*)|$")) {
						addErrorFormat(value, "Address");
					}
				}
			}
		}


		return visitChildren(ctx); }

	@Override public T visitParameterPhoneNumber(FormChecker2Parser.ParameterPhoneNumberContext ctx) {
		String optional = ctx.getChild(0).getText();
		String value;
		if (optional.compareToIgnoreCase("PhoneNumber") == 0) {
			if (ctx.getChildCount() < LAST_CHILD) {
				value = ctx.getChild(QUESTION - 1).getText();
				addErrorOptional(value);
			} else {
				value = ctx.getChild(LAST_CHILD - 1).getText();
				if (!value.matches("([9]|[2])[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")) {
					addErrorFormat(value, "PhoneNumber");
				}
			}
		} else if (optional.compareToIgnoreCase("OptionalPhoneNumber") == 0) {
			if (ctx.getChildCount() >= LAST_CHILD) {
				value = ctx.getChild(LAST_CHILD - 1).getText();
				if (!value.matches("([9]|[2])[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")) {
					addErrorFormat(value, "PhoneNumber");
				}
			}
		}
		return visitChildren(ctx);
	}

	@Override public T visitParameterPostalCode(FormChecker2Parser.ParameterPostalCodeContext ctx) {
		String optional = ctx.getChild(0).getText();
		String value;
		if (optional.compareToIgnoreCase("PostalCode") == 0) {
			if (ctx.getChildCount() < LAST_CHILD) {
				value = ctx.getChild(QUESTION - 1).getText();
				addErrorOptional(value);
			} else {
				value = ctx.getChild(LAST_CHILD - 1).getText();
				if (!value.matches("[0-9][0-9][0-9][0-9]")) {
					addErrorFormat(value, "PostalCode (nnnn)");
				}
				value = ctx.getChild(LAST_CHILD + 1).getText();
				if (!value.matches("[0-9][0-9][0-9]")) {
					addErrorFormat(value, "PostalCode (-nnn)");
				}
			}
		} else if (optional.compareToIgnoreCase("OptionalPostalCode") == 0) {
			if (ctx.getChildCount() >= LAST_CHILD) {
				value = ctx.getChild(LAST_CHILD - 1).getText();
				if (!value.matches("[0-9][0-9][0-9][0-9]")) {
					addErrorFormat(value, "PostalCode (nnnn)");
				}
				value = ctx.getChild(LAST_CHILD + 1).getText();
				if (!value.matches("[0-9][0-9][0-9]")) {
					addErrorFormat(value, "PostalCode (-nnn)");
				}
			}
		}
		return visitChildren(ctx);
	}

	@Override public T visitParameterName(FormChecker2Parser.ParameterNameContext ctx) {
		String optional = ctx.getChild(0).getText();
		String value;
		if (optional.compareToIgnoreCase("Name") == 0) {
			if (ctx.getChildCount() < LAST_CHILD) {
				value = ctx.getChild(QUESTION - 1).getText();
				addErrorOptional(value);
			} else {
				for (int i = LAST_CHILD - 1; i < ctx.getChildCount(); i++) {
					value = ctx.getChild(i).getText();
					if (!value.matches("(([A-Z][a-z]+( |$))*)|$")) {
						addErrorFormat(value, "Name");
					}
				}
			}
		} else if (optional.compareToIgnoreCase("OptionalName") == 0) {
			if (ctx.getChildCount() >= LAST_CHILD) {
				for (int i = LAST_CHILD - 1; i < ctx.getChildCount(); i++) {
					value = ctx.getChild(i).getText();
					if (!value.matches("(([A-Z][a-z]+( |$))*)|$")) {
						addErrorFormat(value, "Name");
					}
				}
			}
		}
		return visitChildren(ctx);
	}

	@Override public T visitStringPhrase(FormChecker2Parser.StringPhraseContext ctx) { return visitChildren(ctx); }

	public void addErrorOptional(String value) {
		String stringError = "ERROR: The parameter " + value + " wasn't optional, but didn't have value.";
		errors.add(stringError);
		print(stringError);
	}

	public void addErrorFormat(String value, String type) {
		String stringError = "ERROR: " + value + " wasn't in the right format, it should be " + type + ".";
		errors.add(stringError);
		print(stringError);
	}

	private void print(String error) {
		System.out.println(error);
	}

}