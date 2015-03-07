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

import java.util.List;


import parse.common.GPoMvBaseListener;
import parse.common.GPoMvParser.FileContext;
import parse.common.GPoMvParser.GlobalVarDeclContext;
import parse.common.ModelType;
import parse.common.ModulesFile;
import parse.common.GPoMvParser.ModuleTypeContext;
import parse.common.GPoMvParser.MoudleContext;
import parse.common.GPoMvParser.StatementContext;
import parse.common.GPoMvParser.VarDeclContext;
import util.DebugOut;

public class SimpleDefGPoMvListener extends GPoMvBaseListener {

	String tmpString = "";

	private ModulesFile modulesFile;

	public SimpleDefGPoMvListener(ModulesFile modulesFile) {
		super();
		this.modulesFile = modulesFile;
	}

	@Override
	public void enterFile(FileContext ctx) {
		// TODO Auto-generated method stub
		super.enterFile(ctx);
	}

	@Override
	public void enterModuleType(ModuleTypeContext ctx) {
		// TODO Auto-generated method stub
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

		super.enterModuleType(ctx);
	}

	@Override
	public void enterMoudle(MoudleContext ctx) {
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
		modulesFile.getModuleContexts().put(moduleName, moduleContext);
		super.enterMoudle(ctx);
	}

	@Override
	public void exitMoudle(MoudleContext ctx) {
		// TODO Auto-generated method stub
		super.exitMoudle(ctx);
	}

	@Override
	public void enterGlobalVarDecl(GlobalVarDeclContext ctx) {
		// TODO Auto-generated method stub
		DebugOut.println("Has a global var", 0);
		DebugOut.println("Global Var : " + ctx.ID() + " " + (ctx.varType() == null ? "int" : ctx.varType().getText()) + " " + ctx.expr().getText(), 0);
		// modulesFile.getGlobals().put(ctx.ID().toString(), new
		// Value(ctx.varType().getText(), ctx.expr().getText()));
		super.enterGlobalVarDecl(ctx);
	}

	@Override
	public void exitGlobalVarDecl(GlobalVarDeclContext ctx) {
		// TODO Auto-generated method stub
		super.exitGlobalVarDecl(ctx);
	}

	@Override
	public void enterVarDecl(VarDeclContext ctx) {
		// TODO Auto-generated method stub
		super.enterVarDecl(ctx);
	}


	public ModulesFile getModulesFile() {
		return modulesFile;
	}

	public void setModulesFile(ModulesFile modulesFile) {
		this.modulesFile = modulesFile;
	}
}
