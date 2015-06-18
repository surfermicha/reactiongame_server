package de.sive.reactiongame.user;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.NamingException;

/**
 * Session Bean implementation class UserRegistry
 */
@Singleton
@Startup
@LocalBean
public class UserRegistry {

	private HashMap<String, User> users;

	@PostConstruct
	private void init() throws NamingException {
		users = new HashMap<>();

		// DUmmy User. Delete at release time
		User dummy1 = new User("abc@example.de", "123456", "Albert", "Klöschen");
		User dummy2 = new User("xyz@example.de", "654321", "Ella", "Hindersmann");
		addUser(dummy1);
		addUser(dummy2);
	}

	@Lock(LockType.READ)
	public User findUserByEmail(String email) {
		return this.users.get(email);
	}

	@Lock(LockType.WRITE)
	public void addUser(User newUser) {
		this.users.put(newUser.getEmail(), newUser);
	}

}
