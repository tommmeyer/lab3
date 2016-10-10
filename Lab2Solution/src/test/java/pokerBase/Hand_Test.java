package pokerBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Hand_Test {

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
	public void TestRoyalFlush() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.ACE.getiRankNbr());
		
		Hand hh = new Hand();
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		hh.AddToCardsInHand(new Card(eSuit.Joker, eRank.Joker,1));
		
		try {
			hh = Hand.EvaluateHand(hh);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(hh.getHs().getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertFalse(hh.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		
	}
	@Test
	public void TestStraightFlush() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		assertTrue(h.getHs().getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.KING.getiRankNbr());
		try {
			h.EvaulateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Hand hh = new Hand();
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		hh.AddToCardsInHand(new Card(eSuit.Joker, eRank.Joker,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		try {
			hh.EvaulateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(h.getHs().getHandStrength());
		assertTrue(hh.getHs().getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(hh.getHs().getHiHand() == eRank.KING.getiRankNbr());
	}
	@Test
	public void TestFiveOfAKind(){
			Hand h = new Hand();
			h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
			h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
			h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
			h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
			h.AddToCardsInHand(new Card(eSuit.Joker, eRank.Joker,1));
			
			try {
				h = Hand.EvaluateHand(h);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			assertTrue(h.getHs().getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
			assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
			
		}
		


	
	@Test
	public void TestFourOfAKind() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		
		Hand hh = new Hand();
		hh.AddToCardsInHand(new Card(eSuit.Joker, eRank.Joker,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		hh.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		hh.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		
		try {
			hh = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(hh.getHs().getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(hh.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		
	}
	
	@Test
	public void TestFullHouse() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == eRank.ACE.getiRankNbr());
		Hand hh = new Hand();
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		hh.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		hh.AddToCardsInHand(new Card(eSuit.Joker, eRank.Joker,1));
		hh.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.NINE,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		
		try {
			hh = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(hh.getHs().getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(hh.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(hh.getHs().getLoHand() == eRank.NINE.getiRankNbr());
	}
	public void TestFlush() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		assertTrue(h.getHs().getHandStrength() == eHandStrength.Flush.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.KING.getiRankNbr());
		try {
			h.EvaulateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Hand hh = new Hand();
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		hh.AddToCardsInHand(new Card(eSuit.Joker, eRank.Joker,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		try {
			hh.EvaulateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(h.getHs().getHandStrength());
		assertTrue(hh.getHs().getHandStrength() == eHandStrength.Flush.getHandStrength());
		assertTrue(hh.getHs().getHiHand() == eRank.ACE.getiRankNbr());
	}
	
	public void TestStraight() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		assertTrue(h.getHs().getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.KING.getiRankNbr());
		try {
			h.EvaulateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Hand hh = new Hand();
		hh.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		hh.AddToCardsInHand(new Card(eSuit.Joker, eRank.Joker,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		try {
			hh.EvaulateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(h.getHs().getHandStrength());
		assertTrue(hh.getHs().getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(hh.getHs().getHiHand() == eRank.KING.getiRankNbr());
	}
	@Test
	public void TestThreeOfAKind() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());

		Hand hh = new Hand();
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		hh.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		hh.AddToCardsInHand(new Card(eSuit.Joker, eRank.Joker,1));
		hh.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		
		try {
			hh = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(hh.getHs().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(hh.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		
		Hand hhh = new Hand();
		hhh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		hhh.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		hhh.AddToCardsInHand(new Card(eSuit.Joker, eRank.Joker,1));
		hhh.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.JACK,1));
		hhh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		
		try {
			hhh = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(hhh.getHs().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(hhh.getHs().getHiHand() == eRank.TEN.getiRankNbr());
	
	}
	@Test
	public void TestTwoPair() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == eRank.TWO.getiRankNbr());

		Hand hh = new Hand();
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		hh.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		hh.AddToCardsInHand(new Card(eSuit.SPADES, eRank.ACE,1));
		hh.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.ACE,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		
		try {
			hh = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(hh.getHs().getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(hh.getHs().getHiHand() == eRank.ACE.getiRankNbr());
		
		Hand hhh = new Hand();
		hhh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		hhh.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		hhh.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		hhh.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.JACK,1));
		hhh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		
		try {
			hhh = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(hhh.getHs().getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(hhh.getHs().getLoHand() == eRank.TEN.getiRankNbr());
		assertTrue(hhh.getHs().getHiHand() == eRank.KING.getiRankNbr());
	
	}
	@Test
	public void TestPair() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FOUR,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());

		Hand hh = new Hand();
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		hh.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		hh.AddToCardsInHand(new Card(eSuit.Joker, eRank.Joker,1));
		hh.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.ACE,1));
		hh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		
		try {
			hh = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(hh.getHs().getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(hh.getHs().getHiHand() == eRank.ACE.getiRankNbr());
		
		Hand hhh = new Hand();
		hhh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		hhh.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		hhh.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		hhh.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.JACK,1));
		hhh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		
		try {
			hhh = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(hhh.getHs().getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(hhh.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		

		Hand hhhh = new Hand();
		hhhh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		hhhh.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		hhhh.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		hhhh.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.THREE,1));
		hhhh.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		
		try {
			hhhh = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(hhhh.getHs().getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(hhhh.getHs().getHiHand() == eRank.TEN.getiRankNbr());
	
	}
}
