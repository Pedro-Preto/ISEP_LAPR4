// Generated from C:/Users/pedro/OneDrive/Documentos/Eng.Informática_Projects/2ºAno/LAPR/lapr4-2021-gS4/LAPR4_BASE/eapli.base/base.core/src/main/java/eapli/base/form/antlr/formRequested\FormChecker.g4 by ANTLR 4.9.1
package eapli.base.form.antlr.formRequestedUnused;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FormCheckerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FormCheckerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#lprog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLprog(FormCheckerParser.LprogContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(FormCheckerParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#allParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllParameters(FormCheckerParser.AllParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterDate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDate(FormCheckerParser.ParameterDateContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterOptionalDate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterOptionalDate(FormCheckerParser.ParameterOptionalDateContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterInt(FormCheckerParser.ParameterIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterOptionalInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterOptionalInt(FormCheckerParser.ParameterOptionalIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterBool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterBool(FormCheckerParser.ParameterBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterOptionalBool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterOptionalBool(FormCheckerParser.ParameterOptionalBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterString(FormCheckerParser.ParameterStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterOptionalString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterOptionalString(FormCheckerParser.ParameterOptionalStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterAddress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterAddress(FormCheckerParser.ParameterAddressContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterOptionalAddress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterOptionalAddress(FormCheckerParser.ParameterOptionalAddressContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterPhoneNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterPhoneNumber(FormCheckerParser.ParameterPhoneNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterOptionalPhoneNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterOptionalPhoneNumber(FormCheckerParser.ParameterOptionalPhoneNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterPostalCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterPostalCode(FormCheckerParser.ParameterPostalCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterOptionalPostalCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterOptionalPostalCode(FormCheckerParser.ParameterOptionalPostalCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterName(FormCheckerParser.ParameterNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#parameterOptionalName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterOptionalName(FormCheckerParser.ParameterOptionalNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#namePossibility}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamePossibility(FormCheckerParser.NamePossibilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#addressPosibility}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddressPosibility(FormCheckerParser.AddressPosibilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#stringPossibility}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringPossibility(FormCheckerParser.StringPossibilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#booleano}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleano(FormCheckerParser.BooleanoContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#optionalDate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalDate(FormCheckerParser.OptionalDateContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#optionalName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalName(FormCheckerParser.OptionalNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#optionalAddress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalAddress(FormCheckerParser.OptionalAddressContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#optionalPostalCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalPostalCode(FormCheckerParser.OptionalPostalCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#optionalString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalString(FormCheckerParser.OptionalStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#optionalBool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalBool(FormCheckerParser.OptionalBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#optionalInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalInt(FormCheckerParser.OptionalIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormCheckerParser#optionalPhoneNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalPhoneNumber(FormCheckerParser.OptionalPhoneNumberContext ctx);
}