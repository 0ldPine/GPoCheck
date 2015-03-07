package util;

import java.util.Date;

public class DebugOut {

	// Now debug degree has six layer
	// All:show all message
	// Debug:show debug info
	// Info:display run info
	// Warn:only show warning and higher
	// Error:only show errors
	// Assert:only assert should be showed

	 public static final int Degree_ALL = 0;
	 public static final int Degree_DEBUG = 1;
	 public static final int Degree_INFO = 2;
	 public static final int Degree_WARN = 3;
	 public static final int Degree_ERROR = 4;
	 public static final int Degree_ASSERT = 5;

	private static int DEGREE = 0;
	private static int SHOWPRINTINFO = 0;

	static {
		String degreeString = Config.readValue(null, "INFO_OUTPUT_DEGREE");
		DEGREE = getDegreeNum(degreeString);
		SHOWPRINTINFO = Integer.parseInt(Config.readValue(null, "SHOW_INFO_FLAG"));
	}

	private static int getDegreeNum(String degreeString) {
		if (degreeString.toLowerCase().equals("all")) {
			return 0;
		} else if (degreeString.toLowerCase().equals("debug")) {
			return 1;
		} else if (degreeString.toLowerCase().equals("info")) {
			return 2;
		} else if (degreeString.toLowerCase().equals("warn")) {
			return 3;
		} else if (degreeString.toLowerCase().equals("error")) {
			return 4;
		} else if (degreeString.toLowerCase().equals("assert")) {
			return 5;
		} else {
			return 0;
		}
	}

	private static void headinfo(String arg0, int degree) {
		if (SHOWPRINTINFO == 1) {
			StringBuilder printInfo = new StringBuilder();
			printInfo.append("[" + degree + "]");
			printInfo.append("[" + (new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS")).format(new Date()) + "]");
			printInfo.append("[" + Thread.currentThread().getStackTrace()[3].getClassName() + " - ");
			printInfo.append(Thread.currentThread().getStackTrace()[3].getMethodName() + "]");
			System.out.println(printInfo);
		}
	}

	public static void print(String arg0) {
		headinfo(arg0, 0);
		System.out.print(arg0);
	}

	public static void println(String arg0) {
		headinfo(arg0, 0);
		System.out.println(arg0);
	}

	public static void print(String arg0, int degree) {
		if (degree >= DEGREE) {
			headinfo(arg0, degree);
			System.out.print(arg0);
		}
	}

	public static void println(String arg0, int degree) {
		if (degree >= DEGREE) {
			headinfo(arg0, degree);
			System.out.println(arg0);
		}
	}

	public static void printErr(String arg0) {
		headinfo(arg0, 0);
		System.err.print(arg0);
	}

	public static void printErrln(String arg0) {
		headinfo(arg0, 0);
		System.err.println(arg0);
	}

	public static void printErr(String arg0, int degree) {
		if (degree >= DEGREE) {
			headinfo(arg0, degree);
			System.err.print(arg0);
		}
	}

	public static void printErrln(String arg0, int degree) {
		if (degree >= DEGREE) {
			headinfo(arg0, degree);
			System.err.println(arg0);
		}
	}
}