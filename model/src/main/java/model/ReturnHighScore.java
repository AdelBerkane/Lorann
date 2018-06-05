package model;

public class ReturnHighScore {
	private int scoregame;
	
	/**
	 * Sets the score to the value of scoregame
	 * @param scoregame		Stores the score
	 */
	
	public ReturnHighScore(final int scoregame)
	{
		this.setScore(scoregame);
	}
	
	/**
	 * Sets score to 0
	 */
	
	public ReturnHighScore() {
		this.setScore(0);
	}
	
	
	public int getScore() {
		return this.scoregame;
	}
	public void setScore(final int scoregame) {
		this.scoregame = scoregame;
	}

}
