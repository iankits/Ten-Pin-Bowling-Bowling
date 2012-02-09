package com.game.bowling;

/**
 * Calculation of Bowling scores.
 * @author Ankit Singh 
 */
public class BowlingGame {
	private int sizeRoll = 22;
	private int scores = 0;
	private int rolls[] = new int[sizeRoll];
	private int rCount = 1;
	private int virtualShotCount = 0;
	private int strike = 100, spare = 50;
	private double currFrameNumber;

	/**
	 * Rolling the bowls and calculating the scores
	 * @param pins
	 */
	public void roll(int pins) {
		if(rCount < sizeRoll){
			Boolean retSpare;	
			// if Strike
			if(pins == 10){
				virtualShotCount = virtualShotCount + 2; // as frame completed in one shot only
				rolls[rCount++] = strike; // Strike code = 100	
			} else {
				// if its first roll and not strike then save directly
				if(rCount == 1){
					rolls[rCount++] = pins;
					virtualShotCount = virtualShotCount + 1;	
				} else {
					// check for spare or not
					retSpare = checkForSpare(pins);
					if(retSpare == true){
						rolls[rCount++] = spare; // Spare code = 50
						virtualShotCount = virtualShotCount + 1;
					} else{
						rolls[rCount++] = pins;
						virtualShotCount = virtualShotCount + 1;
					}
				}
			}
		} else
			System.out.println("[SEVERE] Input Error!!!");
	}

	/**
	 * Check for the spares and return true if its
	 * @param currPins 
	 * @return
	 */
	private Boolean checkForSpare(int currPins) {
		int tempPrev = 0, tempTotal = 0;
		Boolean retStatus = false;
		currFrameNumber = Math.ceil((double)(virtualShotCount)/2);

		// to exclude frame from the calculation rule for spare
		if(currFrameNumber == 10)
			return retStatus;

		tempPrev = rolls[rCount-1];
		tempTotal = tempPrev + currPins;
		if(tempTotal == 10) 
			retStatus = true; // if spare then true 

		return retStatus;
	}

	/**
	 * Get total scores 
	 * @return
	 */
	public int getScore() {	
		for(int i = 1; i < rCount; i++){	
			if(rolls[i] == strike){			
				scores = scores + checkGetStrikeSpare(rolls,i) + checkGetStrikeSpare(rolls, i+1) + checkGetStrikeSpare(rolls, i+2);;			
			} else if(rolls[i] == spare){
				scores = scores + checkGetStrikeSpare(rolls, i)  + checkGetStrikeSpare(rolls, i+1);
			} else
				scores = scores + rolls[i];
		}
		return scores;
	}

	/**
	 * Print out all roll number and pins hit
	 */
	public void printScoreArray(){
		for(int i = 1; i < rCount; i++){
			System.out.println("Roll :"+i+" Pins Hit: "+rolls[i]);
		}
	}

	/**
	 * Check for the spare and return the rest pins hit for making it fullHit
	 * @param rolls
	 * @param i
	 * @return restPinsCounts
	 */
	private int retSpare(int rolls[], int i){	
		int restPinsCounts = 0, strikePoint = 10;
		if (rolls[i] == spare)
			restPinsCounts = strikePoint - rolls[i-1];
		return restPinsCounts;
	}

	/**
	 * This function checks for Strikes, Spares and returns scores according to the selections
	 * @param rolls
	 * @param i
	 * @return the value of particular event
	 */
	private int checkGetStrikeSpare(int rolls[], int i){
		int strikePoint = 10;
		if (rolls[i] == strike)
			return strikePoint;
		else if(rolls[i] == spare)
			return retSpare(rolls,i);
		return rolls[i];
	}
}
