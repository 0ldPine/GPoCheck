// Generated from GPoProp.g4 by ANTLR 4.4
package parse.common;
   


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GPoPropParser}.
 */
public interface GPoPropListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#negationProp}.
	 * @param ctx the parse tree
	 */
	void enterNegationProp(@NotNull GPoPropParser.NegationPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#negationProp}.
	 * @param ctx the parse tree
	 */
	void exitNegationProp(@NotNull GPoPropParser.NegationPropContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#alwaysProp}.
	 * @param ctx the parse tree
	 */
	void enterAlwaysProp(@NotNull GPoPropParser.AlwaysPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#alwaysProp}.
	 * @param ctx the parse tree
	 */
	void exitAlwaysProp(@NotNull GPoPropParser.AlwaysPropContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#orProp}.
	 * @param ctx the parse tree
	 */
	void enterOrProp(@NotNull GPoPropParser.OrPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#orProp}.
	 * @param ctx the parse tree
	 */
	void exitOrProp(@NotNull GPoPropParser.OrPropContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#propertyCondition}.
	 * @param ctx the parse tree
	 */
	void enterPropertyCondition(@NotNull GPoPropParser.PropertyConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#propertyCondition}.
	 * @param ctx the parse tree
	 */
	void exitPropertyCondition(@NotNull GPoPropParser.PropertyConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#andProp}.
	 * @param ctx the parse tree
	 */
	void enterAndProp(@NotNull GPoPropParser.AndPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#andProp}.
	 * @param ctx the parse tree
	 */
	void exitAndProp(@NotNull GPoPropParser.AndPropContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#poProp}.
	 * @param ctx the parse tree
	 */
	void enterPoProp(@NotNull GPoPropParser.PoPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#poProp}.
	 * @param ctx the parse tree
	 */
	void exitPoProp(@NotNull GPoPropParser.PoPropContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#eventuallyProp}.
	 * @param ctx the parse tree
	 */
	void enterEventuallyProp(@NotNull GPoPropParser.EventuallyPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#eventuallyProp}.
	 * @param ctx the parse tree
	 */
	void exitEventuallyProp(@NotNull GPoPropParser.EventuallyPropContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull GPoPropParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull GPoPropParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#properties}.
	 * @param ctx the parse tree
	 */
	void enterProperties(@NotNull GPoPropParser.PropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#properties}.
	 * @param ctx the parse tree
	 */
	void exitProperties(@NotNull GPoPropParser.PropertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void enterPathFormulae(@NotNull GPoPropParser.PathFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void exitPathFormulae(@NotNull GPoPropParser.PathFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#conditionValue}.
	 * @param ctx the parse tree
	 */
	void enterConditionValue(@NotNull GPoPropParser.ConditionValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#conditionValue}.
	 * @param ctx the parse tree
	 */
	void exitConditionValue(@NotNull GPoPropParser.ConditionValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#conditionOperate}.
	 * @param ctx the parse tree
	 */
	void enterConditionOperate(@NotNull GPoPropParser.ConditionOperateContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#conditionOperate}.
	 * @param ctx the parse tree
	 */
	void exitConditionOperate(@NotNull GPoPropParser.ConditionOperateContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(@NotNull GPoPropParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(@NotNull GPoPropParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#poctl_true}.
	 * @param ctx the parse tree
	 */
	void enterPoctl_true(@NotNull GPoPropParser.Poctl_trueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#poctl_true}.
	 * @param ctx the parse tree
	 */
	void exitPoctl_true(@NotNull GPoPropParser.Poctl_trueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#untilChildProp}.
	 * @param ctx the parse tree
	 */
	void enterUntilChildProp(@NotNull GPoPropParser.UntilChildPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#untilChildProp}.
	 * @param ctx the parse tree
	 */
	void exitUntilChildProp(@NotNull GPoPropParser.UntilChildPropContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void enterStateFormulae(@NotNull GPoPropParser.StateFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void exitStateFormulae(@NotNull GPoPropParser.StateFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoPropParser#nextChildProp}.
	 * @param ctx the parse tree
	 */
	void enterNextChildProp(@NotNull GPoPropParser.NextChildPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoPropParser#nextChildProp}.
	 * @param ctx the parse tree
	 */
	void exitNextChildProp(@NotNull GPoPropParser.NextChildPropContext ctx);
}