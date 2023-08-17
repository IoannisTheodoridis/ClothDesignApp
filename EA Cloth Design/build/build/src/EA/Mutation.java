package EA;

import Constructos.TShirtC;
import Constructos.TrousersC;

public class Mutation {
	
	private static double mutationrate = 0.2;
	private double chances;
	private int max, min, chances1, temp;
	TShirtC tsh = new TShirtC(null, 0, null, null, 0, null);
	
	//mutation with rat of 0.5 or 50%
	
	//trousers mutation
	public TrousersC MutationTrousers(TrousersC mutant) {
		
		chances = Math.random();
		
		if(mutationrate >= chances) {
			
			//mutation will happen randomly between the 5 chromosomes and will change the entire values under restrictions
			max = 5;
			min = 1;
			chances1 = (int) ((Math.random() * ((max - min) + 1)) + min);
			System.out.println("Mutation happend in crhomosome: "+ chances1);
			
			if(chances1 == 1) {

				int[] b = new int[2];	
				b[0] = mutant.randomPatnsh();
				b[1] = mutant.randomPatnsw();
				mutant.setPantshw(b);						
				
			}else if(chances1 == 2) {
				
				temp = mutant.randomCrotch();
				mutant.setCrotch(temp);					
				
			}else if(chances1 == 3) {
				
				int[] b = new int[2];	
				b[0] = mutant.randomLowerPantsTypeT();
				b[1] = mutant.randomLowerPantsHeightT();
				mutant.setPantslp(b);
					
				}												
			}else if(chances1 == 4) {
				
				temp = mutant.randomPocketTEX();
				System.out.println("pockers ex mut: " + temp);
				
				//pockets can only take other random values if they exist, otherwise they will be 1.0.0.0
				if(temp == 0) {
				
					int[] b = new int[5];
					b[0] = temp;
					b[1] = mutant.randomPocketTType();
					b[2] = mutant.randomPocketTBackType();
					b[3] = mutant.randomLowerPocketsTH();
					b[4] = mutant.randomLowerPocketsTW();
					mutant.setPocketsT(b);
			
				}else {
					
					int[] b = {1, 0, 0, 0, 0};
					mutant.setPocketsT(b);
										
				}	
				
			}else if(chances1 == 5) {
				
				int[][] b = new int[3][3];
				b = mutant.RandomColorCombinationT( mutant, "");
				mutant.setColorsT(b);
				
			}
		return mutant;
		
	}
	
	//Shirts mutation
	public TShirtC MutationTshirt(TShirtC mutant) {
				
		chances = Math.random();
		
		if(mutationrate >= chances) {
			
			//mutation will happen randomly between the 6 chromosomes and will change the entire values under restrictions
			max = 6;
			min = 1;
			chances1 = (int) ((Math.random() * ((max - min) + 1)) + min);
			System.out.println("Mutation happend in crhomosome: "+ chances1);
			
			if(chances1 == 1) {

				int[] b = new int[2];	
				b[0] = mutant.Randomsleevesh();
				b[1] = mutant.Randomsleevesw();
				mutant.setSleevehw(b);						
				
			}else if(chances1 == 2) {
				
				temp = mutant.Randomlowerpart();
				mutant.setLowerpartheight(temp);					
				
			}else if(chances1 == 3) {
				
				int[] slhw = mutant.getSleevehw();
				
				//lower part of sleeves can only exist if sleeves height is at least 60px
				if(slhw[0] >= 60) {
						
					int[] b = new int[2];	
					b[0] = mutant.Randomlpsleevesheight();
					b[1] = mutant.Randomlpsleeveswidth();
						
					if(b[1]==0){
							
						b[1] = 10;
							
					}else if(b[0] == 0) {
							
						b[0] = 8;
							
					}
						
					mutant.setLowerparthw(b);
					
				}												
			}else if(chances1 == 4) {
				
				//since it's going to mutate the neck type we just change the number between 0 and 1
				do {
					
					temp = mutant.randomNeck();
					
				}while (temp == mutant.getPoloneck());			
				
				mutant.setPoloneck(temp);
				
			}else if(chances1 == 5) {
									
				temp = mutant.Randompocketsex();
				System.out.println("pockers ex mut: " + temp);
				
				//pockets can only take other random values if they exist, otherwise they will be 1.0.0.0
				if(temp == 0) {
				
					int[] b = new int[4];
					b[0] = temp;
					b[1] = mutant.Randompockettype();
					b[2] = mutant.Randompocketsh();
					b[3] = mutant.Randompocketsw();
					mutant.setPockets(b);
			
				}else {
					
					int[] b = {1, 0, 0, 0};
					mutant.setPockets(b);
										
				}			
			}else if(chances1 == 6) {
				
				int[][] b = new int[4][3];
				b = tsh.RandomColorCombination( mutant, "");
				mutant.setColors(b);
				
			}			
		}
		
		return mutant;
		
	}
}
