package simuleac.ioanaveronica;

public interface IPlayerAI {
	
	public char donneCharRandom(int r);
	public int donneIntRandom();
	public void placedShips(Ships s);//placer random ships
	public boolean attaque(Player p);
	
}