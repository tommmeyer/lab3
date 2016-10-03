package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Deck {

	private ArrayList<Card> deckCards = new ArrayList<Card>();

	public Deck() {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				if (eSuit == eSuit.Joker || eRank== eRank.Joker){
					continue;
				}
				else{
					deckCards.add(new Card(eSuit, eRank, iCardNbr++));
				
			}
			 
		}
		}
		Collections.shuffle(deckCards);
	}
	
	public Deck(int NbrOfJokers) {

		this();
		int iCardNbr = 53;
		for (int i=0; i<NbrOfJokers; i++){
			deckCards.add(new Card(eSuit.Joker, eRank.Joker, iCardNbr++));
		}
		Collections.shuffle(deckCards);
	}
	
	
	public Deck(int NbrOfJokers, ArrayList<Card> Wilds) {
		this(NbrOfJokers);
		for (Card wild: Wilds){
			wild.setbWild(true);
		}
	
	}
	public int DeckSize(){
		return deckCards.size();
	}
	public ArrayList<Card> getDeck(){
		return deckCards;
	}
	public Card Draw(){
		//TODO Lab 3 - Implement exception handling for overdraw
		return deckCards.remove(0);
	}
}
