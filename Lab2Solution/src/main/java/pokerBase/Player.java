package pokerBase;
import java.util.UUID;
import java.util.ArrayList;
public class Player {
	private UUID PlayerID;
	private String PlayerName;
	
	public Player(String strPlayerName)
	{
		PlayerID = UUID.randomUUID();
		this.PlayerName = strPlayerName;
		
	}
	public String getPlayer(){
		return this.PlayerName;
	}
	public int PlayerPosition(){
		Table table = new Table();
		int playerPosition = 0;
		ArrayList<Player> thisTable = table.getTablePlayers();
		for (int i = 0; i < table.tableSize(); i++)
	    {
	        Player player = thisTable.get(i);
	        if (getPlayer().equals(player))
	        {
	            playerPosition = i+1;
	        }
	    }
		return playerPosition;
	}
	
}
