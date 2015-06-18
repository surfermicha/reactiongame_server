/**
 * 
 */
package de.sive.reactiongame.session;

import java.util.Date;

import de.sive.reactiongame.user.User;


/**
 * This class represents a single user session 
 * @author Michael Landreh
 *
 */
public class UserSession {
	
private static int lastID = 0;
	
	private int id;
	private User user;
	private Date creationTime;
	
	public UserSession(User user) {
		this.id = ++lastID;
		this.user = user;
		this.creationTime = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreationTime() {
		return creationTime;
	}

}
