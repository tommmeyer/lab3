package pokerBase;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Game {

private UUID GameId;
private ArrayList<Player> gamePlayers = new ArrayList<Player>();
private ArrayList<Table> gameTables = new ArrayList<Table>();

public Game(){
	GameId = UUID.randomUUID();
}
public Game addPlayerToGame(Player p, Table t){
	t.AddPlayerToTable(p);
	gamePlayers.add(p);
	return this;
}
public Game addTableToGame(Table t){
	gameTables.add(t);
	return this;
}
public ArrayList<Player> getGamePlayers(){
	return gamePlayers;
}
public ArrayList<Table> getGameTables(){
	return gameTables;
}
}
