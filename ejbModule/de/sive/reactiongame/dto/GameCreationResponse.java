/**
 * 
 */
package de.sive.reactiongame.dto;

/**
 * This class contains the game data for a smallest number game and is responded to the client
 * @author Michael Landreh
 *
 */
public class GameCreationResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = 6838585854523188315L;
	
	private String[] answers;
	private int correctAnswerIndex;
	private int gameDurationInMilliseconds;
	/**
	 * @return the answers
	 */
	public String[] getAnswers() {
		return answers;
	}
	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
	/**
	 * @return the correctAnswerIndex
	 */
	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}
	/**
	 * @param correctAnswerIndex the correctAnswerIndex to set
	 */
	public void setCorrectAnswerIndex(int correctAnswerIndex) {
		this.correctAnswerIndex = correctAnswerIndex;
	}
	/**
	 * @return the gameDurationInMilliseconds
	 */
	public int getGameDurationInMilliseconds() {
		return gameDurationInMilliseconds;
	}
	/**
	 * @param gameDurationInMilliseconds the gameDurationInMilliseconds to set
	 */
	public void setGameDurationInMilliseconds(int gameDurationInMilliseconds) {
		this.gameDurationInMilliseconds = gameDurationInMilliseconds;
	}
	
	

}
