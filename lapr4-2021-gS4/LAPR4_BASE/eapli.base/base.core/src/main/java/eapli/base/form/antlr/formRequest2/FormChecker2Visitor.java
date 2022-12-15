// Generated from C:/Users/Pedro/Documents/lei20_21_s4_2dh_01/LAPR4_BASE/eapli.base/base.core/src/main/java/eapli/base/form/antlr/formRequest2\FormChecker2.g4 by ANTLR 4.9.1
package eapli.base.form.antlr.formRequest2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FormChecker2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FormChecker2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FormChecker2Parser#lprog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLprog(FormChecker2Parser.LprogContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormChecker2Parser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(FormChecker2Parser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormChecker2Parser#allParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllParameters(FormChecker2Parser.AllParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormChecker2Parser#parameterDate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDate(FormChecker2Parser.ParameterDateContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormChecker2Parser#parameterInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterInt(FormChecker2Parser.ParameterIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormChecker2Parser#parameterBool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterBool(FormChecker2Parser.ParameterBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormChecker2Parser#parameterString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterString(FormChecker2Parser.ParameterStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormChecker2Parser#parameterAddress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterAddress(FormChecker2Parser.ParameterAddressContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormChecker2Parser#parameterPhoneNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterPhoneNumber(FormChecker2Parser.ParameterPhoneNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormChecker2Parser#parameterPostalCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterPostalCode(FormChecker2Parser.ParameterPostalCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormChecker2Parser#parameterName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterName(FormChecker2Parser.ParameterNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormChecker2Parser#stringPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringPhrase(FormChecker2Parser.StringPhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormChecker2Parser#error}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitError(FormChecker2Parser.ErrorContext ctx);
}