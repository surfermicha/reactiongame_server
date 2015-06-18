package de.sive.reactiongame.ServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import org.jboss.ws.api.annotation.WebContext;

import de.sive.reactiongame.dto.GameCreationResponse;
import de.sive.reactiongame.dto.GameFinishedResponse;
import de.sive.reactiongame.dto.ReturnCodeResponse;
import de.sive.reactiongame.dto.UserCreationResponse;
import de.sive.reactiongame.dto.UserLoginResponse;
import de.sive.reactiongame.game.smallestNumber.GameSmallestNumber;
import de.sive.reactiongame.session.SessionManager;
import de.sive.reactiongame.session.UserSession;
import de.sive.reactiongame.user.User;
import de.sive.reactiongame.user.UserRegistry;

/**
 * Session Bean implementation class ReactiongameServiceBean
 */

@WebService
@WebContext(contextRoot = "/reactiongame")
@Stateless
public class ReactiongameServiceBean implements IReactionGameService {

	private static GameSmallestNumber game;
	private static final int OK_CODE = 0;
	private static final int NO_GAME_CODE = 20;
	private static final int INVALID_ANSWER_CODE = 30;
	private static final int INVALID_PLAYER_NUMBER_CODE = 10;
	private static final int USER_CREATION_FAILED_CODE = 50;
	private static final int LOGIN_FAILED_EMAIL_CODE = 41;
	private static final int LOGIN_FAILED_PASSWORD_CODE = 40;

	/*
	 * This EJB stores the all existing users
	 */
	@EJB
	private UserRegistry userRegistry;

	/*
	 * This EJB organizes and provides the user sessions
	 */
	@EJB
	private SessionManager sessionManager;

	/*
	 * This method creates a new game. (At this time it's just a smallest number
	 * game)
	 * 
	 * @return GameCreationResponse The DTO contains the the needed information
	 * for a smallest number game
	 */
	public GameCreationResponse createGame() {
		GameCreationResponse response = new GameCreationResponse();
		game = new GameSmallestNumber();
		response.setAnswers(game.getAnswers());
		response.setCorrectAnswerIndex(game.getCorrectAnswerIndex());
		response.setGameDurationInMilliseconds(game
				.getGameDurationInMilliseconds());
		response.setMessage("Game was successfully created.");
		response.setReturnCode(OK_CODE);
		return response;
	}

	/*
	 * This method recieves the game result from the client. The player number
	 * has to be either 1 or 2.
	 * 
	 * @param playerNumber Set 0 or 1 depended on your player number
	 * 
	 * @return GameFinishedResponse This DTO only acts as an ReturnCodeResponse
	 */
	public GameFinishedResponse setGameResult(int playerNumber,
			int selectedAnswerIndex, boolean isWinner) {
		GameFinishedResponse response = new GameFinishedResponse();

		// Check whether game is available
		if (game == null) {
			response.setReturnCode(NO_GAME_CODE);
			response.setMessage("You haven't started a game");
		}

		// Check whether the selected answer is correct
		if (game.getCorrectAnswerIndex() == selectedAnswerIndex
				&& isWinner == true) {
			// Answer correct
			response.setReturnCode(OK_CODE);
		} else if (game.getCorrectAnswerIndex() != selectedAnswerIndex
				&& isWinner == false) {
			// answer wrong
			response.setReturnCode(OK_CODE);
		} else {
			response.setReturnCode(INVALID_ANSWER_CODE);
			response.setMessage("The server validation of the answer failed.");
			return response;
		}

		// Set winner status depended on player number
		if (playerNumber == 1) {
			game.setPlayer1Winner(isWinner);
		} else if (playerNumber == 2) {
			game.setPlayer2Winner(isWinner);
		} else {
			response.setReturnCode(INVALID_PLAYER_NUMBER_CODE);
			response.setMessage("Your player number is not valid. It has to be either 1 or 2");
		}
		return response;
	}
	
	/*
	 * This method creates a new user. Users have to send their e-mail-address, first name, 
	 * last name and have to set their password.
	 * @param	
	 */
	@Override
	public UserCreationResponse createUser(String email, String password, String firstname, String lastname) {
		UserCreationResponse response = new UserCreationResponse();
		
		try {
			//Check whether the user already exists
			User user = this.userRegistry.findUserByEmail(email);
			if (user == null) {
				//Create a new User and attach him to the user registry
				user = new User(email, password, firstname, lastname);
				System.out.println(user.getEmail() + user.getFirstname() + user.getLastname() + user.getPassword() + user.getId());
				this.userRegistry.addUser(user);
				int sessionId = sessionManager.createSession(user);
				//Prepare response
				response.setEmail(email);
				response.setFirstname(firstname);
				response.setLastname(lastname);
				response.setSessionId(sessionId);
				response.setReturnCode(OK_CODE);
				System.out.println("Created response with the following content: " + response.getEmail() + " | " + response.getFirstname() + " | " + response.getLastname() + " | " + response.getSessionId());
			} else {
				throw new UserAlreadyExistsException("A user with this e-mail-address already exists. Please sign up with another e-mail-address.");
			}
		} catch (UserAlreadyExistsException e) {
			response.setMessage(e.getMessage());
			response.setReturnCode(USER_CREATION_FAILED_CODE);
		}
		return response;
	}

	/*
	 * This method starts a session with a user. Users have to send their
	 * credentials to login. They receive the user data and a session key in
	 * response.
	 * 
	 * @param email The e-mail-address of the user
	 * 
	 * @param password The password of the user
	 * 
	 * @return UserLoginResponse The DTO contains the users firstname, lastname
	 * and session ID
	 */
	@Override
	public UserLoginResponse loginUser(String email, String password) {
		UserLoginResponse response = new UserLoginResponse();

		try {
			// Find user in registry
			User user = this.userRegistry.findUserByEmail(email);
			
			//Proof is user exists
			if(user!= null) {
				
				// Proof if email and password are matching
				if (user.getPassword().equals(password)) {
					int sessionId = sessionManager.createSession(user);
					response.setReturnCode(OK_CODE);
					response.setSessionId(sessionId);
					response.setEmail(email);
					response.setFirstname(user.getFirstname());
					response.setLastname(user.getLastname()); 
				} else {
					response.setReturnCode(LOGIN_FAILED_PASSWORD_CODE);
					throw new InvalidLoginException(
							"Login failed caused by wrong password. Entered e-mail:" + email);
				}
			} else {
				response.setReturnCode(LOGIN_FAILED_EMAIL_CODE);
				throw new InvalidLoginException("Login failed because a user with this e-mail-address doesn't exists.");
			}
			
		} catch (InvalidLoginException e) {
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	/*
	 * This method closes the user session
	 * @param int	sessionId	The session ID to close
	 * @return	ReturnCodeResponse	The DTO to acknowledge  the log out process
	 */
	public ReturnCodeResponse logout(int sessionId) {
		sessionManager.closeSession(sessionId);
		ReturnCodeResponse response = new ReturnCodeResponse();
		response.setReturnCode(OK_CODE);
		return response;
	}
	
	/*
	 * This method returns a user session. 
	 * @param	int	Session ID of the user session to find
	 * @return	UserSession	The user session object
	 */
	private UserSession findSessionById(int sessionId) throws NoSessionException {
		UserSession session = sessionManager.findSessionById(sessionId);
		if (session==null)
			throw new NoSessionException("No session available. Please login first.");
		else
			return session;
	}
}
