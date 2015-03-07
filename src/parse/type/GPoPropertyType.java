package parse.type;

public class GPoPropertyType {
	public static enum Type {
		POCONDITION,POCALCVALUE,INVALID
	}

	String name; // All symbols at least have a name
	Type type;

	public GPoPropertyType(String name) {
		this.name = name;
	}

	public GPoPropertyType(String name, Type type) {
		this(name);
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "<" + getName() + ">";
	}
}
