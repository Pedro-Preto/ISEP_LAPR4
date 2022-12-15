// Generated from C:/Users/pedro/OneDrive/Documentos/Eng.Informática_Projects/2ºAno/LAPR/lapr4-2021-gS4/LAPR4_BASE/eapli.base/base.core/src/main/java/eapli/base/form/antlr/formBase\FormBaseChecker.g4 by ANTLR 4.9.1
package eapli.base.form.antlr.formBase;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FormBaseCheckerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FormBaseCheckerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FormBaseCheckerParser#lprog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLprog(FormBaseCheckerParser.LprogContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormBaseCheckerParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(FormBaseCheckerParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormBaseCheckerParser#joinedParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinedParameters(FormBaseCheckerParser.JoinedParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormBaseCheckerParser#parameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterType(FormBaseCheckerParser.ParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormBaseCheckerParser#parameterLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterLabel(FormBaseCheckerParser.ParameterLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormBaseCheckerParser#stringPossibilities}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringPossibilities(FormBaseCheckerParser.StringPossibilitiesContext ctx);
}