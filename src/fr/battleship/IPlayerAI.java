package fr.battleship;

public interface IPlayerAI {
	
	public char donneCharRandom(int r);
	public int donneIntRandom();
	public void placedShips(Ships s);//plasare random ships
	public boolean attaque(Player p);
	
}