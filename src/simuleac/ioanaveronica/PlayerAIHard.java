package simuleac.ioanaveronica;

import java.util.Random;
import java.util.Stack;

public class PlayerAIHard extends Player implements IPlayerAI {
	private Stack<Coordinates> stackHints = new Stack<Coordinates>();
	
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

	public PlayerAIHard() {
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
		//System.out.println("Is it empty?: " + stackHints.isEmpty());
		if(stackHints.isEmpty() == true) {
			boolean hit = false;
			boolean check;
			Coordinates c1 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
			check = c1.isGood();
			while(check == false ) {
				c1 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
				check = c1.isGood();
			}
			boolean ceee = p.getBattlefield().checkedHit(c1);
			//System.out.println("coordonata c1: " +c1.toString());
			while(ceee == true && p.getBattlefield().isLibre() == true) {
				c1 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
				ceee = p.getBattlefield().checkedHit(c1);
				check = c1.isGood();
				while(check == false ) {
					c1 = new Coordinates(donneCharRandom(donneIntRandom()), donneIntRandom());
					check = c1.isGood();
				}
				
			}
			p.getBattlefield().setHitElement(c1.getX(), c1.getY());
			for(int i = 0; i<p.getFleet().size() ; i++) {
				if(p.getFleet().get(i).isHit(c1) == true) {
					//System.out.println("is hit!");
					hit = true;	
					//bagi coordonatele vecine in stack daca sunt diferite de hitAlready si daca sunt si corect facute
					Coordinates cem = new Coordinates((char)(c1.getX() + 1), c1.getY());
					if(cem.isGood() == true && p.getBattlefield().checkedHit(cem) == false){
						stackHints.push(cem);
					}
					
					Coordinates cem1 = new Coordinates((char)(c1.getX()), c1.getY() + 1);
					if(cem1.isGood() == true  && p.getBattlefield().checkedHit(cem1)== false) {
						stackHints.push(cem1);
					}
					
					Coordinates cem2 = new Coordinates((char)(c1.getX() ), c1.getY() - 1);
					if(cem2.isGood() == true && p.getBattlefield().checkedHit(cem2)== false){
						stackHints.push(cem2);
					}
					
					Coordinates cem3 = new Coordinates((char)(c1.getX() - 1), c1.getY() );
					if(cem3.isGood() == true && p.getBattlefield().checkedHit(cem3)== false){
						stackHints.push(cem3);
					}
				}
			}
			return hit;
		}else {
			Coordinates fromStack = stackHints.pop();
			//System.out.println("sortir de la pile: " + fromStack.toString());
			boolean hitt = false;
			p.getBattlefield().setHitElement(fromStack.getX(), fromStack.getY());
			for(int i = 0; i<p.getFleet().size() ; i++) {
				if(p.getFleet().get(i).isHit(fromStack) == true) {
					hitt = true;
					//bagi coordonatele vecine in stack daca sunt diferite de hitAlready si daca sunt si corect facute
					Coordinates cem = new Coordinates((char)(fromStack.getX() + 1), fromStack.getY());
					if(cem.isGood() == true && p.getBattlefield().checkedHit(cem)== false){
						stackHints.push(cem);
					}
					
					Coordinates cem1 = new Coordinates((char)(fromStack.getX()), fromStack.getY() + 1);
					if(cem1.isGood() == true  && p.getBattlefield().checkedHit(cem1)== false){
						stackHints.push(cem1);
					}
					
					Coordinates cem2 = new Coordinates((char)(fromStack.getX() ), fromStack.getY() - 1);
					if(cem2.isGood() == true && p.getBattlefield().checkedHit(cem2)== false){
						stackHints.push(cem2);
					}
					
					Coordinates cem3 = new Coordinates((char)(fromStack.getX() - 1), fromStack.getY() );
					if(cem3.isGood() == true && p.getBattlefield().checkedHit(cem3)== false){
						stackHints.push(cem3);
					}
				}
			}
			return hitt;	
		}
		
		
	}
}