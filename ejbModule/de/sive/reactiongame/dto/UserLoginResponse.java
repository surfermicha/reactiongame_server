/**
 * 
 */
package de.sive.reactiongame.dto;

/**
 * This DTO returns the user data to the client after the user is logged in.
 * @author Michael Landreh
 *
 */
public class UserLoginResponse extends ReturnCodeResponse {


	private static final long serialVersionUID = -3397668228575761884L;
	private String firstname;
	private String lastname;
	private int sessionId;
	private String email;
	
	
	
	/**
	 * Empty constructor
	 */
	public UserLoginResponse() {
	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param sessionId
	 */
	public UserLoginResponse(String firstname, String lastname, int sessionId, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.sessionId = sessionId;
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
