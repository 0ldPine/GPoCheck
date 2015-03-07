package parse.common;

import java.util.Stack;

import parse.type.GPoPropertyType;
import parse.type.OperateInfo;
import parse.type.GPoPropertyType.Type;

public class GPoProperty {

	private Type type = GPoPropertyType.Type.INVALID;
	private String context = "";
	private int nest = 0;
	private String conditionOperate = "";
	private double conditionValue = 0;
	private Stack<OperateInfo> proInfoStack = new Stack<OperateInfo>();
	private String result = "";

	public GPoProperty() {
		super();
	}

	public GPoProperty(Type condition, String context) {
		super();
		this.type = condition;
		this.context = context;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type condition) {
		this.type = condition;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getNest() {
		return nest;
	}

	public void setNest(int nest) {
		this.nest = nest;
	}

	public Stack<OperateInfo> getProInfoStack() {
		return proInfoStack;
	}

	public void setProInfoStack(Stack<OperateInfo> proInfo) {
		this.proInfoStack = proInfo;
	}

	public String getConditionOperate() {
		return conditionOperate;
	}

	public void setConditionOperate(String conditionOperate) {
		this.conditionOperate = conditionOperate;
	}

	public double getConditionValue() {
		return conditionValue;
	}

	public void setConditionValue(double conditionValue) {
		this.conditionValue = conditionValue;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<" + type.toString() + "> " + context + "\n");
		for (int i = 0; i < proInfoStack.size(); i++) {
			sb.append("\t" + proInfoStack.get(i).toString() + "\n");
		}
		return sb.toString();
	}

}
