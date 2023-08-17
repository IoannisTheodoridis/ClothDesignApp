package Constructos;

import java.util.Arrays;
import java.util.Random;

public class TrousersC {
	
	private int[] pantshw;
	private int[] pocketsP;
	private int[] pantslp;
	private int[][] colorsP;
	private int crotch;
	
	public TrousersC(int[] a, int[] b, int[] e, int d, int[][] c) {
		
		this.pantshw = a;
		this.pocketsP = b;
		this.pantslp = e;
		this.crotch = d;
		this.colorsP = c;
		
	}
	
	//get and set for parameters
	public int[] getPantshw() {
		
		return pantshw;
	
	}

	public void setPantshw(int[] pantshw) {
	
		this.pantshw = pantshw;
	
	}
	
	public int[] getPantslp() {
		
		return pantslp;
		
	}

	public void setPantslp(int[] pantslp) {
		
		this.pantslp = pantslp;
		
	}

	public int getCrotch() {
	
		return crotch;
	
	}

	public void setCrotch(int crotch) {
	
		this.crotch = crotch;
	
	}

	public int[][] getColorsT() {
	
		return colorsP;
	
	}

	public void setColorsT(int[][] colorsP) {
	
		this.colorsP = colorsP;
	
	}

	public int[] getPocketsT() {
	
		return pocketsP;
	
	}

	public void setPocketsT(int[] pocketsP) {
	
		this.pocketsP = pocketsP;
	
	}
	
	//random methods for attributes
	// random number for pants height
		public int randomPatnsh() {
					
			Random r = new Random();
			int lowy = 40;
			int highy = 120;
			int resulty = r.nextInt(highy-lowy) + lowy;
			
			return resulty;
			
		}
		
		// random number for pants width
		public int randomPatnsw(){
					
			Random r = new Random();
			int lowx = 35;
			int highx = 45;
			int resultx = r.nextInt(highx-lowx) + lowx;
			
			return resultx;
			
		}
		
		//random pants lower part height
		public int randomLowerPantsHeightT() {
			
			Random r = new Random();
			int lowx = 5;
			int highx = 15;
			int result = r.nextInt(highx-lowx) + lowx;
			
			return result;
			
		}
		
		//random pants lower part type
		public int randomLowerPantsTypeT() {
		
			Random r = new Random();
			int result = r.nextInt(2);
			
			return result;			
		}
		
		//random number for crotch height
		public int randomCrotch() {
			
			Random r = new Random();
			int lowx = 30;
			int highx = 50;
			int result = r.nextInt(highx-lowx) + lowx;
			
			return result;
		}
		
		//random pockets existence
		public int randomPocketTEX() {
						
			Random r = new Random();
			int result = r.nextInt(4);
			
			if(result == 0) {
				
				return 1;
			
			}else {
			
				return 0;
			
			}
		}
		
		//random pocket type if pockets exist
		public int randomPocketTType() {
			
			Random r = new Random();
			int lowx = 1;
			int highx = 4;
			int result = r.nextInt(highx-lowx) + lowx;
			
			if(result == 3) {
				
				return 2;
			
			}else {
			
				return 1;
			
			}
		}
		
		//random back pocket type if pockets exist
				public int randomPocketTBackType() {
					
					Random r = new Random();
					int lowx = 0;
					int highx = 3;
					int result = r.nextInt(highx-lowx) + lowx;
					
					return result;
				}
		
		//random lower pockets height
		public int randomLowerPocketsTH() {
			
			Random r = new Random();
			int min = 25;
			int max = 30;
			int result = r.nextInt(max - min) + min;
				
			return result;
						
		}
		
		//random lower pockets width
		public int randomLowerPocketsTW() {					
			
			Random r = new Random();
			int min = 20;
			int max = 25;
			int result = r.nextInt(max - min) + min;
				
			return result;
						
		}
		
		//random upper part pockets style
		public int randomUpperPocketsStyleT() {
			
			Random r = new Random();
			int result = r.nextInt(4);
			
			return result;
			
		}
		
		//random color
		public int[] RandomColorT( String prefcolor) {
			
			int[][] colorpal = {
									{ 255, 102, 102}, { 255, 51, 51}, { 255, 0, 0}, { 204, 0, 0}, { 153, 0, 0}, 
									{ 51, 204, 255}, { 51, 153, 255}, { 0, 0, 255}, { 0, 0, 204}, { 0, 0, 153},
									{ 102, 255, 102}, { 0, 255, 51}, { 0, 204, 0}, { 0, 153, 0}, { 0, 102, 0},
									{ 255, 255, 204}, { 255, 255, 153}, { 255, 255, 0}, { 255, 204, 0},
									{ 255, 153, 0}, { 255, 102, 0}, { 255, 204, 51}, 
									{ 204, 204, 204}, { 153, 153, 153}, { 102, 102, 102}, { 51, 51, 51}, 
									{ 153, 102, 0}, { 102, 51, 0}, { 51, 0, 0},
									{ 102, 0, 153},
									{ 0, 0, 0},
									{ 255, 255, 255}
								};
			
			int[] colors = new int[3];
			Random r = new Random();
			
			if(prefcolor == "") {
				
				colors = colorpal[r.nextInt(31)];
				
			}else if( prefcolor == "RED") {
				
				colors = colorpal[r.nextInt(4)];
				
			}else if( prefcolor == "BLUE") {
				
				int max = 9;
				int min = 5;
				colors = colorpal[(int) ((Math.random() * ((max - min) + 1)) + min)];
				
			}else if( prefcolor == "GREEN") {
				
				int max = 14;
				int min = 10;
				colors = colorpal[(int) ((Math.random() * ((max - min) + 1)) + min)];
				
			}else if( prefcolor == "YELLOW") {
				
				int max = 18;
				int min = 15;
				colors = colorpal[(int) ((Math.random() * ((max - min) + 1)) + min)];
				
			}else if( prefcolor == "ORANGE") {
				
				int max = 21;
				int min = 19;
				colors = colorpal[(int) ((Math.random() * ((max - min) + 1)) + min)];
				
			}else if( prefcolor == "GREY") {
				
				int max = 25;
				int min = 22;
				colors = colorpal[(int) ((Math.random() * ((max - min) + 1)) + min)];
				
			}else if( prefcolor == "BROWN") {
				
				int max = 26;
				int min = 28;
				colors = colorpal[(int) ((Math.random() * ((max - min) + 1)) + min)];
				
			}else if( prefcolor == "PURPLE") {
				
				colors = colorpal[29];
				
			}else if( prefcolor == "BLACK") {
				
				colors = colorpal[30];
				
			}else if( prefcolor == "WHITE") {
				
				colors = colorpal[31];
				
			}
			
			return colors;
						
		}
		
		// random color combination
		public int[][] RandomColorCombinationT(TrousersC sib, String prefcolor){
			
			int[][] rcc = new int[3][3];
			Random a = new Random();
			int chances = a.nextInt(3);
			
			//Trouser will have same color everywhere
			switch(chances) {
			
			case 1:
				
				int[] pattern = new int[3];
				
				for(int i = 0; i < 3; i++) {
					
					pattern[i] = a.nextInt(3);
					
				}
				
				int[] color1, color2, color3 = new int[3];
				
				color1 = sib.RandomColorT(prefcolor);
				color2 = sib.RandomColorT(prefcolor);
				color3 = sib.RandomColorT(prefcolor);
				
				for(int i = 0; i < 3; i++) {
						
						switch(pattern[i]) {
						
						case 0:
							
							rcc[i] = color1;
							
						break;
						case 1:
							
							rcc[i] = color2;
							
						break;
						case 2:
							
							rcc[i] = color3;
							
						break;						
						}
						
					}
		
			break;		
			default:
				
				Arrays.fill(rcc, sib.RandomColorT(prefcolor));
				
			}
			
			return rcc;
			
		}
		
		//Evaluate color
		public static int evaluate(TrousersC a, String prefcolor) {
			
			int rating = 0;
			int check = 0;
			int[][] colorpal = {
					{ 255, 102, 102}, { 255, 51, 51}, { 255, 0, 0}, { 204, 0, 0}, { 153, 0, 0}, 
					{ 51, 204, 255}, { 51, 153, 255}, { 0, 0, 255}, { 0, 0, 204}, { 0, 0, 153},
					{ 102, 255, 102}, { 0, 255, 51}, { 0, 204, 0}, { 0, 153, 0}, { 0, 102, 0},
					{ 255, 255, 204}, { 255, 255, 153}, { 255, 255, 0}, { 255, 204, 0},
					{ 255, 153, 0}, { 255, 102, 0}, { 255, 204, 51}, 
					{ 204, 204, 204}, { 153, 153, 153}, { 102, 102, 102}, { 51, 51, 51}, 
					{ 153, 102, 0}, { 102, 51, 0}, { 51, 0, 0},
					{ 102, 0, 153},
					{ 0, 0, 0},
					{ 255, 255, 255}
				};
			
			int[][] arrayColor = a.getColorsT();
			//System.out.println(" chromosome 5(colors): " + arrayColor[0][0] + "." + arrayColor[0][1] + "." + arrayColor[0][2] + " / " + arrayColor[1][0] + "." + arrayColor[1][1] + "." + arrayColor[1][2] + " / "+ arrayColor[2][0] + "." + arrayColor[2][1] + "." + arrayColor[2][2] + " / "+ arrayColor[3][0] + "." + arrayColor[3][1] + "." + arrayColor[3][2]);
			int[][]acolors = arrayColor;

			if( prefcolor == "RED") {
				
				for(int i = 0; i < acolors.length; i++) {
					
					for(int x = 0; x < 5; x++) {
					
						for(int j = 0; j < acolors[0].length; j++) {
						
							if(acolors[i][j] == colorpal[x][j]){
						
									check ++;
							}
						
						}
						
						if (check == 3) {
							
							rating ++;
							
						}
						
					check = 0;
					
					}
				}
			}else if( prefcolor == "BLUE") {
					
				for(int i = 0; i < acolors.length; i++) {
					
					for(int x = 5; x < 10; x++) {
					
						for(int j = 0; j < acolors[0].length; j++) {
						
							if(acolors[i][j] == colorpal[x][j]){
						
									check ++;
							}
						
						}
						
						if (check == 3) {
							
							rating ++;
							
						}
						
					check = 0;
					
					}
				}
			}else if( prefcolor == "GREEN") {
				
				for(int i = 0; i < acolors.length; i++) {
					
					for(int x = 10; x < 15; x++) {
					
						for(int j = 0; j < acolors[0].length; j++) {
						
							if(acolors[i][j] == colorpal[x][j]){
						
									check ++;
							}
						
						}
						
						if (check == 3) {
							
							rating ++;
							
						}
						
					check = 0;
					
					}
				}
			}else if( prefcolor == "YELLOW") {
				
				for(int i = 0; i < acolors.length; i++) {
					
					for(int x = 15; x < 19; x++) {
					
						for(int j = 0; j < acolors[0].length; j++) {
						
							if(acolors[i][j] == colorpal[x][j]){
						
									check ++;
							}
						
						}
						
						if (check == 3) {
							
							rating ++;
							
						}
						
					check = 0;
					
					}
				}
			}else if( prefcolor == "ORANGE") {
				
				for(int i = 0; i < acolors.length; i++) {
					
					for(int x = 19; x < 23; x++) {
					
						for(int j = 0; j < acolors[0].length; j++) {
						
							if(acolors[i][j] == colorpal[x][j]){
						
									check ++;
							}
						
						}
						
						if (check == 3) {
							
							rating ++;
							
						}
						
					check = 0;
					
					}
				}
			}else if( prefcolor == "GREY") {
			
				for(int i = 0; i < acolors.length; i++) {
					
					for(int x = 23; x < 27; x++) {
					
						for(int j = 0; j < acolors[0].length; j++) {
						
							if(acolors[i][j] == colorpal[x][j]){
						
									check ++;
							}
						
						}
						
						if (check == 3) {
							
							rating ++;
							
						}
						
					check = 0;
					
					}
				}
			}else if( prefcolor == "BROWN") {
			
				for(int i = 0; i < acolors.length; i++) {
					
					for(int x = 27; x < 29; x++) {
					
						for(int j = 0; j < acolors[0].length; j++) {
						
							if(acolors[i][j] == colorpal[x][j]){
						
									check ++;
							}
						
						}
						
						if (check == 3) {
							
							rating ++;
							
						}
						
					check = 0;
					
					}
				}
			}else if( prefcolor == "PURPLE") {
			
				for(int i = 0; i < acolors.length; i++) {
					
					for(int j = 0; j < acolors[0].length; j++) {
						
						if(acolors[i][j] == colorpal[29][0]){

							check ++;
							
						}
					}
					
					if (check == 3) {
					
						rating ++;
					
					}
				
					check = 0;
					
				}
			}else if( prefcolor == "BLACK") {
			
				for(int i = 0; i < acolors.length; i++) {
					
					for(int j = 0; j < acolors[0].length; j++) {

						if(acolors[i][j] == colorpal[30][0]){

							check ++;
							
						}
					}
					
					if (check == 3) {
					
						rating ++;
					
					}
				
				check = 0;
				
			}
			}else if( prefcolor == "WHITE") {
			
				for(int i = 0; i < acolors.length; i++) {
					
					for(int j = 0; j < acolors[0].length; j++) {

						if(acolors[i][j] == colorpal[31][0]){

							check ++;
						}
					}
					
					if (check == 3) {
					
						rating ++;
						
					}
				
				check = 0;
				
				}
			}

			return rating;	
			
		}
		
		//print atom 
		public void atome(TrousersC atome, String text) {
			
			int[] array = atome.getPantshw();
			int[] array1 = atome.getPocketsT();
			int[] array2 = atome.getPantslp();
			int[][] arrayColor = atome.getColorsT();
			System.out.println(text + ": "  + array[0] + " . " + array[1]  + " - " + array1[0] + "." + array1[1] + "." + array1[2] + "." + array1[3] + "." +  array1[4] + " - " + array2[0] + "." + array2[1] + " - "  + atome.getCrotch() + " - " + " colors: " + arrayColor[0][0] + "." + arrayColor[0][1] + "." + arrayColor[0][2] +  " / " + arrayColor[1][0] + "." + arrayColor[1][1] + "." + arrayColor[1][2] + " / "+ arrayColor[2][0] + "." + arrayColor[2][1] + "." + arrayColor[2][2]);
		
		}
		
		//statspane atome
		public String statspane(TrousersC atome) {
				
			int[] array3 = atome.getPantshw();
			int[] array1 = atome.getPantslp();
			int[] array2 = atome.getPocketsT();
			int[][] arrayColor = atome.getColorsT();
			String string = "chromosome 1(pants h/w): "  + array3[0] + " . " + array3[1]  + " chromosome 2(crotch): " + atome.getCrotch() + " chromosome 3(pants length): " + array1[0] + "." + array1[1] + " chromosome 4(pockets): " + array2[0] + "." + array2[1] + "." + array2[2] + "." + array2[3] + array2[4]  + " chromosome 5(colors): " + arrayColor[0][0] + "." + arrayColor[0][1] + "." + arrayColor[0][2] + " / " + arrayColor[1][0] + "." + arrayColor[1][1] + "." + arrayColor[1][2] + " / "+ arrayColor[2][0] + "." + arrayColor[2][1] + "." + arrayColor[2][2];
			
			return string;
		}
}
