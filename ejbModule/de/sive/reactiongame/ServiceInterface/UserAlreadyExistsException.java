/**
 * 
 */
package de.sive.reactiongame.ServiceInterface;

/**
 * @author Michael
 *
 */
public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = -2976775891667358463L;

	/**
	 * 
	 */
	public UserAlreadyExistsException() {
	}

	/**
	 * @param message
	 */
	public UserAlreadyExistsException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UserAlreadyExistsException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UserAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UserAlreadyExistsException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
