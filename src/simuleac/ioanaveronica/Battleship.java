package simuleac.ioanaveronica;

import java.util.Scanner;

public class Battleship {

	public static void main(String[] args) {
		System.out.println("Choisissez avec qui vous voulez jouer: HUMAN ou AI.");
		System.out.println("Pour HUMAN introduisez 1.");
		System.out.println("Pour AI introduisez 2.");
		Scanner ss = new Scanner(System.in);
		int choix = Integer.parseInt(ss.nextLine());
		switch(choix){
		case 1:
			int recommencer = 1;
			int joueur = 1;
			String x;
			int y;
			int ver;
			Scanner s = new Scanner(System.in);
			System.out.println("Alors, on commence la hard partie.");
			System.out.println();
			System.out.print("Player 1: Ton nome?");
			x = s.nextLine();
			//creation de la flotte pour Player 1
			PlayerHuman p1 = new PlayerHuman(x);
			p1.getBattlefield().showGrid();
			
			System.out.print("Player 2: Ton nome?");
			x = s.nextLine();
			//creation de la flotte Player 2
			PlayerHuman p2 = new PlayerHuman(x); 
			p2.getBattlefield().showGrid();
			
			while(recommencer == 1) {
				//the game
				System.out.println("Let's start!");
				while((p1.score() != p1.getFleet().size()) && (p2.score() != p2.getFleet().size())) {
					switch(joueur) {
						case 1: 
							boolean hit = false;
							boolean check;
							System.out.println("Player 1 : "+ p1.getName() + " , ou que vous voudriez tirer?");
							System.out.println("Donnez la coordonnees! svp!");
							System.out.println("");
							System.out.print("Coordonnee bateau (char) : ");
							x = s.nextLine();
							System.out.print("Coordonnee bateau (int) : ");
							y = Integer.parseInt(s.nextLine());
							Coordinates c14 = new Coordinates(x.toUpperCase().charAt(0), y);
							check = c14.isGood();
							while(check == false ) {
								System.out.println("SVP faire attention aux coordonnees introduites!");
								System.out.println("");
								System.out.print("Coordonnee bateau (char) : ");
								x = s.nextLine();
								System.out.print("Coordonnee bateau (int) : ");
								y = Integer.parseInt(s.nextLine());
								c14 = new Coordinates(x.toUpperCase().charAt(0), y);
								check = c14.isGood();
							}
							//System.out.println(c14.toString());
							p2.getBattlefield().setHitElement(x.toUpperCase().charAt(0), y);
							for(int i = 0; i<p2.getFleet().size() ; i++) {
								if(p2.getFleet().get(i).isHit(c14) == true) {
									hit = true;
								}
							}
							System.out.println("Grid " + p1.getName() + " :");
							p1.getBattlefield().showGrid();
							System.out.print("");
							if(hit == true) {
								while(hit == true && (p2.score() != p2.getFleet().size()) ) {//vreau sa ma opresc daca hit == false sau daca p1 a lovit tot ce se poate de la p2
									hit = false;
									System.out.println("Player 1 : "+ p1.getName() );
									System.out.println("Vous avez touche une partie de bateau de votre enimie. Alors vous avez une nouvelle possibilite de tirer encore fois!");
									System.out.println("Quelle est la case que vous voudriez toucher?");
									System.out.println("Donnez la coordonnees! svp!");
									System.out.println("");
									System.out.print("Coordonnee bateau (char) : ");
									x = s.nextLine();
									System.out.print("Coordonnee bateau (int) : ");
									y = Integer.parseInt(s.nextLine());
									c14 = new Coordinates(x.toUpperCase().charAt(0), y);
									check = c14.isGood();
									while(check == false ) {
										System.out.println("SVP faire attention aux coordonnees introduites!");
										System.out.println("");
										System.out.print("Coordonnee bateau (char) : ");
										x = s.nextLine();
										System.out.print("Coordonnee bateau (int) : ");
										y = Integer.parseInt(s.nextLine());
										c14 = new Coordinates(x.toUpperCase().charAt(0), y);
										check = c14.isGood();
									}
									//System.out.println(c14.toString());
									System.out.println("");
									p2.getBattlefield().setHitElement(x.toUpperCase().charAt(0), y);
									for(int i = 0; i<p2.getFleet().size() ; i++) {
										if(p2.getFleet().get(i).isHit(c14) == true) {hit = true;}
										joueur = 2;
									}
								}
								System.out.println("Grid " + p1.getName()+" :");
								p1.getBattlefield().showGrid();
							}else {joueur = 2;}
							
							break;
							
						case 2:
							boolean frappe = false;
							boolean checked;
							System.out.println("Player 2 : "+ p2.getName() + " , ou vous voudriez tirer?");
							System.out.println("Donnez les coordonnees! svp!");
							System.out.println("");
							System.out.print("Coordonnee bateau (char) : ");
							x = s.nextLine();
							System.out.print("Coordonnee bateau (int) : ");
							y = Integer.parseInt(s.nextLine());
							Coordinates c = new Coordinates(x.toUpperCase().charAt(0), y);
							checked = c.isGood();
							while(checked == false ) {
								System.out.println("SVP faire attention aux coordonnees introduites!");
								System.out.println("");
								System.out.print("Coordonnee bateau (char) : ");
								x = s.nextLine();
								System.out.print("Coordonnee bateau (int) : ");
								y = Integer.parseInt(s.nextLine());
								c = new Coordinates(x.toUpperCase().charAt(0), y);
								checked = c.isGood();
							}
							//System.out.println(c.toString());
							p1.getBattlefield().setHitElement(x.toUpperCase().charAt(0), y);
							for(int i = 0; i<p1.getFleet().size() ; i++) {
								if(p1.getFleet().get(i).isHit(c) == true) {frappe = true;}
							}
							System.out.println("Grid " + p2.getName()+": ");
							p2.getBattlefield().showGrid();
							if(frappe == true) {
								while(frappe == true && (p1.score() != p1.getFleet().size())) {
									frappe = false;
									System.out.println("Player 2 : "+ p2.getName() );
									System.out.println("Vous avez touche une partie de bateau de votre enimie. Alors vous avez la possibilite de tirer encore fois!");
									System.out.println("Player 2: quelle est la case que vous voudriez frapper?");
									System.out.println("Donnez la coordonnees! svp!");
									System.out.println("");
									System.out.print("Coordonnee bateau (char) : ");
									x = s.nextLine();
									System.out.print("Coordonnee bateau (int) : ");
									y = Integer.parseInt(s.nextLine());
									c = new Coordinates(x.toUpperCase().charAt(0), y);
									//System.out.println(c.toString());
									checked = c.isGood();
									while(checked == false ) {
										System.out.println("SVP faire attention aux coordonnees introduites!");
										System.out.print("Coordonnee bateau (char) : ");
										x = s.nextLine();
										System.out.print("Coordonnee bateau (int) : ");
										y = Integer.parseInt(s.nextLine());
										c = new Coordinates(x.toUpperCase().charAt(0), y);
										checked = c.isGood();
									}
									System.out.println("");
									p1.getBattlefield().setHitElement(x.toUpperCase().charAt(0), y);
									for(int i = 0; i<p1.getFleet().size() ; i++) {
										if(p1.getFleet().get(i).isHit(c) == true) {frappe = true;}
										joueur = 1;
									}
								}
								System.out.println("Grid " + p2.getName()+": ");
								p2.getBattlefield().showGrid();
							}else {joueur = 1;}
							break;
					}
				}
				System.out.println("Grid " + p1.getName()+": ");
				p1.getBattlefield().showGrid();
				System.out.println("Grid " + p2.getName()+": ");
				p2.getBattlefield().showGrid();
				if(p1.score() > p2.score()) {
					System.out.println("GAME OVER!");
					System.out.println("The winner is: " + p2.getName() );
					joueur = 1;
				}else if(p1.score() < p2.score()) {
					System.out.println("GAME OVER!");
					System.out.println("The winner is: " + p1.getName() );
					joueur = 2;
				}else {
					System.out.println("GAME OVER! EGALITATE!");
				}
				
				//i asked you if you want to play again:)
				System.out.println("Vous voulez jouer un autre jeu?");
				System.out.println("Si OUI introduiez 'oui', sinon 'non'");
				Scanner n = new Scanner(System.in);
				String nouveauJeu = n.nextLine();
				System.out.println();
				if(nouveauJeu.equals("oui")) {
					recommencer = 1;
					if(p1.score() > p2.score()) {
						joueur = 1;
						System.out.println("Vous avez choisi de jouer un autre jeu!");
						System.out.println("Il faut recreer tous les bateaux!");
						System.out.println();
						System.out.println("Joueur " + p1.getName() + " commence! ");
						//creation de la flotte pour Player 1
						p1 = new PlayerHuman(p1.getName());
						System.out.println("Grid " + p1.getName());
						p1.getBattlefield().showGrid();
						//creation de la flotte Player 2
						System.out.println();
						System.out.println("Et ....");
						System.out.println( "Aussi, le joueur " + p2.getName() + " ! ");
						p2 = new PlayerHuman(p2.getName()); 
						System.out.println("Grid " + p2.getName());
						p2.getBattlefield().showGrid();
					}else {
						joueur = 2;
						System.out.println("Vous avez choisi de jouer un autre jeu!");
						System.out.println("Il faut recreer tous les bateaux!");
						System.out.println();
						System.out.println("Joueur " + p2.getName() + " commence! ");
						//creation de la flotte pour Player 1
						p2 = new PlayerHuman(p2.getName());
						System.out.println("Grid " + p2.getName());
						p2.getBattlefield().showGrid();
						//creation de la flotte Player 2
						System.out.println();
						System.out.println("Et ....");
						System.out.println( "Aussi, le joueur " + p1.getName() + " ! ");
						p1 = new PlayerHuman(p1.getName()); 
						System.out.println("Grid " + p1.getName());
						p1.getBattlefield().showGrid();
					}
				}
				else {recommencer = 2;}
			}
			break;
			
		case 2:
			System.out.println("Vivez AI!");
			System.out.println("Le niveau de AI?");
			System.out.println("Vous avez 3 choix possibles: BEGINNER, MEDIUM et HARD!");
			System.out.println("Introduisez 'beginner' pour BEGINNER, 'medium' pour MEDIUN et 'hard' pour HARD!");
			Scanner sss = new Scanner(System.in);
			String nivel = sss.nextLine().toUpperCase();
			System.out.println("nivel :" + nivel);
			int niveau ;
			if(nivel.equals("BEGINNER")) {
				niveau = 4;
				int recom = 1;
				int yi;
				String xi;
				Scanner nivBeg = new Scanner(System.in);
				System.out.println("Niveau beginner!");
				System.out.println("On commence! Ton nom?");
				String nameHuman = nivBeg.nextLine();
				PlayerHuman ph = new PlayerHuman(nameHuman);
				PlayerAIBeginner pi = new PlayerAIBeginner();
				System.out.println("Grid human:");
				ph.getBattlefield().showGrid();
				System.out.println("Grid AI:");
				pi.getBattlefield().showGrid();
				
				int jucator = 1;
				while(recom == 1) {
					System.out.println("Let's start!");
					while((ph.score() != ph.getFleet().size()) && (pi.score() != pi.getFleet().size())){
						switch(jucator) {
						case 1: //omul ataca
							boolean hit = false;
							boolean check;
							System.out.println("Player 1 : "+ ph.getName() + " , ou vous voulez tirer?");
							System.out.println("Donnez la coordonnees! svp!");
							System.out.println("");
							System.out.print("Coordonnee bateau (char) : ");
							xi = nivBeg.nextLine();
							System.out.print("Coordonnee bateau (int) : ");
							yi = Integer.parseInt(nivBeg.nextLine());
							Coordinates c14 = new Coordinates(xi.toUpperCase().charAt(0), yi);
							check = c14.isGood();
							while(check == false ) {
								System.out.println("SVP faire attention a la coordonnees introduites!");
								System.out.println("");
								System.out.print("Coordonnee bateau (char) : ");
								xi = nivBeg.nextLine();
								System.out.print("Coordonnee bateau (int) : ");
								yi = Integer.parseInt(nivBeg.nextLine());
								c14 = new Coordinates(xi.toUpperCase().charAt(0), yi);
								check = c14.isGood();
							}
							//System.out.println(c14.toString());
							pi.getBattlefield().setHitElement(xi.toUpperCase().charAt(0), yi);
							for(int i = 0; i<pi.getFleet().size() ; i++) {
								if(pi.getFleet().get(i).isHit(c14) == true) {
									hit = true;
								}
							}
							System.out.print("");
							if(hit == true) {
								while(hit == true && (pi.score() != pi.getFleet().size()) ) {//vreau sa ma opresc daca hit == false sau daca p1 a lovit tot ce se poate de la p2
									hit = false;
									System.out.println("Player 1 : "+ ph.getName() );
									System.out.println("Vous avez touche une partie de bateau de votre enimie. Alors vous avez la possibilite de tirer encore fois!");
									System.out.println("Quelle est la case que vous voudriez tirer?");
									System.out.println("Donnez la coordonnees! svp!");
									System.out.println("");
									System.out.print("Coordonnee bateau (char) : ");
									xi = nivBeg.nextLine();
									System.out.print("Coordonnee bateau (int) : ");
									yi = Integer.parseInt(nivBeg.nextLine());
									c14 = new Coordinates(xi.toUpperCase().charAt(0), yi);
									check = c14.isGood();
									while(check == false ) {
										System.out.println("SVP faire attention a la coordonnees introduites!");
										System.out.println("");
										System.out.print("Coordonnee bateau (char) : ");
										xi = nivBeg.nextLine();
										System.out.print("Coordonnee bateau (int) : ");
										yi = Integer.parseInt(nivBeg.nextLine());
										c14 = new Coordinates(xi.toUpperCase().charAt(0), yi);
										check = c14.isGood();
									}
									//System.out.println(c14.toString());
									System.out.println("");
									pi.getBattlefield().setHitElement(xi.toUpperCase().charAt(0), yi);
									for(int i = 0; i<ph.getFleet().size() ; i++) {
										if(pi.getFleet().get(i).isHit(c14) == true) {hit = true;}
										jucator = 2;
									}
								}
								System.out.println("Grid AI:");
								pi.getBattlefield().showGrid();
							}else {jucator = 2;}
							
							break;
						
						case 2:// AI ataca
							boolean atacand = pi.attaque(ph);
							System.out.println("\nTour de AI :) \n ");
							while(atacand == true) {
								atacand = pi.attaque(ph);
							}
							System.out.println("Grid " + ph.getName()+" :");
							ph.getBattlefield().showGrid();
							jucator = 1;
							break;
						}
					}
						System.out.println("Grid " + ph.getName()+": ");
						ph.getBattlefield().showGrid();
						System.out.println("Grid AI: ");
						pi.getBattlefield().showGrid();
						System.out.println("Score human: " +pi.score() );
						System.out.println("Score AI: " +ph.score() );
						if(ph.score() < pi.score()) {
							System.out.println("GAME OVER!");
							System.out.println("The winner is: " + ph.getName() );
						}else if(ph.score() > pi.score()) {
							System.out.println("GAME OVER!");
							System.out.println("The winner is: player AI"  );
						}else {
							System.out.println("GAME OVER! EGALITATE!");
						}
					
						//i asked you if you want to play again:)
						System.out.println("Vous voulez jouer un autre jeu?");
						System.out.println("Si OUI introduiez 'oui', sinon 'non'");
						Scanner n = new Scanner(System.in);
						String nouveauJeu = n.nextLine();
						System.out.println();
						if(nouveauJeu.equals("oui")) {
							recom = 1;
							if(ph.score() > pi.score()) {
								joueur = 1;
								System.out.println("Vous avez choisi de jouer un autre jeu!");
								System.out.println("Il faut recreer tous les bateaux!");
								System.out.println();
								System.out.println("Joueur " + ph.getName() + " commence! ");
								//creation de la flotte pour Player 1
								ph = new PlayerHuman(ph.getName());
								System.out.println("Grid " + ph.getName());
								ph.getBattlefield().showGrid();
								//creation de la flotte Player 2
								System.out.println();
								System.out.println("Et ....");
								System.out.println( "Aussi, le joueur AI ! ");
								pi = new PlayerAIBeginner(); 
								System.out.println("Grid AI : " );
								pi.getBattlefield().showGrid();
							}else {
								joueur = 2;
								System.out.println("Vous avez choisi de jouer un autre jeu!");
								System.out.println("Il faut recreer tous les bateaux!");
								System.out.println();
								System.out.println("Joueur AI commence! ");
								//creation de la flotte pour Player 1
								pi = new PlayerAIBeginner();
								System.out.println("Grid AI: ");
								pi.getBattlefield().showGrid();
								//creation de la flotte Player 2
								System.out.println();
								System.out.println("Et ....");
								System.out.println( "Aussi, le joueur " + ph.getName() + " ! ");
								ph = new PlayerHuman(ph.getName()); 
								System.out.println("Grid " + ph.getName());
								ph.getBattlefield().showGrid();
							}
						}
						else {recom = 2;}	
				}
			}else if(nivel.equals("MEDIUM")) {
				niveau = 5;
				System.out.println("Niveau medium!");
				int recomm = 1;
				int ym;
				String xm;
				Scanner nivBeg = new Scanner(System.in);
				System.out.println("On commence! Ton nom?");
				String nameHuman = nivBeg.nextLine();
				PlayerHuman ph = new PlayerHuman(nameHuman);
				PlayerAIMedium pi = new PlayerAIMedium();
				System.out.println("Grid human:");
				ph.getBattlefield().showGrid();
				System.out.println("Grid AI:");
				pi.getBattlefield().showGrid();
				
				int jucator = 1;
				while(recomm == 1) {
					System.out.println("Let's start!");
					while((ph.score() != ph.getFleet().size()) && (pi.score() != pi.getFleet().size())){
						switch(jucator) {
						case 1: //omul ataca
							boolean hit = false;
							boolean check;
							System.out.println("Player 1 : "+ ph.getName() + " , ou vous voulez tirer?");
							System.out.println("Donnez la coordonnees! svp!");
							System.out.println("");
							System.out.print("Coordonnee bateau (char) : ");
							xm = nivBeg.nextLine();
							System.out.print("Coordonnee bateau (int) : ");
							ym = Integer.parseInt(nivBeg.nextLine());
							Coordinates c14 = new Coordinates(xm.toUpperCase().charAt(0), ym);
							check = c14.isGood();
							while(check == false ) {
								System.out.println("SVP faire attention aux coordonnees introduites!");
								System.out.println("");
								System.out.print("Coordonnee bateau (char) : ");
								xm = nivBeg.nextLine();
								System.out.print("Coordonnee bateau (int) : ");
								ym = Integer.parseInt(nivBeg.nextLine());
								c14 = new Coordinates(xm.toUpperCase().charAt(0), ym);
								check = c14.isGood();
							}
							//System.out.println(c14.toString());
							pi.getBattlefield().setHitElement(xm.toUpperCase().charAt(0), ym);
							for(int i = 0; i<pi.getFleet().size() ; i++) {
								if(pi.getFleet().get(i).isHit(c14) == true) {
									hit = true;
								}
							}
							System.out.print("");
							if(hit == true) {
								while(hit == true && (pi.score() != pi.getFleet().size()) ) {//vreau sa ma opresc daca hit == false sau daca p1 a lovit tot ce se poate de la p2
									hit = false;
									System.out.println("Player 1 : "+ ph.getName() );
									System.out.println("Vous avez touche une partie de bateau de votre enimie. Alors vous avez la possibilite de tirer encore fois!");
									System.out.println("Quelle est la case desiree?");
									System.out.println("Donnez la coordonnees! svp!");
									System.out.println("");
									System.out.print("Coordonnee bateau (char) : ");
									xm = nivBeg.nextLine();
									System.out.print("Coordonnee bateau (int) : ");
									ym = Integer.parseInt(nivBeg.nextLine());
									c14 = new Coordinates(xm.toUpperCase().charAt(0), ym);
									check = c14.isGood();
									while(check == false ) {
										System.out.println("SVP faire attention aux coordonnees introduites!");
										System.out.println("");
										System.out.print("Coordonnee bateau (char) : ");
										xm = nivBeg.nextLine();
										System.out.print("Coordonnee bateau (int) : ");
										ym = Integer.parseInt(nivBeg.nextLine());
										c14 = new Coordinates(xm.toUpperCase().charAt(0), ym);
										check = c14.isGood();
									}
									//System.out.println(c14.toString());
									System.out.println("");
									pi.getBattlefield().setHitElement(xm.toUpperCase().charAt(0), ym);
									for(int i = 0; i<ph.getFleet().size() ; i++) {
										if(pi.getFleet().get(i).isHit(c14) == true) {hit = true;}
										jucator = 2;
									}
								}
								System.out.println("Grid AI:");
								pi.getBattlefield().showGrid();
							}else {jucator = 2;}
							
							break;
						
						case 2:// AI ataca
							boolean atacand = pi.attaque(ph);
							System.out.println("\nTour de AI :) \n ");
							while(atacand == true) {
								atacand = pi.attaque(ph);
							}
							System.out.println("Grid " + ph.getName()+" :");
							ph.getBattlefield().showGrid();
							jucator = 1;
							break;
						}
					}
						System.out.println("Grid " + ph.getName()+": ");
						ph.getBattlefield().showGrid();
						System.out.println("Grid AI: ");
						pi.getBattlefield().showGrid();
						System.out.println("Score human: " +pi.score() );
						System.out.println("Score AI: " +ph.score() );
						if(ph.score() < pi.score()) {
							System.out.println("GAME OVER!");
							System.out.println("The winner is: " + ph.getName() );
						}else if(ph.score() > pi.score()) {
							System.out.println("GAME OVER!");
							System.out.println("The winner is: player AI"  );
						}else {
							System.out.println("GAME OVER! EGALITATE!");
						}
						//i asked you if you want to play again:)
						System.out.println("Vous voulez jouer un autre jeu?");
						System.out.println("Si OUI introduiez 'oui', sinon 'non'");
						Scanner n = new Scanner(System.in);
						String nouveauJeu = n.nextLine();
						System.out.println();
						if(nouveauJeu.equals("oui")) {
							recomm = 1;
							if(ph.score() > pi.score()) {
								joueur = 1;
								System.out.println("Vous avez choisi de jouer un autre jeu!");
								System.out.println("Il faut recreer tous les navires!");
								System.out.println();
								System.out.println("Joueur " + ph.getName() + " commence! ");
								//creation de la flotte pour Player 1
								ph = new PlayerHuman(ph.getName());
								System.out.println("Grid " + ph.getName());
								ph.getBattlefield().showGrid();
								//creation de la flotte Player 2
								System.out.println();
								System.out.println("Et ....");
								System.out.println( "Aussi, le joueur AI ! ");
								pi = new PlayerAIMedium(); 
								System.out.println("Grid AI : " );
								pi.getBattlefield().showGrid();
							}else {
								joueur = 2;
								System.out.println("Vous avez choisi de jouer un autre jeu!");
								System.out.println("Il faut recreer tous les navires!");
								System.out.println();
								System.out.println("Joueur AI commence! ");
								//creation de la flotte pour Player 1
								pi = new PlayerAIMedium();
								System.out.println("Grid AI: ");
								pi.getBattlefield().showGrid();
								//creation de la flotte Player 2
								System.out.println();
								System.out.println("Et ....");
								System.out.println( "Aussi, le joueur " + ph.getName() + " ! ");
								ph = new PlayerHuman(ph.getName()); 
								System.out.println("Grid " + ph.getName());
								ph.getBattlefield().showGrid();
							}
						}
						else {recomm = 2;}
				}
			}else if(nivel.equals("HARD")) {
				niveau = 6;
				System.out.println("Niveau hard!");
				int rec = 1;
				int yh;
				String xh;
				Scanner nivBeg = new Scanner(System.in);
				System.out.println("On commence! Ton nom?");
				String nameHuman = nivBeg.nextLine();
				PlayerHuman ph = new PlayerHuman(nameHuman);
				PlayerAIHard pih = new PlayerAIHard();
				System.out.println("Grid human:");
				ph.getBattlefield().showGrid();
				System.out.println("Grid AI:");
				pih.getBattlefield().showGrid();
				
				int jucator = 1;
				while(rec == 1) {
					while((ph.score() != ph.getFleet().size()) && (pih.score() != pih.getFleet().size())){
						switch(jucator) {
						case 1: //omul ataca
							boolean hit = false;
							boolean check;
							System.out.println("Player 1 : "+ ph.getName() + " , ou vous voulez tirer?");
							System.out.println("Donnez la coordonnees! svp!");
							System.out.println("");
							System.out.print("Coordonnee bateau (char) : ");
							xh = nivBeg.nextLine();
							System.out.print("Coordonnee bateau (int) : ");
							yh = Integer.parseInt(nivBeg.nextLine());
							Coordinates c141 = new Coordinates(xh.toUpperCase().charAt(0), yh);
							check = c141.isGood();
							while(check == false ) {
								System.out.println("SVP faire attention aux coordonnees introduites!");
								System.out.println("");
								System.out.print("Coordonnee bateau (char) : ");
								xh = nivBeg.nextLine();
								System.out.print("Coordonnee bateau (int) : ");
								yh = Integer.parseInt(nivBeg.nextLine());
								c141 = new Coordinates(xh.toUpperCase().charAt(0), yh);
								check = c141.isGood();
							}
							//System.out.println(c14.toString());
							pih.getBattlefield().setHitElement(xh.toUpperCase().charAt(0), yh);
							for(int i = 0; i<pih.getFleet().size() ; i++) {
								if(pih.getFleet().get(i).isHit(c141) == true) {
									hit = true;
								}
							}
							System.out.print("");
							if(hit == true) {
								while(hit == true && (pih.score() != pih.getFleet().size()) ) {//vreau sa ma opresc daca hit == false sau daca p1 a lovit tot ce se poate de la p2
									hit = false;
									System.out.println("Player 1 : "+ ph.getName() );
									System.out.println("Vous avez touche une partie de bateau de votre enimie. Alors vous avez la possibilite de tirer encore fois!");
									System.out.println("Quelle est la case voulue?");
									System.out.println("Donnez la coordonnees! svp!");
									System.out.println("");
									System.out.print("Coordonnee bateau (char) : ");
									xh = nivBeg.nextLine();
									System.out.print("Coordonnee bateau (int) : ");
									yh = Integer.parseInt(nivBeg.nextLine());
									c141 = new Coordinates(xh.toUpperCase().charAt(0), yh);
									check = c141.isGood();
									while(check == false ) {
										System.out.println("SVP faire attention aux coordonnees introduites!");
										System.out.println("");
										System.out.print("Coordonnee bateau (char) : ");
										xh = nivBeg.nextLine();
										System.out.print("Coordonnee bateau (int) : ");
										yh = Integer.parseInt(nivBeg.nextLine());
										c141 = new Coordinates(xh.toUpperCase().charAt(0), yh);
										check = c141.isGood();
									}
									//System.out.println(c14.toString());
									System.out.println("");
									pih.getBattlefield().setHitElement(xh.toUpperCase().charAt(0), yh);
									for(int i = 0; i<ph.getFleet().size() ; i++) {
										if(pih.getFleet().get(i).isHit(c141) == true) {hit = true;}
										jucator = 2;
									}
								}
								System.out.println("Grid AI:");
								pih.getBattlefield().showGrid();
							}else {jucator = 2;}
							
							break;
						
						case 2:// AI ataca
							boolean atacand = pih.attaque(ph);
							System.out.println("\nTour de AI :) \n ");
							while(atacand == true) {
								atacand = pih.attaque(ph);
							}
							System.out.println("Grid " + ph.getName()+" :");
							ph.getBattlefield().showGrid();
							jucator = 1;
							break;
						}
					}
						System.out.println("Grid " + ph.getName()+": ");
						ph.getBattlefield().showGrid();
						System.out.println("Grid AI: ");
						pih.getBattlefield().showGrid();
						System.out.println("score human: " +pih.score() );
						System.out.println("score AI: " +ph.score() );
						if(ph.score() < pih.score()) {
							System.out.println("GAME OVER!");
							System.out.println("The winner is: " + ph.getName() );
						}else if(ph.score() > pih.score()) {
							System.out.println("GAME OVER!");
							System.out.println("The winner is: player AI"  );
						}else {
							System.out.println("GAME OVER! EGALITATE!");
						}
						
						//i asked you if you want to play again:)
						System.out.println("Vous voulez jouer un autre jeu?");
						System.out.println("Si OUI introduiez 'oui', sinon 'non'");
						Scanner n = new Scanner(System.in);
						String nouveauJeu = n.nextLine();
						System.out.println();
						if(nouveauJeu.equals("oui")) {
							rec = 1;
							if(ph.score() > pih.score()) {
								joueur = 1;
								System.out.println("Vous avez choisi de jouer un autre jeu!");
								System.out.println("Il faut recreer tous les navires!");
								System.out.println();
								System.out.println("Joueur " + ph.getName() + " commence! ");
								//creation de la flotte pour Player 1
								ph = new PlayerHuman(ph.getName());
								System.out.println("Grid " + ph.getName());
								ph.getBattlefield().showGrid();
								//creation de la flotte Player 2
								System.out.println();
								System.out.println("Et ....");
								System.out.println( "Aussi, le joueur AI ! ");
								pih = new PlayerAIHard(); 
								System.out.println("Grid AI : " );
								pih.getBattlefield().showGrid();
							}else {
								joueur = 2;
								System.out.println("Vous avez choisi de jouer un autre jeu!");
								System.out.println("Il faut recreer tous les navires!");
								System.out.println();
								System.out.println("Joueur AI commence! ");
								//creation de la flotte pour Player 1
								pih = new PlayerAIHard();
								System.out.println("Grid AI: ");
								pih.getBattlefield().showGrid();
								//creation de la flotte Player 2
								System.out.println();
								System.out.println("Et ....");
								System.out.println( "Aussi, le joueur " + ph.getName() + " ! ");
								ph = new PlayerHuman(ph.getName()); 
								System.out.println("Grid " + ph.getName());
								ph.getBattlefield().showGrid();
							}
						}
						else {rec = 2;}
				}
			}else {
				niveau = 0;
				System.out.println("Ce que vous desirez n'existe pas encore!");
			}
		}	
	}
}
