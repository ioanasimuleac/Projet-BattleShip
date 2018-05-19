package simuleac.ioanaveronica;

public class Coordinates {
	private char x;
	private int y;
	
	public Coordinates(char c, int i){
		this.x = c;
		this.y = i;
	}

	public char getX() {
		return x;
	}

	public void setX(char x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	//foncion pour verifier si les donnees introduites sont correctes
	private boolean isGoodX(Coordinates c) {
		char xc = c.getX();
		return (xc >= 'A' && xc <= 'J');
	}
	private boolean isGoodY(Coordinates c) {
		int yc = c.getY();
		return (yc >= 1 && yc <= 10);
	}
	public boolean isGood() {
		return (this.isGoodX(this) && this.isGoodY(this));
	}
	
	//fonctions pour verifier si les coordonnees introduites peuvent creer une bateau
	//adica daca pot cele doua coordonate sunt pe linie sau pe coloana
	public boolean isGoodPlaced(Coordinates ct) {
		return (this.getX() == ct.getX() || this.getY() == ct.getY());
	}
	
	//fonction qui va
	//public void getNei
	
	//fonctions pour verifier isHit()
	public boolean inBetweenX(Coordinates cEnd,Coordinates cMissile){
		char cXS = this.getX();
		char cXE = cEnd.getX();
		char cM = cMissile.getX();
		return ((cXS <= cM) && (cXE >= cM));
	}
	
	public boolean inBetweenY(Coordinates cEnd,Coordinates cMissile){
		int cXS = this.getY();
		int cXE = cEnd.getY();
		int cM = cMissile.getY();
		return ((cXS <= cM) && (cXE >= cM));
	}
	
	public boolean equals(Coordinates c2) {
		return ((this.getX() == c2.getX()) && (this.getY() == c2.getY()));
	}

	@Override
	public String toString() {
		return "Coordinates [x=" + x + ", y=" + y + "]";
	}
	
	
}
