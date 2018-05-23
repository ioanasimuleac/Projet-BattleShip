package simuleac.ioanaveronica;

import java.util.Random;

public class PlayerAIMedium extends Player implements IPlayerAI{

	@Override
	public char donneCharRandom(int r) {
		Random rnd = new Random();
		char b = (char) (r+64);
		return b;
	}
	
	@Override
	public int donneIntRandom() {
		Random rnd = new Random();
		int r = rnd.nextInt(10) + 1;
		return r;
	}
	
	@Override
	public void placedShips(Ships s) {
		boolean pos = s.isOnColonne();
		if(pos == true) {
			char c = s.getStartC().getX();
			int x = c - 'J' + 9;
			int i;
			int n = s.getEndC().getY();
			for(i =s.getStartC().getY()-1; i<n;i++) {
				this.getBattlefield().setElementMat(i,x);
			}
		}else {
			int j = s.getStartC().getY();
			char sc = s.getStartC().getX();
			char ec = s.getEndC().getX();
			int i ;
			int n = ec - 'J' + 9;
			for(i= sc - 'J' + 9 ; i<=n ; i++) {
				this.getBattlefield().setElementMat(j-1,i);
			}
		}
	} 

	public PlayerAIMedium() {
		int ver;
		Coordinates coordonata = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
		Coordinates coor = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
		Destroyer d1 = new Destroyer(coordonata, coor);
		ver = this.getBattlefield().isFree(d1);
		while(ver != -1) {
			coordonata = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
			coor = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
			d1 = new Destroyer(coordonata, coor);
			ver = this.getBattlefield().isFree(d1);
		}
		this.getFleet().add(d1);
		this.placedShips(d1);
		//System.out.println( "Destroyer: "+ d1.toString());
		
		Coordinates c1 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
		Coordinates c2 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
		Submarin s = new Submarin(c1,c2);
		ver = this.getBattlefield().isFree(s);
		while(ver != -1) {
			c1 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
			c2 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
			s = new Submarin(c1,c2);
			ver = this.getBattlefield().isFree(s);
		}
		this.getFleet().add(s);
		this.placedShips(s);
		//System.out.println();
		//System.out.println("Submarin: " + s.toString());
		
		Coordinates c3 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
		Coordinates c4 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
		ShipBattle b = new ShipBattle(c3,c4);
		ver = this.getBattlefield().isFree(b);
		while(ver != -1) {
			c3 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
			c4 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
			b = new ShipBattle(c3,c4);
			ver = this.getBattlefield().isFree(b);
		}
		this.getFleet().add(b);
		this.placedShips(b);
		//System.out.println();
		//System.out.println("BattleShip: " + b.toString());
	
		
		Coordinates c5 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
		Coordinates c6 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
		Carrier c = new Carrier(c5,c6);
		ver = this.getBattlefield().isFree(c);
		while(ver != -1) {
			c5 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
			c6 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
			c = new Carrier(c5,c6);
			ver = this.getBattlefield().isFree(c);
		}
		this.getFleet().add(c);
		this.placedShips(c);
		//System.out.println();
		//System.out.println("Carrier: " + c.toString());
		
		Coordinates c7 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
		Coordinates c8 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
		Cruiser cr = new Cruiser(c7,c8);
		ver = this.getBattlefield().isFree(cr);
		while(ver != -1) {
			c7 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
			c8 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
			cr = new Cruiser(c7,c8);
			ver = this.getBattlefield().isFree(cr);
		}
		this.getFleet().add(cr);
		this.placedShips(cr);
		//System.out.println();
		//System.out.println("Cruiser: " + cr.toString());
	}

	public boolean attaque(Player p) {
		boolean hit = false;
		boolean check;
		Coordinates c1 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
		/*check = c1.isGood();
		while(check == false ) {
			c1 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
			check = c1.isGood();
		}*/
		boolean ceee = p.getBattlefield().checkedHit(c1);
		while(ceee == true && p.getBattlefield().isLibre() == true) {
			c1 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
			ceee = p.getBattlefield().checkedHit(c1);
			/*check = c1.isGood();
			while(check == false ) {
				c1 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
				check = c1.isGood();
			}*/
			
		}
		p.getBattlefield().setHitElement(c1.getX(), c1.getY());
		for(int i = 0; i<p.getFleet().size() ; i++) {
			if(p.getFleet().get(i).isHit(c1) == true) {
				hit = true;
			}
		}
		return hit;
		
	}
}