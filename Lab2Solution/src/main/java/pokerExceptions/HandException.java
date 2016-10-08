package pokerExceptions;
import pokerBase.Hand;

public class HandException extends Exception{
	private Hand hand;
	public HandException(Hand hand){
		this.hand = hand;
		System.out.println("Your hand has the incorrect number of cards");
	}
}
