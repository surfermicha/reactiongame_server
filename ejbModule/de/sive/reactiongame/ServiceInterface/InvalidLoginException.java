/**
 * 
 */
package de.sive.reactiongame.ServiceInterface;

/**
 * 
 * This exception is thrown if the login fails.
 * 
 * @author Michael Landreh
 *
 */
public class InvalidLoginException extends Exception {

	private static final long serialVersionUID = -3124311218420820790L;

	public InvalidLoginException(String message) {
		super(message);
	}

	
	public InvalidLoginException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
