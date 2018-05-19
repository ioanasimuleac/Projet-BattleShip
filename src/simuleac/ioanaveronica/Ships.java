package simuleac.ioanaveronica;

public abstract class Ships {
	private Coordinates startC;
	private Coordinates endC;
	private int hasBeenHit = 0;

	public abstract boolean isDestroyed();
	public abstract int verification();
	public abstract boolean isHit(Coordinates cMissile) ;

	public Ships() {}
	
	public Ships(Coordinates startC, Coordinates endC){
		this.startC = startC;
		this.endC = endC;
	}
	
	public int getHasBeenHit() {
		return hasBeenHit;
	}

	public void setHasBeenHit(int hasBeenHit) {
		this.hasBeenHit = hasBeenHit;
	}
	
	public Coordinates getStartC() {
		return startC;
	}

	public void setStartC(Coordinates startC) {
		this.startC = startC;
	}

	public Coordinates getEndC() {
		return endC;
	}

	public void setEndC(Coordinates endC) {
		this.endC = endC;
	}
	
	//position
	public boolean isOnLigne(){
		return (this.getEndC().getY() == this.getStartC().getY());
	}
	public boolean isOnColonne(){//efectiv ship-ul asezat pe o coloana
		return (this.getEndC().getX() == this.getStartC().getX());
	}
	
	@Override
	public String toString() {
		return " [startC=" + startC + ", endC=" + endC + "]";
	}
	
}
