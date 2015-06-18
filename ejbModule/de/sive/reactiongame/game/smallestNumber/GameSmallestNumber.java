/**
 * 
 */
package de.sive.reactiongame.game.smallestNumber;

import java.util.Random;

/**
 * This class represents a smallest number game.
 * @author Michael Landreh
 *
 */
public class GameSmallestNumber {
	//Constants
    private static final int DEFAULT_GAME_DURATION = 10000;


    //Global variables
    private int gameDuration;
    private String[] answers = new String[4];
    private int correctAnswerIndex;
    private boolean isPlayer1Winner;
    private boolean isPlayer2Winner;
    


	//Constructors
    //Empty constructor generates a random game
    public GameSmallestNumber() {
        int min = 100;
        Random randomGenerator = new Random();
        for(int i = 0 ; i <= 3; i++)
        {
            boolean numberIsNotUnique = true;
            int number = 0;
            //Generate unique random number
            while (numberIsNotUnique) {
                number = randomGenerator.nextInt(100);

                checkAnswer : for(int j = 0; j <= i; j++) {
                    if (answers[j] != null) {
                        if (answers[j].equals(Integer.toString(number)) == false)
                        {
                            numberIsNotUnique = false;

                        }
                        else {
                            //The random number is not unique.
                            numberIsNotUnique = true;
                            break checkAnswer;
                        }
                    }
                    else {
                        numberIsNotUnique = false;
                    }
                }
            }

            //Set correct answer index
            if(number < min) {
                min = number;
                correctAnswerIndex = i;
                
            }
            answers[i] = Integer.toString(number);
        }
        gameDuration = DEFAULT_GAME_DURATION;

    }

    public GameSmallestNumber(String[] answers, int correctAnswerIndex) {
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
        this.gameDuration = DEFAULT_GAME_DURATION;
    }

    public GameSmallestNumber(String[] answers, int correctAnswerIndex, int gameDuration) {
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
        this.gameDuration = gameDuration;
    }
    
  //Public methods
    public int getGameDurationInMilliseconds() {
        return gameDuration;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public boolean isPlayer1Winner() {
		return isPlayer1Winner;
	}

	public void setPlayer1Winner(boolean isPlayer1Winner) {
		this.isPlayer1Winner = isPlayer1Winner;
	}

	public boolean isPlayer2Winner() {
		return isPlayer2Winner;
	}

	public void setPlayer2Winner(boolean isPlayer2Winner) {
		this.isPlayer2Winner = isPlayer2Winner;
	}

	public String getCorrectAnswer() {
        return answers[correctAnswerIndex];
    }
    
    
    
}
