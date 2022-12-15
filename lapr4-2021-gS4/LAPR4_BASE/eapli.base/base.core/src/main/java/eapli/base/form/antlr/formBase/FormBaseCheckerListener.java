// Generated from C:/Users/pedro/OneDrive/Documentos/Eng.Informática_Projects/2ºAno/LAPR/lapr4-2021-gS4/LAPR4_BASE/eapli.base/base.core/src/main/java/eapli/base/form/antlr/formBase\FormBaseChecker.g4 by ANTLR 4.9.1
package eapli.base.form.antlr.formBase;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormBaseCheckerParser}.
 */
public interface FormBaseCheckerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FormBaseCheckerParser#lprog}.
	 * @param ctx the parse tree
	 */
	void enterLprog(FormBaseCheckerParser.LprogContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormBaseCheckerParser#lprog}.
	 * @param ctx the parse tree
	 */
	void exitLprog(FormBaseCheckerParser.LprogContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormBaseCheckerParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(FormBaseCheckerParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormBaseCheckerParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(FormBaseCheckerParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormBaseCheckerParser#joinedParameters}.
	 * @param ctx the parse tree
	 */
	void enterJoinedParameters(FormBaseCheckerParser.JoinedParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormBaseCheckerParser#joinedParameters}.
	 * @param ctx the parse tree
	 */
	void exitJoinedParameters(FormBaseCheckerParser.JoinedParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormBaseCheckerParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParameterType(FormBaseCheckerParser.ParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormBaseCheckerParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParameterType(FormBaseCheckerParser.ParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormBaseCheckerParser#parameterLabel}.
	 * @param ctx the parse tree
	 */
	void enterParameterLabel(FormBaseCheckerParser.ParameterLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormBaseCheckerParser#parameterLabel}.
	 * @param ctx the parse tree
	 */
	void exitParameterLabel(FormBaseCheckerParser.ParameterLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormBaseCheckerParser#stringPossibilities}.
	 * @param ctx the parse tree
	 */
	void enterStringPossibilities(FormBaseCheckerParser.StringPossibilitiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormBaseCheckerParser#stringPossibilities}.
	 * @param ctx the parse tree
	 */
	void exitStringPossibilities(FormBaseCheckerParser.StringPossibilitiesContext ctx);
}