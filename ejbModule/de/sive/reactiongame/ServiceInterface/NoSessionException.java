/**
 * 
 */
package de.sive.reactiongame.ServiceInterface;

/**
 * This Exception is thrown if no current session is available.
 * @author Michael Landreh
 *
 */
public class NoSessionException extends Exception {
	private static final long serialVersionUID = -5947824855754455818L;

	/**
	 * Empty constructor
	 */
	public NoSessionException() {}

	/**
	 * @param message
	 */
	public NoSessionException(String message) {
		super(message);
		
	}

	/**
	 * @param throwable
	 */
	public NoSessionException(Throwable throwable) {
		super(throwable);

	}

	/**
	 * @param message
	 * @param throwable
	 */
	public NoSessionException(String message, Throwable throwable) {
		super(message, throwable);
	}


}
