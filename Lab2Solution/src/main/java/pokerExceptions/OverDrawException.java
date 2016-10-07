package pokerExceptions;
import pokerBase.Deck;

public class OverDrawException extends Exception {
	private Deck deck = new Deck();
	public OverDrawException(Deck deck){
		this.deck = deck;
		System.out.println("this deck is out of cards");
	}
}
