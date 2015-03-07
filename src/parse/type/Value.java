package parse.type;

public class Value {
	public String type;
	public Object value;

	public Value(String type, Object value) {
		super();
		this.type = type;
		this.value = value;
	}

	public Value() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return type + "@" + value.toString();
	}

}
