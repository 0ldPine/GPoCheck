package parse.special.listen;

import common.CONSTANT;
import parse.common.GPoPropBaseListener;
import parse.common.GPoPropParser.ExprContext;
import parse.common.GPoPropParser.PathFormulaeContext;
import parse.common.GPoPropParser.PropertiesContext;
import parse.common.GPoPropParser.StateFormulaeContext;
import parse.common.ModulesFile;
import parse.common.GPoProperty;
import parse.type.GPoPropertyType;
import parse.type.OperateInfo;
import parse.type.Value;
import util.DebugOut;

public class SimpleGPoPropertiesMvListener extends GPoPropBaseListener {

	// grun parse.common.GPoProp file -gui D:\SVNStation\GPoCheck_V0.2\files\li1.poctl

	private ModulesFile modulesFile = null;

	private GPoProperty tmpGPoProperty = null;

	private OperateInfo tmpOperateInfo = null;

	/**
	 * only test function,not use
	 */
	public SimpleGPoPropertiesMvListener() {
		super();
	}

	public SimpleGPoPropertiesMvListener(ModulesFile modulesFile) {
		super();
		this.modulesFile = modulesFile;
	}

	@Override
	public void enterProperties(PropertiesContext ctx) {
		super.enterProperties(ctx);
		if (null == ctx.propertyCondition()) {
			// no condition,this is calculate value
			tmpGPoProperty = new GPoProperty(GPoPropertyType.Type.POCALCVALUE, ctx.getText());
		} else {
			tmpGPoProperty = new GPoProperty(GPoPropertyType.Type.POCONDITION, ctx.getText());
			tmpGPoProperty.setConditionOperate(ctx.propertyCondition().conditionOperate().getText());
			tmpGPoProperty.setConditionValue(Double.parseDouble(ctx.propertyCondition().conditionValue().getText()));
		}
	}

	@Override
	public void exitProperties(PropertiesContext ctx) {
		super.exitProperties(ctx);
		modulesFile.getProperties().add(tmpGPoProperty);
	}

	@Override
	public void enterStateFormulae(StateFormulaeContext ctx) {
		super.enterStateFormulae(ctx);
		String stateFomulaType = ctx.getChild(0).getClass().toString().split("\\$")[1];
		if (stateFomulaType.equals(CONSTANT.C_POPROP)) {
			tmpOperateInfo = new OperateInfo();
			tmpOperateInfo.operator = CONSTANT.C_SHORT_POPROP;
			tmpOperateInfo.operand.add(new Value(ctx.poProp().pathFormulae().getClass().toString().split("\\$")[1], ctx.poProp().pathFormulae().getText()));
			tmpGPoProperty.getProInfoStack().push(tmpOperateInfo);
		} else if (stateFomulaType.equals(CONSTANT.C_POTRUE)) {
			tmpOperateInfo = new OperateInfo();
			tmpOperateInfo.operator = CONSTANT.C_SHORT_POTRUE;
			tmpOperateInfo.operand.add(new Value(ctx.poctl_true().POCTL_TRUE().getClass().toString().split("\\$")[1], ctx.poctl_true().POCTL_TRUE().getText()));
			tmpGPoProperty.getProInfoStack().push(tmpOperateInfo);
		} else if (stateFomulaType.equals(CONSTANT.C_NEGATION)) {
			tmpOperateInfo = new OperateInfo();
			tmpOperateInfo.operator = CONSTANT.C_SHORT_NEGATION;
			tmpOperateInfo.operand.add(new Value(ctx.negationProp().stateFormulae().getClass().toString().split("\\$")[1], ctx.negationProp().stateFormulae().getText()));
			tmpGPoProperty.getProInfoStack().push(tmpOperateInfo);
		} else if (stateFomulaType.equals(CONSTANT.C_ANDPROP)) {
			tmpOperateInfo = new OperateInfo();
			tmpOperateInfo.operator = CONSTANT.C_SHORT_ANDPROP;
			for (int i = 0; i < ctx.andProp().stateFormulae().size(); i++) {
				tmpOperateInfo.operand.add(new Value(ctx.andProp().stateFormulae(i).getClass().toString().split("\\$")[1], ctx.andProp().stateFormulae().get(i).getText()));
			}
			tmpGPoProperty.getProInfoStack().push(tmpOperateInfo);
		} else if (stateFomulaType.equals(CONSTANT.C_ORPROP)) {
			tmpOperateInfo = new OperateInfo();
			tmpOperateInfo.operator = CONSTANT.C_SHORT_ORPROP;
			for (int i = 0; i < ctx.orProp().stateFormulae().size(); i++) {
				tmpOperateInfo.operand.add(new Value(ctx.orProp().stateFormulae(i).getClass().toString().split("\\$")[1], ctx.orProp().stateFormulae().get(i).getText()));
			}
			tmpGPoProperty.getProInfoStack().push(tmpOperateInfo);
		} else if (stateFomulaType.equals(CONSTANT.C_EXPRPROP)) {
			tmpOperateInfo = new OperateInfo();
			tmpOperateInfo.operator = CONSTANT.C_SHORT_EXPRPROP;
			tmpOperateInfo.operand.add(new Value(ctx.expr().getClass().toString().split("\\$")[1], ctx.expr().getText()));
			tmpGPoProperty.getProInfoStack().push(tmpOperateInfo);
		} else {
			DebugOut.printErrln("NULL " + ctx.getText(), 0);
		}

	}

	@Override
	public void enterPathFormulae(PathFormulaeContext ctx) {
		super.enterPathFormulae(ctx);
		// System.out.println(ctx.getText());
		String pathFomulaType = ctx.getChild(0).getClass().toString().split("\\$")[1];
		if (pathFomulaType.equals(CONSTANT.C_NEXTPROP)) {
			tmpOperateInfo = new OperateInfo();
			tmpOperateInfo.operator = CONSTANT.C_SHORT_NEXTPROP;
			tmpOperateInfo.operand.add(new Value(ctx.nextChildProp().stateFormulae().getClass().toString().split("\\$")[1], ctx.nextChildProp().stateFormulae().getText()));
			tmpGPoProperty.getProInfoStack().push(tmpOperateInfo);
		} else if (pathFomulaType.equals(CONSTANT.C_ALWAYPROP)) {
			tmpOperateInfo = new OperateInfo();
			tmpOperateInfo.operator = CONSTANT.C_SHORT_ALWAYPROP;
			tmpOperateInfo.operand.add(new Value(ctx.alwaysProp().stateFormulae().getClass().toString().split("\\$")[1], ctx.alwaysProp().stateFormulae().getText()));
			tmpGPoProperty.getProInfoStack().push(tmpOperateInfo);
		} else if (pathFomulaType.equals(CONSTANT.C_UNTIL)) {
			tmpOperateInfo = new OperateInfo();
			tmpOperateInfo.operator = CONSTANT.C_SHORT_UNTIL;
			for (int i = 0; i < ctx.untilChildProp().stateFormulae().size(); i++) {
				tmpOperateInfo.operand.add(new Value(ctx.untilChildProp().stateFormulae(i).getClass().toString().split("\\$")[1], ctx.untilChildProp().stateFormulae(i).getText()));
			}
			tmpGPoProperty.getProInfoStack().push(tmpOperateInfo);
		} else if (pathFomulaType.equals(CONSTANT.C_EVENTUALLYPROP)) {
			tmpOperateInfo = new OperateInfo();
			tmpOperateInfo.operator = CONSTANT.C_SHORT_EVENTUALLYPROP;
			tmpOperateInfo.operand.add(new Value(ctx.eventuallyProp().stateFormulae().getClass().toString().split("\\$")[1], ctx.eventuallyProp().stateFormulae().getText()));
			tmpGPoProperty.getProInfoStack().push(tmpOperateInfo);
		} else {
			DebugOut.printErrln("NULL " + ctx.getText(), 0);
		}
	}

	@Override
	public void enterExpr(ExprContext ctx) {
		super.enterExpr(ctx);
		if (!modulesFile.getModuleAllLabels().contains(ctx.getText())) {
			DebugOut.printErrln("No this lable : " + ctx.getText());
			System.exit(-1);
		}
	}

	public ModulesFile getModulesFile() {
		return modulesFile;
	}

	public void setModulesFile(ModulesFile modulesFile) {
		this.modulesFile = modulesFile;
	}

}
