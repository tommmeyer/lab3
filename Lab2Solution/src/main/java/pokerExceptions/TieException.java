package pokerExceptions;
import java.util.ArrayList;
import pokerBase.HandScore;
import pokerBase.Hand;

public class TieException extends Exception {
	public ArrayList<Hand> tiedHands;
	public TieException(ArrayList<Hand> hands){
		int i =0;
		tiedHands.add(hands.get(0));
		do{
			tiedHands.add(hands.get(i+1));
			i++;
		}
		while(hands.get(i).getHs().equals(hands.get(i+1).getHs()));
		int playersTied = tiedHands.size();
		System.out.println(playersTied + " players have a tie score and will split the pot.");
	}
	
}
