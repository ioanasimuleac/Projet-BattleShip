package simuleac.ioanaveronica;

public class Submarin extends Ships{
	private static int taille = 3;

	public Submarin() {}
	
	public Submarin(Coordinates startC, Coordinates endC){
		super(startC, endC);
	}
	
	//position
	public boolean isOnLigne(){
		return (this.getEndC().getY() == this.getStartC().getY());
	}
	public boolean isOnColonne(){//efectiv ship-ul asezat pe o coloana
		return (this.getEndC().getX() == this.getStartC().getX());
	}
	
	public boolean isDestroyed() {
		return (this.getHasBeenHit() == taille);
	}
	
	public boolean isHit(Coordinates cMissile) {
		boolean howIsIt = (this.getStartC().inBetweenX(this.getEndC(), cMissile) && 
				this.getStartC().inBetweenY(this.getEndC(), cMissile));
		if(howIsIt == true) {
			if(this.getHasBeenHit() != taille) {this.setHasBeenHit(this.getHasBeenHit() + 1);}
			//else {System.out.println("A atins limita!");}
		}
		return howIsIt;
	}
	
	// -1 si tout est bon
	// 1 si les coordononnees sont mal ecrites
	// 2 si nu pot creea shipul cu datele date
	// 3 si shipul creat nu are lungimea care trebuie
	public int verification() {
		boolean ar;
		boolean goodCoordStart = this.getStartC().isGood();
		boolean goodCoordEnd = this.getEndC().isGood();

		if (goodCoordStart == goodCoordEnd == true) {// ca coordonatele sunt corecte
			ar = this.getStartC().isGoodPlaced(this.getEndC());// ca pot creea un ship
			if (ar == true) {
				boolean ver = this.isOnLigne();
				int mesure;
				if (ver == true) {// ce am creat chiar este ce trebuie
					mesure = (this.getEndC().getX() - this.getStartC().getX()) + 1;
				} else {
					mesure = (this.getEndC().getY() - this.getStartC().getY()) + 1;
				}
				if (mesure == taille) {
					return -1;
				} else {
					return 3;
				}
			} else {
				return 2;
			}

		} else {
			return 1;
		}

	}
}
