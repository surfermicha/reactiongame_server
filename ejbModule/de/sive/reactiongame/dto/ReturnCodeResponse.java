/**
 * 
 */
package de.sive.reactiongame.dto;

/**
 * This class contains an error code and an error message to respond to the client the status of the query
 * @author Michael Landreh
 *
 */
public class ReturnCodeResponse extends Response {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8751802608512087820L;

	//The status code which is responded in case of no errors
	public static final int OK_CODE = 0;

	//Returns a code that identifies errors. If no error occurs returnCode == OK_CODE
	private int returnCode;
	
	//A human readable error message
	private String message;

	//Getter and Setter
	public ReturnCodeResponse() {
		setReturnCode(OK_CODE);
	}

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
