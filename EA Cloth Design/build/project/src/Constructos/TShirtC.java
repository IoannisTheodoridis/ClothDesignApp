package Constructos;

import java.util.Arrays;
import java.util.Random;

public class TShirtC {
		
	private int[] sleevehw;
	private int[] lowerparthw;
	private int[] pockets;
	private int[][] colors;
	private int lowerpartheight;
	private int poloneck;
	
	public TShirtC(int[] i, int j, int[] a, int[] b, int f, int[][] c) {
		
		this.sleevehw = i;
		this.lowerpartheight = j;
		this.lowerparthw = a;
		this.pockets = b;
		this.poloneck = f;
		this.colors = c;
		
	}
	
	//get and set for parameters

	public int[] getLowerparthw() {
		
		return lowerparthw;
		
	}

	public void setLowerparthw(int[] lowerparthw) {
		
		this.lowerparthw = lowerparthw;
		
	}

	public int[] getSleevehw() {
		
		return sleevehw;
		
	}

	public void setSleevehw(int[] sleevehw) {
		
		this.sleevehw = sleevehw;
		
	}

	public int[] getPockets() {
		
		return pockets;
		
	}

	public void setPockets(int[] pockets) {
		
		this.pockets = pockets;
		
	}

	public int getLowerpartheight() {
		
		return lowerpartheight;
		
	}

	public void setLowerpartheight(int lowerpartheight) {
		
		this.lowerpartheight = lowerpartheight;
		
	}
	
	public int getPoloneck() {
		
		return poloneck;
		
	}

	public void setPoloneck(int poloneck) {
		
		this.poloneck = poloneck;
		
	}
	
	public int[][] getColors() {
		
		return colors;
		
	}

	public void setColors(int[][] colors) {
		
		this.colors = colors;
		
	}	
	
	//random numbers
	
	// random number for sleeves width
	public int Randomsleevesw() {
				
		Random r = new Random();
		int lowy = 10;
		int highy = 15;
		int resulty = r.nextInt(highy-lowy) + lowy;
		
		return resulty;
		
	}
	
	// random number for sleeves height	
	public int Randomsleevesh() {
				
		Random r = new Random();
		int lowx = 15;
		int highx = 80;
		int resultx = r.nextInt(highx-lowx) + lowx;
		if(resultx <20) {
			resultx = 0;
		}
		
		return resultx;
		
	}
	
	//random number for body lower part
	public int Randomlowerpart() {					
			
		Random r = new Random();
		int highlp = 30;
		int lpheight = r.nextInt(highlp);
		
		return lpheight;
			
	}
	
	//random sleeves lower part height
	public int Randomlpsleevesheight() {					
		
		Random r = new Random();		
		int lowsl = 8;
		int highsl = 13;
		int slheight = r.nextInt(highsl - lowsl) + lowsl;
		
		return slheight;
			
	}
	
	//random sleeves lower part height
	public int Randomlpsleeveswidth() {					
			
		Random r = new Random();
		int lowslw = 10;
		int highslw = 20;
		int slwidth = r.nextInt(highslw-lowslw) + lowslw;
		
		return slwidth;
				
	}
	
	//random neck
	public int randomNeck(){
		
		Random r = new Random();
		int chances = r.nextInt(5);
		
		return chances;
	}
	
	//pockets existence
	public int Randompocketsex() {					
				
		Random r = new Random();
		int pocketsflag = r.nextInt(3);
		
		if(pocketsflag == 0) {
			
			return 0;
		
		}else {
		
			return 1;
		
		}
					
	}
	
	//random pockets height
	public int Randompocketsh() {					
				
		Random r = new Random();
		int lowphw = 20;
		int highphw = 30;
		int pheight = r.nextInt(highphw-lowphw) + lowphw;
			
		return pheight;
					
	}
	
	//random pockets width
	public int Randompocketsw() {					
		
		Random r = new Random();
		int lowphw = 20;
		int highphw = 30;
		int pwidth = r.nextInt(highphw-lowphw) + lowphw;
			
		return pwidth;
					
	}
	
	// random pockets style
	public int Randompockettype() {
		
		Random a = new Random();
		int pocketstype = a.nextInt(3);
		
		return pocketstype;
		
	}
	
	//random color for each chromosome
	
	//red//{ 255, 102, 102}, { 255, 51, 51}, { 255, 0, 0}, { 204, 0, 0}, { 153, 0, 0}, 
	//blue{ 51, 204, 255}, { 51, 153, 255}, { 0, 0, 255}, { 0, 0, 204}, { 0, 0, 153},
	//green{ 102, 255, 102}, { 0, 255, 51}, { 0, 204, 0}, { 0, 153, 0}, { 0, 102, 0},
	//yellow{ 255, 255, 204}, { 255, 255, 153}, { 255, 255, 0}, { 255, 204, 0},
	//orange{ 255, 153, 0}, { 255, 102, 0}, //gold{ 255, 204, 51}, 
	//grey{ 204, 204, 204}, { 153, 153, 153}, { 102, 102, 102}, { 51, 51, 51}, 
	//brown{ 153, 102, 0}, { 102, 51, 0}, { 51, 0, 0},
	//purple{ 102, 0, 153},
	//black{ 0, 0, 0},
	//white{ 255, 255, 255}
	
	public int[] RandomColor( String prefcolor) {

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
			
			colors = colorpal[r.nextInt(colorpal.length - 1)];
			
		}
		else if( prefcolor == "RED") {
			
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
	public int[][] RandomColorCombination(TShirtC sib, String prefcolor){
		
		int[][] rcc = new int[4][3];
		Random a = new Random();
		int chances = a.nextInt(3);
		
		//Shirt will have same color everywhere
		switch(chances) {
		
		case 1:
			
			int[] pattern = new int[4];
			
			for(int i = 0; i < 4; i++) {
				
				pattern[i] = a.nextInt(3);
				
			}
			
			int[] color1, color2, color3, color4 = new int[3];
			
			color1 = sib.RandomColor(prefcolor);
			color2 = sib.RandomColor(prefcolor);
			color3 = sib.RandomColor(prefcolor);
			color4 = sib.RandomColor(prefcolor);
			
			for(int i = 0; i < 4; i++) {
					
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
					case 3:
						
						rcc[i] = color4;
						
					break;	
					
					}
					
				}
	
		break;		
		default:
			
			Arrays.fill(rcc, sib.RandomColor(prefcolor));
			
		}
		
		return rcc;
		
	}
	
	//Evaluate color
	public static int evaluate(TShirtC a, String prefcolor) {
		
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
		
		int[][] arrayColor = a.getColors();
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
	public void atome(TShirtC atome, String text) {
		
		int[] array3 = atome.getSleevehw();
		int[] array1 = atome.getLowerparthw();
		int[] array2 = atome.getPockets();
		int[][] arrayColor = atome.getColors();
		System.out.println(text + ": "  + array3[0] + " . " + array3[1]  + " - " + atome.getLowerpartheight() + " - " + array1[0] + "." + array1[1] +  " - " + atome.getPoloneck() +  " - " + array2[0] + "." + array2[1] + "." + array2[2] + "." + array2[3] + " colors: " + arrayColor[0][0] + "." + arrayColor[0][1] + "." + arrayColor[0][2] + " / " + arrayColor[1][0] + "." + arrayColor[1][1] + "." + arrayColor[1][2] + " / "+ arrayColor[2][0] + "." + arrayColor[2][1] + "." + arrayColor[2][2] + " / "+ arrayColor[3][0] + "." + arrayColor[3][1] + "." + arrayColor[3][2]);
	
	}
	
	//statspane atome
	public String statspane(TShirtC atome) {
			
		int[] array3 = atome.getSleevehw();
		int[] array1 = atome.getLowerparthw();
		int[] array2 = atome.getPockets();
		int[][] arrayColor = atome.getColors();
		String string = "chromosome 1(sleves h/w): "  + array3[0] + " . " + array3[1]  + " chromosome 2(shirts length): " + atome.getLowerpartheight() + " chromosome 3(sleeves end): " + array1[0] + "." + array1[1] +  " chromosome 4(colar): " + atome.getPoloneck() +  " chromosome 5(pockets): " + array2[0] + "." + array2[1] + "." + array2[2] + "." + array2[3] + " chromosome 5(colors): " + arrayColor[0][0] + "." + arrayColor[0][1] + "." + arrayColor[0][2] + " / " + arrayColor[1][0] + "." + arrayColor[1][1] + "." + arrayColor[1][2] + " / "+ arrayColor[2][0] + "." + arrayColor[2][1] + "." + arrayColor[2][2] + " / "+ arrayColor[3][0] + "." + arrayColor[3][1] + "." + arrayColor[3][2];
		
		return string;
	}

}
