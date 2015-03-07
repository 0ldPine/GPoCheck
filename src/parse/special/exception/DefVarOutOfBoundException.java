package parse.special.exception;

public class DefVarOutOfBoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String detail;

	public DefVarOutOfBoundException() {
		super();
	}
	
	public DefVarOutOfBoundException(String message) {
		super(message);
		detail = message;
	}

	public String toString() {
		return "DefVarOutOfBoundException[" + detail + "]";
	}
	
	public DefVarOutOfBoundException(Throwable cause) {
        super(cause);
    }
}
