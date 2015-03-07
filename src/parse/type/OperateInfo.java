package parse.type;

import java.util.ArrayList;

/**
 * order to record property AST
 * 
 * @author Administrator
 *
 */
public class OperateInfo {
	public String operator;
	public ArrayList<Value> operand;

	public OperateInfo(){
		this.operator = "";
		this.operand = new ArrayList<Value>();
	}
	
	public OperateInfo(String operator, ArrayList<Value> operand) {
		super();
		this.operator = operator;
		this.operand = operand;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(" + operator + ")");
		for (int i = 0; i < operand.size(); i++)
			sb.append(" " + operand.get(i).toString());
		return sb.toString();
	}
}
