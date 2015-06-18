/**
 * 
 */
package de.sive.reactiongame.user;

import java.io.Serializable;

/**
 * @author Michael
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 7340452529657450072L;
	
	private int id;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private static int lastID = 0;
	
	/**
	 * @param email
	 * @param password
	 * @param firstname
	 * @param lastname
	 */
	public User(String email, String password, String firstname, String lastname) {
		super();
		this.id = ++lastID;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	

}
