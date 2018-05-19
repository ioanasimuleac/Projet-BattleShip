package simuleac.ioanaveronica;

import java.util.*;

public class Grid {
	private String mat[][] = new String[10][10];
	
	public Grid() {
		for(int i = 0; i<10;i++) {
			for(int j = 0; j<10; j++) {
				mat[i][j] = "|-| ";
			}
		}
	}
	
	public String[][] getMat() {
		return mat;
	}

	public void setElementMat(int x, int y) {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(i == x && y == j) {
					mat[i][j] = "|S| ";
				}
			}
		}
	}
	public void setHitElement(char x, int y) {
		//joaca-te cu elementele pana il faci cum trebuie
		int c = x - 'J' + 9;
		//System.out.println("val lui char x in int: "+c);
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(i == c && (y-1) == j) {
					mat[j][i] = "|X| ";
				}
			}
		}
	}

	public void showGrid() {
		for(char c = 'A'; c<='J';c++) {
			System.out.print(" " + c+ "  ");
		}
		System.out.println();
		for(int i = 0; i<10;i++) {
			System.out.print(i);
			for(int j = 0; j<10; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println("");
		}
		
	}
	//fonction pour verifier si on a "hit" la meme place
	//renvoie true si la place a ete deja hit
	//sinon false
	public boolean checkedHit(Coordinates coord) {
		boolean checkHit = false;
		char c = coord.getX();
		int x = c - 'J' + 9;
		int y = coord.getY() - 1;
		for(int i = 0; i<10; i++) {
			for(int j =0 ; j<10; j++) {
				if((i == y && j == x ) && (mat[i][j] == "|X| " )) {
					checkHit = true;
				}
				
			}
			
		}
		return checkHit;

	}
	
	//function pour verifier si la matrice est arrivee a la fin de se case libre
	public boolean isLibre() {
		boolean libre = false;
		for(int i = 0; i<10;i++) {
			for(int j = 0; j<10; j++) {
				if(this.mat[i][j] == "|-| ") {
					libre = true;
				};
			}
		}
		
		
		return libre;
	}
	
	
	//verific daca pot sa pun pe grid
	//daca distanta dintre start si end nu este egala cu "|X| "
	public int isFree(Ships s) {
		boolean notHere = false;
		int veri = s.verification();
		if(veri == -1) {
			boolean pos = s.isOnColonne();
			//System.out.println("in ce pozitie e barca: " + pos);
			if(pos == true) {
				char c = s.getStartC().getX();
				int x = c - 'J' + 9;
				int i;
				int n = s.getEndC().getY();
				for(i =s.getStartC().getY()-1; i<n;i++) {
					//System.out.println("linia: " +this.mat[i][x] );
					if(this.mat[i][x] ==  "|S| ") {
						notHere = true;
					}
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
					//System.out.println("linia: " + this.mat[j-1][i]);
					if(this.mat[j-1][i] ==  "|S| ") {
						notHere = true;
					}
				}
			}
			//cannot put here the ship => return 4
			if(notHere == true) {
				return 4;
			}else {return -1;}//if notHere remains false, meaning i can put the ship there, return -1
		} else {return veri;} //daca are alte probleme intai
		
	}
}


