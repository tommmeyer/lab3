package pokerBase;
import java.util.ArrayList;
import java.util.UUID;

public class Table {
	private UUID TableID;
	private ArrayList<Player> tablePlayers = new ArrayList<Player>();
	
	public Table()
	{
		TableID = UUID.randomUUID();
	}
	
	public Table AddPlayerToTable(Player p)
	{
		tablePlayers.add(p);
		return this;
	}	
	
	public ArrayList<Player> getTablePlayers(){
		return tablePlayers;
	}
	public int tableSize(){
		return tablePlayers.size();
	}

}
