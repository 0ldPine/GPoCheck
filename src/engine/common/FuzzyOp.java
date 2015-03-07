package engine.common;

public class FuzzyOp {

	public static double or(double... args) {
		double tmp = -Double.MAX_VALUE;
		for (double d : args) {
			if (d > tmp) {
				tmp = d;
			}
		}
		return tmp;
	}

	public static double and(double... args) {
		double tmp = Double.MAX_VALUE;
		for (double d : args) {
			if (d < tmp) {
				tmp = d;
			}
		}
		return tmp;
	}
	
	public static void main(String[] args) {
		System.out.println(FuzzyOp.or(FuzzyOp.and(0),11));
	}
}
