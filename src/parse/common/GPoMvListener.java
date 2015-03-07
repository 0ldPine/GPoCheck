// Generated from GPoMv.g4 by ANTLR 4.4
package parse.common;
   
import java.util.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GPoMvParser}.
 */
public interface GPoMvListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#labelSet}.
	 * @param ctx the parse tree
	 */
	void enterLabelSet(@NotNull GPoMvParser.LabelSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#labelSet}.
	 * @param ctx the parse tree
	 */
	void exitLabelSet(@NotNull GPoMvParser.LabelSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#globalVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVarDecl(@NotNull GPoMvParser.GlobalVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#globalVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVarDecl(@NotNull GPoMvParser.GlobalVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#moduleType}.
	 * @param ctx the parse tree
	 */
	void enterModuleType(@NotNull GPoMvParser.ModuleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#moduleType}.
	 * @param ctx the parse tree
	 */
	void exitModuleType(@NotNull GPoMvParser.ModuleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#labelStat}.
	 * @param ctx the parse tree
	 */
	void enterLabelStat(@NotNull GPoMvParser.LabelStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#labelStat}.
	 * @param ctx the parse tree
	 */
	void exitLabelStat(@NotNull GPoMvParser.LabelStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#transferChildStatLeft}.
	 * @param ctx the parse tree
	 */
	void enterTransferChildStatLeft(@NotNull GPoMvParser.TransferChildStatLeftContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#transferChildStatLeft}.
	 * @param ctx the parse tree
	 */
	void exitTransferChildStatLeft(@NotNull GPoMvParser.TransferChildStatLeftContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#varEnd}.
	 * @param ctx the parse tree
	 */
	void enterVarEnd(@NotNull GPoMvParser.VarEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#varEnd}.
	 * @param ctx the parse tree
	 */
	void exitVarEnd(@NotNull GPoMvParser.VarEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(@NotNull GPoMvParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(@NotNull GPoMvParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull GPoMvParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull GPoMvParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull GPoMvParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull GPoMvParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(@NotNull GPoMvParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(@NotNull GPoMvParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#stateDefine}.
	 * @param ctx the parse tree
	 */
	void enterStateDefine(@NotNull GPoMvParser.StateDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#stateDefine}.
	 * @param ctx the parse tree
	 */
	void exitStateDefine(@NotNull GPoMvParser.StateDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull GPoMvParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull GPoMvParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#moudle}.
	 * @param ctx the parse tree
	 */
	void enterMoudle(@NotNull GPoMvParser.MoudleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#moudle}.
	 * @param ctx the parse tree
	 */
	void exitMoudle(@NotNull GPoMvParser.MoudleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(@NotNull GPoMvParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(@NotNull GPoMvParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(@NotNull GPoMvParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(@NotNull GPoMvParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(@NotNull GPoMvParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(@NotNull GPoMvParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#transferStat}.
	 * @param ctx the parse tree
	 */
	void enterTransferStat(@NotNull GPoMvParser.TransferStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#transferStat}.
	 * @param ctx the parse tree
	 */
	void exitTransferStat(@NotNull GPoMvParser.TransferStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#varInit}.
	 * @param ctx the parse tree
	 */
	void enterVarInit(@NotNull GPoMvParser.VarInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#varInit}.
	 * @param ctx the parse tree
	 */
	void exitVarInit(@NotNull GPoMvParser.VarInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#varStart}.
	 * @param ctx the parse tree
	 */
	void enterVarStart(@NotNull GPoMvParser.VarStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#varStart}.
	 * @param ctx the parse tree
	 */
	void exitVarStart(@NotNull GPoMvParser.VarStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#transferChildStatRight}.
	 * @param ctx the parse tree
	 */
	void enterTransferChildStatRight(@NotNull GPoMvParser.TransferChildStatRightContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#transferChildStatRight}.
	 * @param ctx the parse tree
	 */
	void exitTransferChildStatRight(@NotNull GPoMvParser.TransferChildStatRightContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#labelCondition}.
	 * @param ctx the parse tree
	 */
	void enterLabelCondition(@NotNull GPoMvParser.LabelConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#labelCondition}.
	 * @param ctx the parse tree
	 */
	void exitLabelCondition(@NotNull GPoMvParser.LabelConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(@NotNull GPoMvParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(@NotNull GPoMvParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GPoMvParser#transLable}.
	 * @param ctx the parse tree
	 */
	void enterTransLable(@NotNull GPoMvParser.TransLableContext ctx);
	/**
	 * Exit a parse tree produced by {@link GPoMvParser#transLable}.
	 * @param ctx the parse tree
	 */
	void exitTransLable(@NotNull GPoMvParser.TransLableContext ctx);
}