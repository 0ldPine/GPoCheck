package parse.special.listen;

/////////////////////////////////////////////////////
//                    _ooOoo_                      //
//                   o8888888o                     //    
//                   88" . "88                     //    
//                   (| ^_^ |)                     //    
//                   O\  =  /O                     //
//                ____/`---'\____                  //                        
//              .'  \\|     |//  `.                //
//             /  \\|||  :  |||//  \               //    
//            /  _||||| -:- |||||-  \              //
//            |   | \\\  -  /// |   |              //
//            | \_|  ''\---/''  |   |              //        
//            \  .-\__  `-`  ___/-. /              //        
//          ___`. .'  /--.--\  `. . ___            //    
//        ."" '<  `.___\_<|>_/___.'  >'"".         //
//      | | :  `- \`.;`\ _ /`;.`/ - ` : | |        //    
//      \  \ `-.   \_ __\ /__ _/   .-` /  /        //
//========`-.____`-.___\_____/___.-`____.-'========//    
//                     `=---='                     //
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import common.CONSTANT;
import engine.simple.SimpleMatrix;
import parse.common.GPoMvBaseListener;
import parse.common.GPoMvParser.ExprContext;
import parse.common.GPoMvParser.FileContext;
import parse.common.GPoMvParser.GlobalVarDeclContext;
import parse.common.GPoMvParser.LabelSetContext;
import parse.common.GPoMvParser.LabelStatContext;
import parse.common.GPoMvParser.StateDefineContext;
import parse.common.GPoMvParser.TransferStatContext;
import parse.common.ModelType;
import parse.common.ModulesFile;
import parse.common.Value;
import parse.common.GPoMvParser.ModuleTypeContext;
import parse.common.GPoMvParser.MoudleContext;
import parse.common.GPoMvParser.StatementContext;
import parse.common.GPoMvParser.VarDeclContext;
import util.DebugOut;

public class SimpleGPoMvListener extends GPoMvBaseListener {

	String tmpString = "";

	private int scanCounts = 0;
	private ModulesFile modulesFile = new ModulesFile();

	public ModulesFile getModulesFile() {
		return modulesFile;
	}

	public void setModulesFile(ModulesFile modulesFile) {
		this.modulesFile = modulesFile;
	}

	@Override
	public void enterModuleType(ModuleTypeContext ctx) {
		scanCounts++; // only this add scan count
		if (scanCounts == 1) {
			// scan count equals one
			String modelType = ctx.ID().getText();
			Boolean isRightModelType = true;
			if (ModelType.GPKS.keyword().equals(modelType.toLowerCase())) {
				modulesFile.setModelType(ModelType.GPKS);
			} else {
				DebugOut.println("Model type error! Model \"" + modelType + "\", There is not this model type!", 2);
				isRightModelType = false;
				System.exit(-1);
			}
			if (isRightModelType)
				DebugOut.println("You input model is \"" + modelType.toUpperCase() + "\"", 2);
		} else if (scanCounts == 2) {
			// scan count equals two
		} else if (scanCounts == 3) {
			// scan count equals three
		} else {
			// scan count equals other
		}
		super.enterModuleType(ctx);
	}

	@Override
	public void enterMoudle(MoudleContext ctx) {
		if (scanCounts == 1) {
			// scan count equals one
			String moduleName = ctx.ID().getText();
			modulesFile.getModuleNames().add(moduleName);
			DebugOut.println("Module " + moduleName, 0);
			// String moduleContext = ctx.getText();
			String moduleContext = "";
			List<StatementContext> statements = ctx.statement();
			for (StatementContext sc : statements) {
				DebugOut.println("\t" + sc.getText(), 0);
				moduleContext += "\t" + sc.getText() + "\n";
			}
			// store module context
			modulesFile.getModuleContexts().put(moduleName, moduleContext);
			// store current module
			modulesFile.setCurrentModule(moduleName);
			// store variables
			Map<String, Value<Integer>> varsMap = new HashMap<String, Value<Integer>>();
			modulesFile.getModuleStates().put(moduleName, varsMap);
			// store action set
			List<String> actionList = new ArrayList<String>();
			modulesFile.getModuleLabels().put(moduleName, actionList);
		} else if (scanCounts == 2) {
			// scan count equals two
			String moduleName = ctx.ID().getText();
			// store current module
			modulesFile.setCurrentModule(moduleName);
			// initializing state translate matrix
			int dimension = 0;
			Iterator<Entry<String, Value<Integer>>> moduleVariter = modulesFile.getModuleStates().get(moduleName).entrySet().iterator();
			while (moduleVariter.hasNext()) {
				Entry<String, Value<Integer>> entry = moduleVariter.next();
				dimension = dimension + (entry.getValue().getMax() - entry.getValue().getMin() + 1);
			}
			SimpleMatrix transMatrix = new SimpleMatrix(dimension, dimension, moduleName + "Transfer Matrix");
			moduleVariter = modulesFile.getModuleStates().get(moduleName).entrySet().iterator();
			while (moduleVariter.hasNext()) {
				Entry<String, Value<Integer>> entry = moduleVariter.next();

				for (int i = entry.getValue().getMin(); i <= entry.getValue().getMax(); i++) {
					transMatrix.getColumnNamesList().add(entry.getKey() + i);
					transMatrix.getRowNamesList().add(entry.getKey() + i);
				}

			}
			modulesFile.getModuleTransferMatrix().put(moduleName, transMatrix);
			// initializing state label
			int lableCount = modulesFile.getModuleLabels().get(moduleName).size();
			SimpleMatrix labelMatrix = new SimpleMatrix(dimension, lableCount, moduleName + " Label Matrix");
			moduleVariter = modulesFile.getModuleStates().get(moduleName).entrySet().iterator();
			while (moduleVariter.hasNext()) {
				Entry<String, Value<Integer>> entry = moduleVariter.next();

				for (int i = entry.getValue().getMin(); i <= entry.getValue().getMax(); i++) {
					labelMatrix.getRowNamesList().add(entry.getKey() + i);
				}
			}
			for (int i = 0; i < lableCount; i++) {
				labelMatrix.getColumnNamesList().add(modulesFile.getModuleLabels().get(moduleName).get(i));
			}
			modulesFile.getModuleStateLabelMatrix().put(moduleName, labelMatrix);
		} else if (scanCounts == 3) {
			// scan count equals three
		} else {
			// scan count equals other
		}
		super.enterMoudle(ctx);
	}

	@Override
	public void exitMoudle(MoudleContext ctx) {
		if (scanCounts == 1) {
			// scan count equals one
		} else if (scanCounts == 2) {
			// scan count equals two
		} else if (scanCounts == 3) {
			// scan count equals three
		} else {
			// scan count equals other
		}
		super.exitMoudle(ctx);
	}

	@Override
	public void exitGlobalVarDecl(GlobalVarDeclContext ctx) {
		if (scanCounts == 1) {
			// scan count equals one
			DebugOut.println("Has a global var", 0);
			DebugOut.println("Global Var : " + ctx.ID() + " " + (ctx.varType() == null ? CONSTANT.C_INT : ctx.varType().getText()) + " " + ctx.expr().getText(), 0);
			// modulesFile.getGlobals().put(ctx.ID().toString(), new
			// Value((ctx.varType() == null ? CONSTANT.C_INT :
			// ctx.varType().getText()), ctx.expr().getText()));
		} else if (scanCounts == 2) {
			// scan count equals two

		} else if (scanCounts == 3) {
			// scan count equals three
		} else {
			// scan count equals other
		}
		super.exitGlobalVarDecl(ctx);
	}

	@Override
	public void exitStateDefine(StateDefineContext ctx) {
		if (scanCounts == 1) {
			// scan count equals one
			Value<Integer> state = new Value<Integer>(CONSTANT.C_INT, ctx.expr(2).getText());
			int min = Integer.parseInt(ctx.expr(0).getText());
			int max = Integer.parseInt(ctx.expr(1).getText());
			int init = Integer.parseInt(ctx.expr(2).getText());
			state.setMin(min);
			state.setMax(max);
			// state`s initial value must between minimum and maximum
			if (init < min || init > max) {
				DebugOut.printErrln("state " + ctx.varName().ID().getText() + " init error, out of bound", 2);
				System.exit(-1);
			}
			// put state in ModulefFile->moduleStates
			modulesFile.getModuleStates().get(modulesFile.getCurrentModule()).put(ctx.varName().ID().getText(), state);
		} else if (scanCounts == 2) {
			// scan count equals two
		} else if (scanCounts == 3) {
			// scan count equals three
		} else {
			// scan count equals other
		}
		super.exitStateDefine(ctx);
	}

	@Override
	public void exitTransferStat(TransferStatContext ctx) {
		if (scanCounts == 1) {
			// scan count equals one
		} else if (scanCounts == 2) {
			// scan count equals two
			int numSize = ctx.transferChildStatRight().NUMBER().size();
			int exprSize = ctx.transferChildStatRight().expr().size();
			if (numSize == exprSize) {
				// transfer store start
				// from state name
				String fromStateName = ctx.transferChildStatLeft().expr().expr(0).getText() + ctx.transferChildStatLeft().expr().expr(1).getText();
				// from state`s index in matrix
				int fromStateIndex = modulesFile.getModuleTransferMatrix().get(modulesFile.getCurrentModule()).getColumnNamesList().indexOf(fromStateName);
				for (int i = 0; i < numSize; i++) {
					String toStateName;
					double value = 0.0;
					if (ctx.transferChildStatRight().expr(i).expr().size() != 1) {
						// expr not contine '(' and ')'
						toStateName = ctx.transferChildStatRight().expr(i).expr(0).getText();
						toStateName = toStateName.substring(0, toStateName.length() - 1) + ctx.transferChildStatRight().expr(i).expr(1).getText();
						value = Double.parseDouble(ctx.transferChildStatRight().NUMBER(i).getText());
					} else {
						toStateName = ctx.transferChildStatRight().expr(i).expr(0).expr(0).getText();
						toStateName = toStateName.substring(0, toStateName.length() - 1) + ctx.transferChildStatRight().expr(i).expr(0).expr(1).getText();
						value = Double.parseDouble(ctx.transferChildStatRight().NUMBER(i).getText());
					}
					int toStateIndex = modulesFile.getModuleTransferMatrix().get(modulesFile.getCurrentModule()).getColumnNamesList().indexOf(toStateName);
					modulesFile.getModuleTransferMatrix().get(modulesFile.getCurrentModule()).setContentByIndex(fromStateIndex, toStateIndex, value);
				}
			} else {
				DebugOut.printErrln("state transfer error [" + ctx.transferChildStatLeft().expr().getText() + "] " + numSize + "," + exprSize);
			}
		} else if (scanCounts == 3) {
			// scan count equals three
		} else {
			// scan count equals other
		}
		super.exitTransferStat(ctx);
	}

	@Override
	public void exitLabelSet(LabelSetContext ctx) {
		if (scanCounts == 1) {
			// scan count equals one
			// add module actions
			List<ExprContext> actionExprList = ctx.exprList().expr();
			for (int i = 0; i < actionExprList.size(); i++) {
				modulesFile.getModuleLabels().get(modulesFile.getCurrentModule()).add(actionExprList.get(i).getText());
				if (!modulesFile.getModuleAllLabels().contains(actionExprList.get(i).getText())) {
					modulesFile.getModuleAllLabels().add(actionExprList.get(i).getText());
				}
			}
		} else if (scanCounts == 2) {
			// scan count equals two
		} else if (scanCounts == 3) {
			// scan count equals three
		} else {
			// scan count equals other
		}
		super.exitLabelSet(ctx);
	}

	@Override
	public void exitLabelStat(LabelStatContext ctx) {
		if (scanCounts == 1) {
			// scan count equals one
		} else if (scanCounts == 2) {
			// scan count equals two
			// add every state label
			String stateName = ctx.labelCondition().expr(0).getText() + ctx.labelCondition().expr(1).getText();
			int stateIndex = modulesFile.getModuleStateLabelMatrix().get(modulesFile.getCurrentModule()).getRowNamesList().indexOf(stateName);
			int n = ctx.exprList().expr().size();
			for (int i = 0; i < n; i++) {
				String labelName = ctx.exprList().expr(i).expr(0).getText();
				double value = Double.parseDouble(ctx.exprList().expr(i).expr(1).getText());
				int labelInex = modulesFile.getModuleStateLabelMatrix().get(modulesFile.getCurrentModule()).getColumnNamesList().indexOf(labelName);
				modulesFile.getModuleStateLabelMatrix().get(modulesFile.getCurrentModule()).setContentByIndex(stateIndex, labelInex, value);
			}
		} else if (scanCounts == 3) {
			// scan count equals three
		} else {
			// scan count equals other
		}
		super.exitLabelStat(ctx);
	}

	@Override
	public void enterVarDecl(VarDeclContext ctx) {

		super.enterVarDecl(ctx);
	}

	@Override
	public void exitFile(FileContext ctx) {
		if (scanCounts == 1) {

		} else if (scanCounts == 2) {
			// scan count equals two
			// DebugOut.println(modulesFile.toString(), 0);
		} else if (scanCounts == 3) {
			// scan count equals three
		} else {
			// scan count equals other

		}
		super.exitFile(ctx);
	}

}
