package EA;
import Constructos.TShirtC;
import Constructos.TrousersC;

import java.util.ArrayList;


public class Crossover {
	
	//create new generation siblings 
	Mutation mt = new Mutation();
	private int temp;
	private int[] temp1, temp2;
	private int[][] temp3;
	private ArrayList<int[]> comb1 = new ArrayList<int[]>();
	private double chances;
	
public TrousersC[] CrossoverTrousers(TrousersC pb, TrousersC pa) {
		
		comb1.clear();
		TrousersC[] newgen = new TrousersC[200];
		temp1 = null;
		temp = 0;
		pb.atome(pb, "parent 1");
		pa.atome(pa, "parent 0");
		
		//fill a 2d array with different combinations	
		for(int i = 0; i < 200; i++) {
			
			int[] comb = new int[5];
			
			for(int j = 0; j < comb.length; j++) {
		
				chances = Math.random();
		
					if(chances <= 0.5) {
			
						chances = 0;
						comb[j] = (int) chances;
						
			
					}else {
				
						chances = 1;
						comb[j] = (int) chances;
					
					}
				}
				
				comb1.add(comb);
				
			}
		
		//Print the comb1 array list
		
		//for (int i[] : comb1) {
		
          // System.out.println(Arrays.toString(i));
		
		//}
		
		//create the new generation with the random numbers we received above 
				
				for(int i = 0; i < 200; i++) {
					
					TrousersC nw = new TrousersC(null, null, null, 0, null);
					temp2 = comb1.get(i);
					
					if(temp2[0] == 0 ) {
						
						temp1 = pa.getPantshw();
						nw.setPantshw(temp1);
							
					}else if(temp2[0] == 1 ) {
						
						temp1 = pb.getPantshw();
						nw.setPantshw(temp1);
						
					}
					
					if(temp2[1] == 0 ) {
						
						temp = pa.getCrotch();
						nw.setCrotch(temp);
							
					}else if(temp2[1] == 1 ) {
						
						temp = pb.getCrotch();
						nw.setCrotch(temp);
						
					}
					
					if(temp2[2] == 0 ) {
						
						temp1 = pa.getPantslp();
						nw.setPantslp(temp1);
							
					}else if(temp2[2] == 1 ) {
						
						temp1 = pb.getPantslp();
						nw.setPantslp(temp1);
						
					}
					
					if(temp2[3] == 0 ) {
						
						temp1 = pa.getPocketsT();
						nw.setPocketsT(temp1);
							
					}else if(temp2[3] == 1 ) {
						
						temp1 = pb.getPocketsT();
						nw.setPocketsT(temp1);
						
					}
					
					if(temp2[4] == 0 ) {
						
						temp3 = pa.getColorsT();
						nw.setColorsT(temp3);
							
					}else if(temp2[4] == 1 ) {
						
						temp3 = pb.getColorsT();
						nw.setColorsT(temp3);
						
					}
				
					newgen[i] = nw;
				}
				
				//send the new generation for mutation
				
				try {
					
					for(int i = 0; i < newgen.length; i++) {
						
						newgen[i].atome(newgen[i], "pre mutated newgen " + i + " " );
						TrousersC w = new TrousersC(null, null, null, 0, null);
						w = mt.MutationTrousers(newgen[i]);
						newgen[i] = w;
						newgen[i].atome(newgen[i], "mutated newgen " + i + " " );
						System.out.println("--------------------");
						
					}
					
				}catch(Exception e) {
					
					System.out.println("CrossoverGen" + e);
					
				}
		return newgen;
		
	}
	
	public TShirtC[] CrossoverTshirts(TShirtC pb, TShirtC pa) {
		
		comb1.clear();
		TShirtC[] newgen = new TShirtC[200];
		temp1 = null;
		temp = 0;
		pb.atome(pb, "parent 1");
		pa.atome(pa, "parent 0");
		
		//fill a 2d array with different combinations	
		for(int i = 0; i < 200; i++) {
			
			int[] comb = new int[6];
			
			for(int j = 0; j < 6; j++) {
		
				chances = Math.random();
		
					if(chances <= 0.5) {
			
						chances = 0;
						comb[j] = (int) chances;
						
			
					}else {
				
						chances = 1;
						comb[j] = (int) chances;
					
					}
				}
				
				comb1.add(comb);
				
			}
		
		//Print the comb1 array list
		
		//for (int i[] : comb1) {
		
          // System.out.println(Arrays.toString(i));
		
		//}
		
		//create the new generation with the random numbers we received above 
				
				for(int i = 0; i < 200; i++) {
					
					TShirtC nw = new TShirtC(null, 0, null, null, 0, null);
					temp2 = comb1.get(i);
					
					if(temp2[0] == 0 ) {
						
						temp1 = pa.getSleevehw();
						nw.setSleevehw(temp1);
							
					}else if(temp2[0] == 1 ) {
						
						temp1 = pb.getSleevehw();
						nw.setSleevehw(temp1);
						
					}
					
					if(temp2[1] == 0 ) {
						
						temp = pa.getLowerpartheight();
						nw.setLowerpartheight(temp);
							
					}else if(temp2[1] == 1 ) {
						
						temp = pb.getLowerpartheight();
						nw.setLowerpartheight(temp);
						
					}
					
					if(temp2[2] == 0 ) {
						
						temp1 = pa.getLowerparthw();
						nw.setLowerparthw(temp1);
							
					}else if(temp2[2] == 1 ) {
						
						temp1 = pb.getLowerparthw();
						nw.setLowerparthw(temp1);
						
					}
					
					if(temp2[3] == 0 ) {
						
						temp1 = pa.getPockets();
						nw.setPockets(temp1);
							
					}else if(temp2[3] == 1 ) {
						
						temp1 = pb.getPockets();
						nw.setPockets(temp1);
						
					}
					
					if(temp2[4] == 0 ) {
						
						temp = pa.getPoloneck();
						nw.setPoloneck(temp);
							
					}else if(temp2[4] == 1 ) {
						
						temp = pb.getPoloneck();
						nw.setPoloneck(temp);
						
					}
					
					if(temp2[5] == 0 ) {
						
						temp3 = pa.getColors();
						nw.setColors(temp3);;
							
					}else if(temp2[5] == 1 ) {
						
						temp3 = pb.getColors();
						nw.setColors(temp3);
						
					}
				
					newgen[i] = nw;
				}
				
				//send the new generation for mutation
				
				try {
					
					for(int i = 0; i < newgen.length; i++) {
						
						newgen[i].atome(newgen[i], "pre mutated newgen " + i + " " );
						TShirtC w = new TShirtC(null, 0, null, null, 0, null);
						w = mt.MutationTshirt(newgen[i]);
						newgen[i] = w;
						newgen[i].atome(newgen[i], "mutated newgen " + i + " " );
						System.out.println("--------------------");
						
					}
					
				}catch(Exception e) {
					
					System.out.println("CrossoverGen" + e);
					
				}
		return newgen;
		
	}

}
