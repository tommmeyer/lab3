package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eSuit;
import pokerExceptions.OverDrawException;
import pokerEnums.eRank;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Deck_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void FiftyTwoCardDeck(){
		Deck deck = new Deck();
		assertEquals(deck.DeckSize(), 52);
		assertNotEquals(deck.DeckSize(),53);
	}
	
	@Test
	public void JokerCardDeck(){
		Deck deck = new Deck(2);
		assertEquals(deck.DeckSize(), 54);
		assertNotEquals(deck.DeckSize(),52);
	}
	@Test
	public void WildDeck() throws OverDrawException{
		ArrayList<Card> wilds = new ArrayList<Card>();
		Card wildOne = new Card(eSuit.HEARTS,eRank.TWO,1);
		Card wildTwo = new Card(eSuit.DIAMONDS,eRank.TWO,2);
		Card wildThree = new Card(eSuit.CLUBS,eRank.TWO,12);
		Card wildFour = new Card(eSuit.SPADES,eRank.TWO,43);
		wilds.add(wildOne);
		wilds.add(wildTwo);
		wilds.add(wildThree);
		wilds.add(wildFour);
		Deck deck = new Deck(2,wilds);
		assertEquals(deck.DeckSize(), 54);
		assertNotEquals(deck.DeckSize(),52);
		for(int i=0; i <54; i++){
			Card card = deck.Draw();
			if (card.geteRank().equals(eRank.TWO)){
				assertTrue(card.isbWild());
			}
			else if (card.geteRank().equals(eRank.EIGHT)){
				assertFalse(card.isbWild());
			}
		}
	}
	@Test(expected = OverDrawException.class)
	public void OverDrawTest() throws OverDrawException{
		Deck deck = new Deck();
		for(int i =0; i<53 ; i++){
			deck.Draw();
		}
	}
}
