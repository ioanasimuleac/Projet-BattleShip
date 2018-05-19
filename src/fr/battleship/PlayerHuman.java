package fr.battleship;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerHuman extends Player{
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", battlefield=" + this.getBattlefield()+ ", fleet=" + this.getFleet().toString() + "]";
	}

	//placer les ships sur le grid
	public void placedShips(Ships s) {
		boolean pos = s.isOnColonne();
		//System.out.println("in ce pozitie e barca: " + pos);
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
			//System.out.println("linia: " + j);
			char sc = s.getStartC().getX();
			//System.out.println("char start: " + sc);
			char ec = s.getEndC().getX();
			//System.out.println("char end: " + ec);
			int i ;
			int n = ec - 'J' + 9;
			//System.out.println("long n: " + n);
			for(i= sc - 'J' + 9 ; i<=n ; i++) {
				//System.out.println("i: " + i);
				this.getBattlefield().setElementMat(j-1,i);
			}
		}
	} 
	
	public int score() {
		int score = 0;
		for(int i=0; i<this.getFleet().size() ; i++) {
			if(this.getFleet().get(i).isDestroyed() == true) {
				score = score +1;
			}
		}
		return score;
	}
	
	public PlayerHuman(String name) {
		this.name = name;
		String x;
		int y;
		int ver;
		Scanner s = new Scanner(System.in);
		System.out.println("Il faut avoir: 1 destroyer, 1 submarine, 1 batleship, 1 cruiser, 1 carrier.Pour chaque partie, il faut donner les coordonnes desirees.");
		System.out.println("");
		System.out.println("Les coordonnees sont compose en deux partie: la partie char qui doit etre entre 'A' et 'J' et partie int entre 1 et 10.");
		System.out.println("");
		
		// carrier
		System.out.println("Bateau: Carrier avec la taille 5 (5 cases occupees)");
		System.out.print("Coordonnee bateau: - coordonnnee de start (char)  ");
		x = s.nextLine();
		System.out.print("Coordonnee bateau: - coordonne de start (int) ");
		y = Integer.parseInt(s.nextLine());
		Coordinates c14 = new Coordinates(x.toUpperCase().charAt(0), y);
		//System.out.println(c14.toString());

		System.out.print("Coordonnee bateau: - coordonnnee de end (char)  ");
		x = s.nextLine();
		System.out.print("Coordonnee bateau: - coordonne de end (int) ");
		y = Integer.parseInt(s.nextLine());
		Coordinates c15 = new Coordinates(x.toUpperCase().charAt(0), y);
		//System.out.println(c15.toString());
		Carrier s9 = new Carrier(c14, c15);
		ver = this.getBattlefield().isFree(s9);
		while (ver != -1) {
			if (ver == 1) {System.out.println("Coordonnees mal introduites!");}
			if (ver == 2) {System.out.println("Coordonnees bien introduites, mais ne pas creer un ship avec ces coordonnees!");}
			if (ver == 3) {System.out.println("Coordonnees bien introduites et on peut creer un ship avec eux, mais le type n'est pas bon!");}
			if (ver == 4) {System.out.println("Coordonnees bien introduites et on peut creer un ship avec eux, le type est bonne, mais le lieu est deja ocuppe!");}
			System.out.println("Faire attention!");
			System.out.println();
			System.out.println("Bateau: Carrier avec la taille 5 (5 cases occupees)");
			System.out.print("Coordonnee bateau: - coordonnnee de start (char)  ");
			x = s.nextLine();
			System.out.print("Coordonnee bateau: - coordonne de start (int) ");
			y = Integer.parseInt(s.nextLine());
			c14 = new Coordinates(x.toUpperCase().charAt(0), y);
			//System.out.println(c14.toString());

			System.out.print("Coordonnee bateau: - coordonnnee de end (char)  ");
			x = s.nextLine();
			System.out.print("Coordonnee bateau: - coordonne de end (int) ");
			y = Integer.parseInt(s.nextLine());
			c15 = new Coordinates(x.toUpperCase().charAt(0), y);
			//System.out.println(c15.toString());
			s9 = new Carrier(c14, c15);
			ver = this.getBattlefield().isFree(s9);
		}
		this.getFleet().add(s9);
		this.placedShips(s9);
		
		// battleship
		System.out.println("Bateau : BattleShip avec la taille 4 (4 cases occupees)");
		System.out.print("Coordonnee bateau: - coordonnnee de start (char)  ");
		x = s.nextLine();
		System.out.print("Coordonnee bateau: - coordonne de start (int) ");
		y = Integer.parseInt(s.nextLine());
		Coordinates c10 = new Coordinates(x.toUpperCase().charAt(0), y);
		//System.out.println(c10.toString());

		System.out.print("Coordonnee bateau: - coordonnnee de end (char)  ");
		x = s.nextLine();
		System.out.print("Coordonnee bateau: - coordonne de end (int) ");
		y = Integer.parseInt(s.nextLine());
		Coordinates c11 = new Coordinates(x.toUpperCase().charAt(0), y);
		//System.out.println(c11.toString());
		ShipBattle s7 = new ShipBattle(c10, c11);
		ver = this.getBattlefield().isFree(s7);
		while (ver != -1) {
			if (ver == 1) {System.out.println("Coordonnees mal introduites!");}
			if (ver == 2) {System.out.println("Coordonnees bien introduites, mais ne pas creer un ship avec ces coordonnees!");}
			if (ver == 3) {System.out.println("Coordonnees bien introduites et on peut creer un ship avec eux, mais le type n'est pas bon!");}
			if (ver == 4) {System.out.println("Coordonnees bien introduites et on peut creer un ship avec eux, le type est bonne, mais le lieu est deja ocuppe!");}
			System.out.println("Faire attention!");
			System.out.println();
			System.out.println("Bateau: BattleShip avec la taille 4 (4 cases occupees)");
			System.out.print("Coordonnee bateau: - coordonnnee de start (char)  ");
			x = s.nextLine();
			System.out.print("Coordonnee bateau: - coordonne de start (int) ");
			y = Integer.parseInt(s.nextLine());
			c10 = new Coordinates(x.toUpperCase().charAt(0), y);
			//System.out.println(c10.toString());

			System.out.print("Coordonnee bateau: - coordonnnee de end (char)  ");
			x = s.nextLine();
			System.out.print("Coordonnee bateau: - coordonne de end (int) ");
			y = Integer.parseInt(s.nextLine());
			c11 = new Coordinates(x.toUpperCase().charAt(0), y);
			//System.out.println(c11.toString());
			s7 = new ShipBattle(c10, c11);
			ver = this.getBattlefield().isFree(s7);
		}
		this.getFleet().add(s7);
		this.placedShips(s7);
		
		// cruiser
		System.out.println("Bateau: Cruiser avec la taille 3 (3 cases occupees)");
		System.out.print("Coordonnee bateau: - coordonnnee de start (char)  ");
		x = s.nextLine();
		System.out.print("Coordonnee bateau: - coordonne de start (int) ");
		y = Integer.parseInt(s.nextLine());
		Coordinates c12 = new Coordinates(x.toUpperCase().charAt(0), y);
		//System.out.println(c12.toString());
		System.out.print("Coordonnee bateau: - coordonnnee de end (char)  ");
		x = s.nextLine();
		System.out.print("Coordonnee bateau: - coordonne de end (int) ");
		y = Integer.parseInt(s.nextLine());
		Coordinates c13 = new Coordinates(x.toUpperCase().charAt(0), y);
		//System.out.println(c13.toString());
		Cruiser s8 = new Cruiser(c12, c13);
		ver = this.getBattlefield().isFree(s8);
		while (ver != -1) {
			if (ver == 1) {System.out.println("Coordonnees mal introduites!");}
			if (ver == 2) {System.out.println("Coordonnees bien introduites, mais ne pas creer un ship avec ces coordonnees!");}
			if (ver == 3) {System.out.println("Coordonnees bien introduites et on peut creer un ship avec eux, mais le type n'est pas bon!");}
			if (ver == 4) {System.out.println("Coordonnees bien introduites et on peut creer un ship avec eux, le type est bonne, mais le lieu est deja ocuppe!");}
			System.out.println("Faire attention!");
			System.out.println();
			System.out.println("Bateau : Cruiser avec la taille 3 (3 cases occupees)");
			System.out.print("Coordonnee bateau: - coordonnnee de start (char)  ");
			x = s.nextLine();
			System.out.print("Coordonnee bateau: - coordonne de start (int) ");
			y = Integer.parseInt(s.nextLine());
			c12 = new Coordinates(x.toUpperCase().charAt(0), y);
			//System.out.println(c12.toString());

			System.out.print("Coordonnee bateau: - coordonnnee de end (char)  ");
			x = s.nextLine();
			System.out.print("Coordonnee bateau: - coordonne de end (int) ");
			y = Integer.parseInt(s.nextLine());
			c13 = new Coordinates(x.toUpperCase().charAt(0), y);
			//System.out.println(c13.toString());
			s8 = new Cruiser(c12, c13);
			ver = this.getBattlefield().isFree(s8);

		}
		this.getFleet().add(s8);
		this.placedShips(s8);
		
		// prima barca SUBMARIN
		System.out.println("Bateau: SUBMARIN avec la taille 3 (3 cases occupees)");
		System.out.print("Coordonnee bateau: - coordonnnee de start (char)  ");
		x = s.nextLine();
		System.out.print("Coordonnee bateau: - coordonne de start (int) ");
		y = Integer.parseInt(s.nextLine());
		Coordinates c4 = new Coordinates(x.toUpperCase().charAt(0), y);
		// System.out.println(c4.toString());

		System.out.print("Coordonnee bateau: - coordonnnee de end (char)  ");
		x = s.nextLine();
		System.out.print("Coordonnee bateau: - coordonne de end (int) ");
		y = Integer.parseInt(s.nextLine());
		Coordinates c5 = new Coordinates(x.toUpperCase().charAt(0), y);
		// System.out.println(c5.toString());
		Submarin s4 = new Submarin(c4, c5);
		ver = this.getBattlefield().isFree(s4);
		while (ver != -1) {
			if (ver == 1) {System.out.println("Coordonnees mal introduites!");}
			if (ver == 2) {System.out.println("Coordonnees bien introduites, mais ne pas creer un ship avec ces coordonnees!");}
			if (ver == 3) {System.out.println("Coordonnees bien introduites et on peut creer un ship avec eux, mais le type n'est pas bon!");}
			if (ver == 4) {System.out.println("Coordonnees bien introduites et on peut creer un ship avec eux, le type est bonne, mais le lieu est deja ocuppe!");}
			{System.out.println("Faire attention!");}
			System.out.println();
			System.out.println("Bateau: SUBMARIN avec la taille 3 (3 cases occupees)");
			System.out.print("Coordonnee bateau: - coordonnnee de start (char)  ");
			x = s.nextLine();
			System.out.print("Coordonnee bateau: - coordonne de start (int) ");
			y = Integer.parseInt(s.nextLine());
			c4 = new Coordinates(x.toUpperCase().charAt(0), y);
			// System.out.println(c4.toString());

			System.out.print("Coordonnee bateau: - coordonnnee de end (char)  ");
			x = s.nextLine();
			System.out.print("Coordonnee bateau: - coordonne de end (int) ");
			y = Integer.parseInt(s.nextLine());
			c5 = new Coordinates(x.toUpperCase().charAt(0), y);
			// System.out.println(c5.toString());
			s4 = new Submarin(c4, c5);
			ver = this.getBattlefield().isFree(s4);

		}
		this.getFleet().add(s4);
		this.placedShips(s4);
		
		// DESTROYER
		System.out.println("Bateau: DESTROYER avec la taille 2 (2 cases occupees).");
		System.out.print("Coordonnee bateau: - coordonnnee de start (char)  ");
		x = s.nextLine();
		System.out.print("Coordonnee bateau: - coordonne de start (int) ");
		y = Integer.parseInt(s.nextLine());
		Coordinates c1 = new Coordinates(x.toUpperCase().charAt(0) , y);
		//System.out.println(c1.toString());
		
		System.out.print("Coordonnee bateau: - coordonnnee de end (char)  ");
		x = s.nextLine();
		System.out.print("Coordonnee bateau: - coordonne de end (int) ");
		y = Integer.parseInt(s.nextLine());
		Coordinates c = new Coordinates(x.toUpperCase().charAt(0), y);
		
		Destroyer s1 = new Destroyer(c1,c);
		ver = this.getBattlefield().isFree(s1);
		while(ver != -1) {
			if(ver == 1) {System.out.println("Coordonnees mal introduites!");}
			if(ver == 2) {System.out.println("Coordonnees bien introduites, mais ne pas creer un ship avec ces coordonnees!");}
			if(ver == 3) {System.out.println("Coordonnees bien introduites et on peut creer un ship avec eux, mais le type n'est pas bon!");}
			if (ver == 4) {System.out.println("Coordonnees bien introduites et on peut creer un ship avec eux, le type est bonne, mais le lieu est deja ocuppe!");}
			{System.out.println("Faire attention!");}
			System.out.println();
			System.out.println("Bateau: DESTROYER avec la taille 2 (2 cases occupees).");
			System.out.print("Coordonnees bateau: - coordonnnee de start (char)  ");
			x = s.nextLine();
			System.out.print("Coordonnees bateau: - coordonne de start (int) ");
			y = Integer.parseInt(s.nextLine());
			c1 = new Coordinates(x.toUpperCase().charAt(0) , y);
			//System.out.println(c1.toString());
			
			System.out.print("Coordonnee bateau: - coordonnnee de end (char)  ");
			x = s.nextLine();
			System.out.print("Coordonnee bateau: - coordonne de end (int) ");
			y = Integer.parseInt(s.nextLine());
			c = new Coordinates(x.toUpperCase().charAt(0), y);
			
			s1 = new Destroyer(c1,c);
			ver = this.getBattlefield().isFree(s1);
		}
		this.getFleet().add(s1);
		this.placedShips(s1);

		
	}
}

