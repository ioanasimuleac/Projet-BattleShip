package simuleac.ioanaveronica;

import java.util.ArrayList;

public class Player {
	private Grid battlefield = new Grid();
	private ArrayList<Ships> fleet = new ArrayList<Ships>();
	
	public Grid getBattlefield() {
		return battlefield;
	}
	
	public ArrayList<Ships> getFleet() {
		return fleet;
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
	
}

