package de.sive.reactiongame.session;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import de.sive.reactiongame.user.User;

/**
 * Session Bean implementation class SessionManager
 * @author Michael Landreh
 */
@Singleton
@LocalBean
public class SessionManager {

private HashMap<Integer, UserSession> sessions;
	
	@PostConstruct
	private void init() {
		sessions = new HashMap<>();
	}
	
	@Lock(LockType.READ)
	public UserSession findSessionById(int id) {
		return this.sessions.get(id);
	}
	
	@Lock(LockType.WRITE)	
	public int createSession(User user) {
		UserSession newSession = new UserSession(user);
		this.sessions.put(newSession.getId(), newSession);
		return newSession.getId();
	}

	@Lock(LockType.WRITE)	
	public void closeSession(int id) {
		this.sessions.remove(id);
	}
}
