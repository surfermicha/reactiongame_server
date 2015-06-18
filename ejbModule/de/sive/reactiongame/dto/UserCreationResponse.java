/**
 * 
 */
package de.sive.reactiongame.dto;

/**
 * 
 * This DTO acknowledges the user creation process 
 * @author Michael Landreh
 *
 */
public class UserCreationResponse extends ReturnCodeResponse {

	
	private static final long serialVersionUID = 6029158320304625401L;
	
	//Variables
	private int sessionId;
	private String email;
	private String firstname;
	private String lastname;
	
	//Constructors
	/**
	 * 
	 */
	public UserCreationResponse() {
		super();
	}

	/**
	 * @param sessionId
	 * @param email
	 * @param firstname
	 * @param lastname
	 */
	public UserCreationResponse(int sessionId, String email, String firstname, String lastname) {
		super();
		this.sessionId = sessionId;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/**
	 * @return the sessionId
	 */
	public int getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
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

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	//Getters and Setters
	

	
}
