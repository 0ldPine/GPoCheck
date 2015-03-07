package engine.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.CONSTANT;
import engine.fixpoint.FixPoint;
import parse.common.GPoProperty;
import parse.common.ModulesFile;
import parse.type.GPoPropertyType;
import parse.type.OperateInfo;
import parse.type.Value;
import util.DebugOut;

/**
 * Validate Properties use simple matrix,but state formula A(Always) must use fix point algorithm
 * 
 * @author Administrator
 *
 */
public class SimpleMatrixValidate {

	private ModulesFile modulesFile = null;
	private List<GPoProperty> properties;

	public SimpleMatrixValidate() {
		super();
	}

	public SimpleMatrixValidate(ModulesFile modulesFile) {
		super();
		this.modulesFile = modulesFile;
	}

	private OperateInfo getOperateInfoWithColVector(SimpleMatrix sm, int col) {
		Value value = new Value("SimpleMatrix", sm.getSimpleMatrixByCol(col));
		ArrayList<Value> al = new ArrayList<Value>();
		al.add(value);
		OperateInfo reslutOperateInfo = new OperateInfo("colVector", al);
		return reslutOperateInfo;
	}

	private OperateInfo getOperateInfo(SimpleMatrix sm) {
		Value value = new Value("SimpleMatrix", sm);
		ArrayList<Value> al = new ArrayList<Value>();
		al.add(value);
		OperateInfo reslutOperateInfo = new OperateInfo("colVector", al);
		return reslutOperateInfo;
	}

	/**
	 * execute validate
	 */
	public ModulesFile execute() {
		properties = modulesFile.getProperties();
		for (int i = 0; i < properties.size(); i++) {

			// Now only calc first module
			// Transfer Matrix
			SimpleMatrix moduleTransferMatrix = modulesFile.getModuleTransferMatrix().get(modulesFile.getModuleNames().get(0));
			// Labels Matrix
			SimpleMatrix moduleStateLabelMatrix = modulesFile.getModuleStateLabelMatrix().get(modulesFile.getModuleNames().get(0));
			// Temporary Matrix in order to calculate φ
			// SimpleMatrix calcLabelMatrix = new SimpleMatrix(moduleStateLabelMatrix.getRows(), 1, "CalcLabelMatrix");
			// calcLabelMatrix.setContentToValue(1);

			// result
			SimpleMatrix resultMatrix = null;

			// before current operate
			String beforeOperate = "";

			// Property info stack
			Stack<OperateInfo> proInfoStack = properties.get(i).getProInfoStack();
			// Temporary property info stack
			Stack<OperateInfo> tmpProInfoStack = new Stack<OperateInfo>();
			// current operate type
			GPoPropertyType.Type proType = properties.get(i).getType();

			while (proInfoStack.size() != 0) {
				// operate info pop
				OperateInfo operateInfo = proInfoStack.pop();
				if (operateInfo.operator.equals(CONSTANT.C_SHORT_EXPRPROP)) {
					// all put in tmpProInfoStack
					tmpProInfoStack.push(operateInfo);
					beforeOperate = CONSTANT.C_SHORT_EXPRPROP;
				} else {
					if (operateInfo.operator.equals(CONSTANT.C_SHORT_ANDPROP)) {
						int operandNum = operateInfo.operand.size();
						SimpleMatrix tmpSM = new SimpleMatrix(moduleStateLabelMatrix.getRows(), 1);
						tmpSM.setContentToValue(1);
						if (operandNum <= tmpProInfoStack.size()) {
							while (operandNum > 0) {
								operandNum--;
								OperateInfo tmpOI = tmpProInfoStack.pop();
								// is result with other operate,for example: negation operate
								if (tmpOI.operator.equals("colVector")) {
									tmpSM = tmpSM.calcAnd((SimpleMatrix) tmpOI.operand.get(0).value);
								} else { // initial value ,and not use it
									int index = moduleStateLabelMatrix.getColumnNamesList().indexOf((String) tmpOI.operand.get(0).value);
									tmpSM = tmpSM.calcAnd(moduleStateLabelMatrix.getSimpleMatrixByCol(index));
								}
							}
							OperateInfo reslutOperateInfo = getOperateInfoWithColVector(tmpSM, 0);
							tmpProInfoStack.push(reslutOperateInfo);
						} else {
							DebugOut.printErrln("Less operand in C_SHORT_ANDPROP", DebugOut.Degree_ERROR);
						}
						beforeOperate = CONSTANT.C_SHORT_ANDPROP;
					} else if (operateInfo.operator.equals(CONSTANT.C_SHORT_ORPROP)) {
						int operandNum = operateInfo.operand.size();
						SimpleMatrix tmpSM = new SimpleMatrix(moduleStateLabelMatrix.getRows(), 1);
						tmpSM.setContentToValue(0);
						if (operandNum <= tmpProInfoStack.size()) {
							while (operandNum > 0) {
								operandNum--;
								OperateInfo tmpOI = tmpProInfoStack.pop();
								// is result with other operate,for example: negation operate
								if (tmpOI.operator.equals("colVector")) {
									tmpSM = tmpSM.calcOr((SimpleMatrix) tmpOI.operand.get(0).value);
								} else { // initial value ,and not use it
									int index = moduleStateLabelMatrix.getColumnNamesList().indexOf((String) tmpOI.operand.get(0).value);
									tmpSM = tmpSM.calcOr(moduleStateLabelMatrix.getSimpleMatrixByCol(index));
								}
							}
							OperateInfo reslutOperateInfo = getOperateInfoWithColVector(tmpSM, 0);
							tmpProInfoStack.push(reslutOperateInfo);
						} else {
							DebugOut.printErrln("Less operand in C_SHORT_ANDPROP", DebugOut.Degree_ERROR);
						}
						beforeOperate = CONSTANT.C_SHORT_ORPROP;
					} else if (operateInfo.operator.equals(CONSTANT.C_SHORT_NEGATION)) {
						int operandNum = operateInfo.operand.size();
						SimpleMatrix tmpSM = new SimpleMatrix(moduleStateLabelMatrix.getRows(), 1);
						if (operandNum <= tmpProInfoStack.size()) {
							while (operandNum > 0) {
								operandNum--;
								OperateInfo tmpOI = tmpProInfoStack.pop();
								// is result with other operate,for example: negation operate
								if (tmpOI.operator.equals("colVector")) {
									tmpSM = ((SimpleMatrix) tmpOI.operand.get(0).value).calcNegation();
								} else { // initial value ,and not use it
									int index = moduleStateLabelMatrix.getColumnNamesList().indexOf((String) tmpOI.operand.get(0).value);
									tmpSM = moduleStateLabelMatrix.getSimpleMatrixByCol(index).calcNegation();
								}
							}
							OperateInfo reslutOperateInfo = getOperateInfoWithColVector(tmpSM, 0);
							tmpProInfoStack.push(reslutOperateInfo);
						} else {
							DebugOut.printErrln("Less operand in C_SHORT_NEGATIONPROP", DebugOut.Degree_ERROR);
						}
						beforeOperate = CONSTANT.C_SHORT_NEGATION;
					} else if (operateInfo.operator.equals(CONSTANT.C_SHORT_NEXTPROP)) {
						// if operand equals one , need change "expr" to "OperateInfo"
						if (1 == operateInfo.operand.size()) {
							OperateInfo tmpOI = tmpProInfoStack.pop();
							SimpleMatrix tmpSM = new SimpleMatrix(moduleStateLabelMatrix.getRows(), 1);
							int index = moduleStateLabelMatrix.getColumnNamesList().indexOf((String) tmpOI.operand.get(0).value);
							tmpSM = moduleStateLabelMatrix.getSimpleMatrixByCol(index);
							OperateInfo reslutOperateInfo = getOperateInfoWithColVector(tmpSM, 0);
							tmpProInfoStack.push(reslutOperateInfo);
						}
						beforeOperate = CONSTANT.C_SHORT_NEXTPROP;
					} else if (operateInfo.operator.equals(CONSTANT.C_SHORT_POTRUE)) {

						beforeOperate = CONSTANT.C_SHORT_POTRUE;
					} else if (operateInfo.operator.equals(CONSTANT.C_SHORT_UNTIL)) {
						int operandNum = operateInfo.operand.size();
						SimpleMatrix tmpSM = new SimpleMatrix(moduleStateLabelMatrix.getRows(), 1);
						ArrayList<SimpleMatrix> DList = new ArrayList<SimpleMatrix>();
						if (operandNum <= tmpProInfoStack.size()) {
							while (operandNum > 0) {
								operandNum--;
								OperateInfo tmpOI = tmpProInfoStack.pop();
								// is result with other operate,for example: negation operate
								if (tmpOI.operator.equals("colVector")) {
									tmpSM = (SimpleMatrix) tmpOI.operand.get(0).value;
									DList.add(tmpSM);
								} else { // initial value ,and not use it
									int index = moduleStateLabelMatrix.getColumnNamesList().indexOf((String) tmpOI.operand.get(0).value);
									tmpSM = moduleStateLabelMatrix.getSimpleMatrixByCol(index);
									DList.add(tmpSM);
								}
							}
						} else {
							DebugOut.printErrln("Less operand in C_SHORT_UNTIL", DebugOut.Degree_ERROR);
						}
						if (CONSTANT.I_UNITLOPERATORS == DList.size()) {
							// change turn
							OperateInfo reslutOperateInfo = getOperateInfoWithColVector(DList.get(1), 0);
							tmpProInfoStack.push(reslutOperateInfo);
							reslutOperateInfo = getOperateInfoWithColVector(DList.get(0), 0);
							tmpProInfoStack.push(reslutOperateInfo);
						} else {
							DebugOut.printErrln("Error size of DList in C_SHORT_UNTIL", DebugOut.Degree_ERROR);
						}
						beforeOperate = CONSTANT.C_SHORT_UNTIL;
					} else if (operateInfo.operator.equals(CONSTANT.C_SHORT_ALWAYPROP)) {

						beforeOperate = CONSTANT.C_SHORT_ALWAYPROP;
					} else if (operateInfo.operator.equals(CONSTANT.C_SHORT_EVENTUALLYPROP)) {

						beforeOperate = CONSTANT.C_SHORT_EVENTUALLYPROP;
					} else if (operateInfo.operator.equals(CONSTANT.C_SHORT_POPROP)) {
						if (beforeOperate.equals(CONSTANT.C_SHORT_NEXTPROP)) {
							SimpleMatrix Rp = moduleTransferMatrix.calcRp();
							SimpleMatrix D = (SimpleMatrix) tmpProInfoStack.pop().operand.get(0).value;
							resultMatrix = moduleTransferMatrix.calcRecombine(SimpleMatrix.calcDiagByColVector(D)).calcRecombine(Rp);
							resultMatrix.setRowNamesList(moduleTransferMatrix.getRowNamesList());

							OperateInfo PoOperateInfo = getOperateInfo(resultMatrix);
							tmpProInfoStack.push(PoOperateInfo);
						} else if (beforeOperate.equals(CONSTANT.C_SHORT_UNTIL)) {
							SimpleMatrix Rp = moduleTransferMatrix.calcRp();
							SimpleMatrix D1 = (SimpleMatrix) tmpProInfoStack.pop().operand.get(0).value;
							SimpleMatrix D2 = (SimpleMatrix) tmpProInfoStack.pop().operand.get(0).value;
							resultMatrix = SimpleMatrix.calcDiagByColVector(D1).calcRecombine(moduleTransferMatrix).calcPstar().calcRecombine(SimpleMatrix.calcDiagByColVector(D2)).calcRecombine(Rp);
							resultMatrix.setRowNamesList(moduleTransferMatrix.getRowNamesList());

							OperateInfo PoOperateInfo = getOperateInfo(resultMatrix);
							tmpProInfoStack.push(PoOperateInfo);
						} else if (beforeOperate.equals(CONSTANT.C_SHORT_EVENTUALLYPROP)) {
							SimpleMatrix Rp = moduleTransferMatrix.calcRp();
							SimpleMatrix D = (SimpleMatrix) tmpProInfoStack.pop().operand.get(0).value;
							resultMatrix = moduleTransferMatrix.calcPstar().calcRecombine(SimpleMatrix.calcDiagByColVector(D)).calcRecombine(Rp);
							resultMatrix.setRowNamesList(moduleTransferMatrix.getRowNamesList());

							OperateInfo PoOperateInfo = getOperateInfo(resultMatrix);
							tmpProInfoStack.push(PoOperateInfo);
						} else if (beforeOperate.equals(CONSTANT.C_SHORT_ALWAYPROP)) {
							// fix point
							SimpleMatrix colVector = (SimpleMatrix) tmpProInfoStack.pop().operand.get(0).value;
							FixPoint fixPoint = new FixPoint(colVector, moduleTransferMatrix);
							resultMatrix = fixPoint.calcAlwayProp();
						}
						beforeOperate = CONSTANT.C_SHORT_POPROP;
					} else {
						DebugOut.printErrln("No this operate [" + operateInfo.operator + "]", DebugOut.Degree_ERROR);
						properties.get(i).setResult("Error");
						break;
					}
				}
			}

			// one property validate over
			if (proType == GPoPropertyType.Type.POCALCVALUE) {
				properties.get(i).setResult(resultMatrix.toString());
			} else if (proType == GPoPropertyType.Type.POCONDITION) {

			} else if (proType == GPoPropertyType.Type.INVALID) {

			} else {
				DebugOut.printErrln("Property [" + proType + "] Type Error", DebugOut.Degree_ERROR);
			}
		}

		modulesFile.setProperties(properties);
		return modulesFile;
	}

	public ModulesFile getModulesFile() {
		return modulesFile;
	}

	public void setModulesFile(ModulesFile modulesFile) {
		this.modulesFile = modulesFile;
	}

	public List<GPoProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<GPoProperty> properties) {
		this.properties = properties;
	}

}
