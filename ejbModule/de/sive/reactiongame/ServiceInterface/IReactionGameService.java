/**
 * 
 */
package de.sive.reactiongame.ServiceInterface;

import de.sive.reactiongame.dto.GameCreationResponse;
import de.sive.reactiongame.dto.GameFinishedResponse;
import de.sive.reactiongame.dto.UserCreationResponse;
import de.sive.reactiongame.dto.UserLoginResponse;

/**
 * @author Michael
 * This is the webservice interface where the client connects to.
 */
public interface IReactionGameService {
	
	public GameCreationResponse createGame();
	
	public GameFinishedResponse setGameResult(int playerNumber, int selectedAnswerIndex, boolean isWinner);
	
	public UserLoginResponse loginUser(String email, String password);
	
	public UserCreationResponse createUser(String email, String password, String firstname, String lastname);
}
