package fr.battleship;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestIA {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Premiere partie: BEGINNER VS MEDIUM");
		PlayerAIMedium pm1 = new PlayerAIMedium();
		PlayerAIBeginner pb = new PlayerAIBeginner();
		int scorM = 0;
		int scorB = 0;
		//int index = 0;
		for(int index = 0; index < 100; index++) {
			int jucator = 1;
			while((pm1.score() != pm1.getFleet().size()) && (pb.score() != pb.getFleet().size())){
				switch(jucator) {
				case 1:
					boolean atac = pm1.attaque(pb);
					while(atac == true) {
						atac = pm1.attaque(pb);
					}
					jucator = 2;
					break;
				case 2:
					boolean atacand = pb.attaque(pm1);
					while(atacand == true) {
						atacand = pb.attaque(pm1);
					}
					jucator = 1;
					break;
				}
			}
			
			if(pm1.score() > pb.score()) {
				scorB = scorB +1;
			}else if(pm1.score() < pb.score()) {
				scorM= scorM + 1;
			}
			pm1 = new PlayerAIMedium();
			pb = new PlayerAIBeginner();
		}
		
		System.out.println("AI Level Beginner: " + scorB + " ; Level Medium: " + scorM);
		System.out.println();
		
		System.out.println("Deuxieme partie: BEGINNER VS HARD ");
		PlayerAIHard ph1 = new PlayerAIHard();
		PlayerAIBeginner pb1 = new PlayerAIBeginner();
		int scorH1 = 0;
		int scorB1 = 0;
		//int index = 0;
		for(int index = 0; index < 100; index++) {
			int jucator1 = 1;
			while((ph1.score() != ph1.getFleet().size()) && (pb1.score() != pb1.getFleet().size())){
				switch(jucator1) {
				case 1:
					boolean atac = ph1.attaque(pb1);
					while(atac == true) {
						atac = ph1.attaque(pb1);
					}
					jucator1 = 2;
					break;
				case 2:
					boolean atacand = pb1.attaque(ph1);
					while(atacand == true) {
						atacand = pb1.attaque(ph1);
					}
					jucator1 = 1;
					break;
				}
			}
			
			if(ph1.score() > pb1.score()) {
				scorB1 = scorB1 +1;
			}else if(ph1.score() < pb1.score()) {
				scorH1= scorH1 + 1;
			}
			ph1 = new PlayerAIHard();
			pb1 = new PlayerAIBeginner();
		
		}
		System.out.println("AI Level Beginner: " + scorB1 + " ; Level Hard: " + scorH1);
		System.out.println();
		
		System.out.println("Troisieme partie: MEDIUM VS HARD ");
		PlayerAIHard ph2 = new PlayerAIHard();
		PlayerAIMedium pm2 = new PlayerAIMedium();
		int scorH2 = 0;
		int scorM2 = 0;
		for(int index = 0; index < 100; index++) {
			int jucator2 = 1;
			while((ph2.score() != ph2.getFleet().size()) && (pm2.score() != pm2.getFleet().size())){
				switch(jucator2) {
				case 1:
					boolean atac = ph2.attaque(pm2);
					while(atac == true) {
						atac = ph2.attaque(pm2);
					}
					jucator2 = 2;
					break;
				case 2:
					boolean atacand = pm2.attaque(ph2);
					while(atacand == true) {
						atacand = pm2.attaque(ph2);
					}
					jucator2 = 1;
					break;
				}
			}
			
			if(ph2.score() >= pm2.score()) {
				scorM2 = scorM2 +1;
			}else if(ph2.score() < pm2.score()) {
				scorH2= scorH2 + 1;
			}
			ph2 = new PlayerAIHard();
			pm2 = new PlayerAIMedium();
		
		}
		System.out.println("AI Level Medium: " + scorM2 + " ;Level Hard: " + scorH2);
		System.out.println();
		
		String theWay = "ai-proof.csv";
		File fisier = new File(theWay);
		fisier.createNewFile();
		FileWriter f = new FileWriter(fisier);

		f.write("AI NAME1;");
		f.write("SCORE;");
		f.write("AI NAME2;");
		f.write("SCORE;\n");
		
		f.write("AI Level Beginner:;");
		f.write(Integer.toString(scorB)+ ";");
		f.write("Level Medium:;");
		f.write(Integer.toString(scorM) + ";\n");
		
		f.write("AI Level Beginner:;");
		f.write(Integer.toString(scorB1)+ ";");
		f.write("Level Hard:;");
		f.write(Integer.toString(scorH1) + ";\n");
		
		f.write("AI Level Medium:;");
		f.write(Integer.toString(scorM2)+ ";");
		f.write("Level Hard:;");
		f.write(Integer.toString(scorH2) + ";\n");
		
		f.close();
		System.out.println("FIN!");
	}
}
