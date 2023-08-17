package application;

import javafx.scene.paint.Color;
import java.util.Arrays;
import java.util.Random;
import Constructos.TrousersC;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;


public class Trouser {
		
	private int pheight, pwidth, crotch, lptype, lpheight, pocketsflag, pocketstype, bpocketstype, lppheight, lppwidth;
	private double prefchances = 0.5;
	private int[] white = { 255, 255, 255};
	private int[] vlyellow = { 255, 255, 204};
	private int[] lyellow = { 255, 255, 153};
	private int[] yellow = { 255, 255, 0};
	private int[] vlgreen = { 102, 255, 102};
	private int[] lgreen = { 0, 255, 51};
		
	public void createTrouser(Pane cpane, TrousersC a, boolean flag, String prefcolor, String prefpantstype, String preflowerpanttype, String prefcrotch, String prefpockets ) {		
			
		int arrayColor[][] = new int[3][3];
		Random r = new Random();
		double chances = r.nextInt();
		
		if(flag == false) {
			
			//random number for pants height and width
			if(prefpantstype == "ANY" || prefchances > chances ) {
				
				pheight = a.randomPatnsh();
				pwidth = a.randomPatnsw();
				
			}else if(prefpantstype == "SHORT") {
				
				do {
					
					pheight = a.randomPatnsh();
					pwidth = a.randomPatnsw();
					
				}while(pheight > 60); 
				
			}else if(prefpantstype == "LONG") {
				
				do {
					
					pheight = a.randomPatnsh();
					pwidth = a.randomPatnsw();
					
				}while(pheight <= 60); 
					
			}
			
			//random number for pants crotch
			if(prefcrotch == "ANY" || prefchances > chances) {
				
				crotch = a.randomCrotch();
				
			}else if(prefpantstype == "HIGH") {
					
				crotch = 30;
				
			}else if(prefpantstype == "MIDDLE") {
				
				do {
					
					crotch = a.randomCrotch();
					
				}while(pheight < 30 || pheight > 39); 
					
			}else if(prefpantstype == "LOW") {
				
				do {
					
					crotch = a.randomCrotch();
					
				}while(pheight >= 39); 
				
			}
			
			//random lower parnt pants height and type
			if(preflowerpanttype == "ANY" || prefchances > chances) {
				
				lptype = a.randomLowerPantsTypeT();
					
			}else if(preflowerpanttype == "REGULAR") {
				
				lptype = 0;
				
			}else if(preflowerpanttype == "WIDE") {
				
				lptype = 1;
				
			}
			
			lpheight = a.randomLowerPantsHeightT();
							
			if(prefpockets == "ANY" || prefchances > chances) {
					
				//random pockets
				pocketsflag = a.randomPocketTEX();
					
					if(pocketsflag == 0) {
						
						//random lower pockets type
						pocketstype = a.randomPocketTType();
				
						//random lower pockets height
						lppheight = a.randomLowerPocketsTH();
						
						//random backpocket type
						bpocketstype = a.randomPocketTBackType();
				
						//random lower pockets height
						lppwidth = a.randomLowerPocketsTW();
						
					} else {
						
						//because there are no pockets its value equals 0
						pocketstype = 0;
						lppheight =  0;
						lppwidth =  0;
						
					}	
				}else if (prefpockets == "YES") {
					
					pocketsflag = 0;
					
					//random pocket type
					pocketstype = a.randomPocketTType();
					
					//random backpocket type
					bpocketstype = a.randomPocketTBackType();
			
					//random lower pockets height
					lppheight = a.randomLowerPocketsTH();
			
					//random lower pockets height
					lppwidth = a.randomLowerPocketsTW();
					
					
				}else if (prefpockets == "NO") {
					
					// no sleeves
					pocketsflag = 1;
					pocketstype = 0;
					bpocketstype = 0;
					lppheight = 0;
					lppwidth = 0;
				
				}
				
				//set values 
				int[] array = {pheight, pwidth};			
				int[] array1 = {lptype, lpheight};
				int[] array2 = {pocketsflag , pocketstype, bpocketstype, lppheight, lppwidth};
				
				if( prefchances > chances ) {
					
					arrayColor = a.RandomColorCombinationT( a, "");
					
				}else {
				
					arrayColor = a.RandomColorCombinationT( a, prefcolor);
					
				}
				
				a.setPantshw(array);
				a.setCrotch(crotch);
				a.setPocketsT(array2);
				a.setPantslp(array1);;
				a.setColorsT(arrayColor);
			
			}else {
				
				//get pants height and width
				int[] array = a.getPantshw();
				pheight = array[0];
				pwidth = array[1];	
				
				//crotch
				crotch = a.getCrotch();
				
				// lower pants height and type
				int[] array1 = a.getPantslp();
				lptype = array1[0];
				lpheight = array1[1];

				//get pockets existence type height and width
				int[] array2 = a.getPocketsT();
				pocketsflag = array2[0];
				pocketstype = array2[1];
				bpocketstype = array2[2];
				lppheight = array2[3];
				lppwidth = array2[4];
				
				//get colors
				arrayColor = a.getColorsT();
			}
			
		//check for lighter colors and change the background if needed
			for(int i = 0; i < 3; i ++) {			
				if(Arrays.equals(arrayColor[i], white) || Arrays.equals(arrayColor[i], lyellow) || Arrays.equals(arrayColor[i], vlyellow) || Arrays.equals(arrayColor[i], yellow) || Arrays.equals(arrayColor[i], vlgreen) || Arrays.equals(arrayColor[i], lgreen)) {
					
					cpane.setStyle("-fx-background-color: #000000");
					
				}
			}
			 
			try {
				
				QuadCurve neck = new QuadCurve(160 - (pwidth/4), 100 + (crotch /2) ,165, 100 + (crotch + (crotch/2)), 170 + (pwidth / 4), 100 + (crotch /2));
				neck.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				neck.setFill(Color.TRANSPARENT);
				cpane.getChildren().add(neck);
				
				//create the pants crotch or "upper part" 
				Line line  = new Line(160 - pwidth, 100, 170 + pwidth, 100);
				Line crline1  = new Line(170 + pwidth, 100, 170 + pwidth, 100 + crotch);
				Line crline2  = new Line(160 - pwidth , 100, 160 - pwidth, 100 + crotch);
				line.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				crline1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				crline2.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(line);
				cpane.getChildren().add(crline1);
				cpane.getChildren().add(crline2);
				
				for(int i = 0; i < crotch; i ++) {
					
					Line fillcroch = new Line(160 - pwidth , 100 + i, 170 + pwidth, 100 + i);
					fillcroch.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
					cpane.getChildren().add(fillcroch);
				}
				
				//create left pant
				Line pline = new Line (160 - pwidth, 100 + crotch, 160 - pwidth, 100 + pheight + crotch);
				Line pline1 = new Line (160 , 100 + crotch, 160, 100 + pheight + crotch);
				//Line pline2 = new Line (160, 100 + pheight + crotch, 160 - pwidth, 100 + pheight + crotch);
				pline.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				pline1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				//pline2.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(pline);
				cpane.getChildren().add(pline1);
				//cpane.getChildren().add(pline2);
				
				for(int i = 0; i < pheight; i++) {
					
					Line fillpants = new Line (160 - pwidth , 100 + crotch + i, 160 , 100 + crotch + i);
					fillpants.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
					cpane.getChildren().add(fillpants);
					
				}
				
				//create right pant
				
				Line pline3 = new Line (170 + pwidth, 100 + crotch, 170 + pwidth, 100 + pheight + crotch);
				Line pline4 = new Line (170, 100 + crotch, 170, 100 + pheight + crotch);
				//Line pline5 = new Line (170 + pwidth, 100 + pheight + crotch, 170, 100 + pheight + crotch);
				pline3.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				pline4.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				//pline5.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(pline3);
				cpane.getChildren().add(pline4);
				//cpane.getChildren().add(pline5);
				
				for(int i = 0; i < pheight; i++) {
					
					Line fillpants1 = new Line (170 + pwidth, 100 + crotch + i, 170, 100 + crotch + i);
					fillpants1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
					cpane.getChildren().add(fillpants1);
					
				}
				
				//create pants lower part
				if(lptype == 0) {
					
					//regular left
					Line lpline = new Line (160 - pwidth, 100 + pheight + crotch, 160 - pwidth, 100 + pheight + crotch + lpheight);
					Line lpline1 = new Line (160 , 100 + pheight + crotch,  160, 100 + pheight + crotch + lpheight);
					Line lpline2 = new Line (160 - pwidth, 100 + pheight + crotch + lpheight, 160, 100 + pheight + crotch + lpheight);
					lpline.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					lpline1.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					lpline2.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					cpane.getChildren().add(lpline);
					cpane.getChildren().add(lpline1);
					cpane.getChildren().add(lpline2);
					
					for(int i = 0; i < lpheight; i ++) {
						
						Line filllpl = new Line (160 - pwidth, 100 + pheight + crotch + i, 160, 100 + pheight + crotch + i);
						filllpl.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
						cpane.getChildren().add(filllpl);
						
					}
					
					//regular right
					Line lpline3 = new Line (170 , 100 + pheight + crotch, 170, 100 + pheight + crotch + lpheight);
					Line lpline4 = new Line (170 + pwidth, 100 + pheight + crotch, 170 + pwidth, 100 + pheight + crotch + lpheight);
					Line lpline5 = new Line (170, 100 + pheight + crotch + lpheight, 170 + pwidth, 100 + pheight + crotch + lpheight);
					lpline3.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					lpline4.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					lpline5.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					cpane.getChildren().add(lpline3);
					cpane.getChildren().add(lpline4);
					cpane.getChildren().add(lpline5);
					
					for(int i = 0; i < lpheight; i ++) {
						
						Line filllpr = new Line (170 + pwidth, 100 + pheight + crotch + i, 170, 100 + pheight + crotch + i);
						filllpr.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
						cpane.getChildren().add(filllpr);
						
					}
					
				}else if (lptype == 1) {
					
					//wide left
					Line lpline = new Line (160 - pwidth, 100 + pheight + crotch, 160 - pwidth - 1, 100 + pheight + crotch + lpheight);
					Line lpline1 = new Line (160 , 100 + pheight + crotch,  160 + 1, 100 + pheight + crotch + lpheight);
					//Line lpline2 = new Line (160 - pwidth - 3, 100 + pheight + crotch + lpheight, 160 + 3, 100 + pheight + crotch + lpheight);
					lpline.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					lpline1.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					//lpline2.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					cpane.getChildren().add(lpline);
					cpane.getChildren().add(lpline1);
					//cpane.getChildren().add(lpline2);
					
					for(int i = 0; i < lpheight; i ++) {
						
						Line filllpl = new Line (160 - pwidth, 100 + pheight + crotch + i, 160, 100 + pheight + crotch + i);
						filllpl.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
						cpane.getChildren().add(filllpl);
						
					}
										
					//wide right
					Line lpline3 = new Line (170 , 100 + pheight + crotch, 170 - 1, 100 + pheight + crotch + lpheight);
					Line lpline4 = new Line (170 + pwidth, 100 + pheight + crotch, 170 + pwidth + 1, 100 + pheight + crotch + lpheight);
					//Line lpline5 = new Line (170 - 3, 100 + pheight + crotch + lpheight, 170 + pwidth + 3, 100 + pheight + crotch + lpheight);
					lpline3.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					lpline4.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					//lpline5.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					cpane.getChildren().add(lpline3);
					cpane.getChildren().add(lpline4);
					//cpane.getChildren().add(lpline5);
					
					for(int i = 0; i < lpheight; i ++) {
						
						Line filllpr = new Line (170 + pwidth, 100 + pheight + crotch + i, 170, 100 + pheight + crotch + i);
						filllpr.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
						cpane.getChildren().add(filllpr);
						
					}
				}
				
				//create upper pockets pockets
				//left upper
				QuadCurve uplpocket1 = new QuadCurve(160 - pwidth, 100 + (crotch / 2), 160 - 2*(pwidth / 3), 100 + (crotch / 2), 160 - (pwidth / 2), 100);
				uplpocket1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				uplpocket1.setFill(Color.TRANSPARENT);
				//Line uplpocket = new Line (160 - pwidth, 100 + (crotch / 2), 160 - (pwidth / 3), 100);
				//uplpocket.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(uplpocket1);
				
				//right upper
				QuadCurve uprpocket2 = new QuadCurve(170 + pwidth, 100 + (crotch / 2), 170 + 2*(pwidth / 3), 100 + (crotch / 2), 170 + (pwidth / 2), 100);
				uprpocket2.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				uprpocket2.setFill(Color.TRANSPARENT);
				//Line uprpocket = new Line (170 + pwidth, 100 + (crotch / 2), 170 + (pwidth / 3), 100);
				//uprpocket.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(uprpocket2);
				
				if(pocketstype == 2) {
					
					//left lower
					Line llowerpocket = new Line (160 - pwidth, 100 + crotch, 160 - pwidth + lppwidth, 100 + crotch);
					Line llowerpocket1 = new Line (160 - pwidth, 100 + crotch + lppheight, 160 - pwidth + lppwidth, 100 + crotch + lppheight);
					Line llowerpocket2 = new Line (160 - pwidth + lppwidth, 100 + crotch, 160 - pwidth + lppwidth, 100 + crotch + lppheight);
					llowerpocket.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
					llowerpocket1.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
					llowerpocket2.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
					cpane.getChildren().add(llowerpocket);
					cpane.getChildren().add(llowerpocket1);
					cpane.getChildren().add(llowerpocket2);
					
					for(int i = 0; i < lppwidth; i ++) {
						
						Line llowerpocket3 = new Line (160 - pwidth + lppwidth - i, 100 + crotch, 160 - pwidth + lppwidth - i, 100 + crotch + lppheight);
						llowerpocket3.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
						cpane.getChildren().add(llowerpocket3);
						
					}
					
					//right lower
					Line rlowerpocket = new Line (170 + pwidth, 100 + crotch, 170 + pwidth - lppwidth, 100 + crotch);
					Line rlowerpocket1 = new Line (170 + pwidth, 100 + crotch + lppheight, 170 + pwidth - lppwidth, 100 + crotch + lppheight);
					Line rlowerpocket2 = new Line (170 + pwidth - lppwidth, 100 + crotch, 170 + pwidth - lppwidth, 100 + crotch + lppheight);
					rlowerpocket.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
					rlowerpocket1.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
					rlowerpocket2.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
					cpane.getChildren().add(rlowerpocket);
					cpane.getChildren().add(rlowerpocket1);
					cpane.getChildren().add(rlowerpocket2);
					
					for(int i = 0; i < lppwidth; i ++) {
						
						Line rlowerpocket3 = new Line (170 + pwidth - lppwidth + i, 100 + crotch, 170 + pwidth - lppwidth + i, 100 + crotch + lppheight);
						rlowerpocket3.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
						cpane.getChildren().add(rlowerpocket3);
						
					}
				}				
			}catch(Exception e) {
				
				System.out.println("colorProblem" + e);
				
		}
	}
	
	public void createBackTrousers(Pane pane, Pane cpane, TrousersC a) {
		
		//get pants height and width
		int[] array = a.getPantshw();
		pheight = array[0];
		pwidth = array[1];	
		
		//crotch
		crotch = a.getCrotch();
		
		// lower pants height and type
		int[] array1 = a.getPantslp();
		lptype = array1[0];
		lpheight = array1[1];

		//get pockets existence type height and width
		int[] array2 = a.getPocketsT();
		pocketsflag = array2[0];
		pocketstype = array2[1];
		bpocketstype = array2[2];
		lppheight = array2[3];
		lppwidth = array2[4];
		
		//get colors
		int[][] arrayColor = a.getColorsT();
		
		cpane.setStyle("-fx-background-color: #FFFFFF");
		
		//check for lighter colors and change the background if needed
		for(int i = 0; i < 3; i ++) {			
			if(Arrays.equals(arrayColor[i], white) || Arrays.equals(arrayColor[i], lyellow) || Arrays.equals(arrayColor[i], vlyellow) || Arrays.equals(arrayColor[i], yellow) || Arrays.equals(arrayColor[i], vlgreen) || Arrays.equals(arrayColor[i], lgreen)) {
				
				cpane.setStyle("-fx-background-color: #000000");
				
			}
		}
		
		try {
			
			//create the pants crotch or "upper part" 
			Line line  = new Line(160 - pwidth, 100, 170 + pwidth, 100);
			Line crline1  = new Line(170 + pwidth, 100, 170 + pwidth, 100 + crotch);
			Line crline2  = new Line(160 - pwidth , 100, 160 - pwidth, 100 + crotch);
			line.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			crline1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			crline2.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			cpane.getChildren().add(line);
			cpane.getChildren().add(crline1);
			cpane.getChildren().add(crline2);
			
			for(int i = 0; i < crotch; i ++) {
				
				Line fillcroch = new Line(160 - pwidth , 100 + i, 170 + pwidth, 100 + i);
				fillcroch.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(fillcroch);
			}
			
			//create left pant
			Line pline = new Line (160 - pwidth, 100 + crotch, 160 - pwidth, 100 + pheight + crotch);
			Line pline1 = new Line (160 , 100 + crotch, 160, 100 + pheight + crotch);
			//Line pline2 = new Line (160, 100 + pheight + crotch, 160 - pwidth, 100 + pheight + crotch);
			pline.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			pline1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			//pline2.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			cpane.getChildren().add(pline);
			cpane.getChildren().add(pline1);
			//cpane.getChildren().add(pline2);
			
			for(int i = 0; i < pheight; i++) {
				
				Line fillpants = new Line (160 - pwidth , 100 + crotch + i, 160 , 100 + crotch + i);
				fillpants.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(fillpants);
				
			}
			
			//create right pant
			
			Line pline3 = new Line (170 + pwidth, 100 + crotch, 170 + pwidth, 100 + pheight + crotch);
			Line pline4 = new Line (170, 100 + crotch, 170, 100 + pheight + crotch);
			//Line pline5 = new Line (170 + pwidth, 100 + pheight + crotch, 170, 100 + pheight + crotch);
			pline3.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			pline4.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			//pline5.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			cpane.getChildren().add(pline3);
			cpane.getChildren().add(pline4);
			//cpane.getChildren().add(pline5);
			
			for(int i = 0; i < pheight; i++) {
				
				Line fillpants1 = new Line (170 + pwidth, 100 + crotch + i, 170, 100 + crotch + i);
				fillpants1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(fillpants1);
				
			}
			
			//create pants lower part
			if(lptype == 0) {
				
				//regular left
				Line lpline = new Line (160 - pwidth, 100 + pheight + crotch, 160 - pwidth, 100 + pheight + crotch + lpheight);
				Line lpline1 = new Line (160 , 100 + pheight + crotch,  160, 100 + pheight + crotch + lpheight);
				Line lpline2 = new Line (160 - pwidth, 100 + pheight + crotch + lpheight, 160, 100 + pheight + crotch + lpheight);
				lpline.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
				lpline1.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
				lpline2.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
				cpane.getChildren().add(lpline);
				cpane.getChildren().add(lpline1);
				cpane.getChildren().add(lpline2);
				
				for(int i = 0; i < lpheight; i ++) {
					
					Line filllpl = new Line (160 - pwidth, 100 + pheight + crotch + i, 160, 100 + pheight + crotch + i);
					filllpl.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					cpane.getChildren().add(filllpl);
					
				}
				
				//regular right
				Line lpline3 = new Line (170 , 100 + pheight + crotch, 170, 100 + pheight + crotch + lpheight);
				Line lpline4 = new Line (170 + pwidth, 100 + pheight + crotch, 170 + pwidth, 100 + pheight + crotch + lpheight);
				Line lpline5 = new Line (170, 100 + pheight + crotch + lpheight, 170 + pwidth, 100 + pheight + crotch + lpheight);
				lpline3.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
				lpline4.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
				lpline5.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
				cpane.getChildren().add(lpline3);
				cpane.getChildren().add(lpline4);
				cpane.getChildren().add(lpline5);
				
				for(int i = 0; i < lpheight; i ++) {
					
					Line filllpr = new Line (170 + pwidth, 100 + pheight + crotch + i, 170, 100 + pheight + crotch + i);
					filllpr.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					cpane.getChildren().add(filllpr);
					
				}
				
			}else if (lptype == 1) {
				
				//wide left
				Line lpline = new Line (160 - pwidth, 100 + pheight + crotch, 160 - pwidth - 1, 100 + pheight + crotch + lpheight);
				Line lpline1 = new Line (160 , 100 + pheight + crotch,  160 + 1, 100 + pheight + crotch + lpheight);
				//Line lpline2 = new Line (160 - pwidth - 3, 100 + pheight + crotch + lpheight, 160 + 3, 100 + pheight + crotch + lpheight);
				lpline.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
				lpline1.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
				//lpline2.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
				cpane.getChildren().add(lpline);
				cpane.getChildren().add(lpline1);
				//cpane.getChildren().add(lpline2);
				
				for(int i = 0; i < lpheight; i ++) {
					
					Line filllpl = new Line (160 - pwidth, 100 + pheight + crotch + i, 160, 100 + pheight + crotch + i);
					filllpl.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					cpane.getChildren().add(filllpl);
					
				}
									
				//wide right
				Line lpline3 = new Line (170 , 100 + pheight + crotch, 170 - 1, 100 + pheight + crotch + lpheight);
				Line lpline4 = new Line (170 + pwidth, 100 + pheight + crotch, 170 + pwidth + 1, 100 + pheight + crotch + lpheight);
				//Line lpline5 = new Line (170 - 3, 100 + pheight + crotch + lpheight, 170 + pwidth + 3, 100 + pheight + crotch + lpheight);
				lpline3.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
				lpline4.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
				//lpline5.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
				cpane.getChildren().add(lpline3);
				cpane.getChildren().add(lpline4);
				//cpane.getChildren().add(lpline5);
				
				for(int i = 0; i < lpheight; i ++) {
					
					Line filllpr = new Line (170 + pwidth, 100 + pheight + crotch + i, 170, 100 + pheight + crotch + i);
					filllpr.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
					cpane.getChildren().add(filllpr);
					
				}
			}
			
			if(pocketstype == 2) {
				
				//left lower
				Line llowerpocket = new Line (160 - pwidth, 100 + crotch, 160 - pwidth + (lppwidth /2), 100 + crotch);
				Line llowerpocket1 = new Line (160 - pwidth, 100 + crotch + lppheight, 160 - pwidth + (lppwidth /2), 100 + crotch + lppheight);
				Line llowerpocket2 = new Line (160 - pwidth + (lppwidth /2), 100 + crotch, 160 - pwidth + (lppwidth /2), 100 + crotch + lppheight);
				llowerpocket.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
				llowerpocket1.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
				llowerpocket2.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
				cpane.getChildren().add(llowerpocket);
				cpane.getChildren().add(llowerpocket1);
				cpane.getChildren().add(llowerpocket2);
				
				for(int i = 0; i < (lppwidth /2); i ++) {
					
					Line llowerpocket3 = new Line (160 - pwidth + (lppwidth /2) - i, 100 + crotch, 160 - pwidth + (lppwidth /2) - i, 100 + crotch + lppheight);
					llowerpocket3.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
					cpane.getChildren().add(llowerpocket3);
					
				}
				
				//right lower
				Line rlowerpocket = new Line (170 + pwidth, 100 + crotch, 170 + pwidth - (lppwidth /2), 100 + crotch);
				Line rlowerpocket1 = new Line (170 + pwidth, 100 + crotch + lppheight, 170 + pwidth - (lppwidth /2), 100 + crotch + lppheight);
				Line rlowerpocket2 = new Line (170 + pwidth - (lppwidth /2), 100 + crotch, 170 + pwidth - (lppwidth /2), 100 + crotch + lppheight);
				rlowerpocket.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
				rlowerpocket1.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
				rlowerpocket2.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
				cpane.getChildren().add(rlowerpocket);
				cpane.getChildren().add(rlowerpocket1);
				cpane.getChildren().add(rlowerpocket2);
				
				for(int i = 0; i < (lppwidth /2); i ++) {
					
					Line rlowerpocket3 = new Line (170 + pwidth - (lppwidth /2) + i, 100 + crotch, 170 + pwidth - (lppwidth /2) + i, 100 + crotch + lppheight);
					rlowerpocket3.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
					cpane.getChildren().add(rlowerpocket3);
					
				}
			}
			
			//back pockets
			if(bpocketstype == 1) {
				
				//left back pocket
				Line lpocket = new Line (155 - (pwidth / 1.5), 100 + (crotch / 2), 155, 100 + (crotch / 2));
				Line lpocket1 = new Line (155 - (pwidth / 1.5), 100 + (crotch / 2) + 2, 155, 100 + (crotch / 2) + 2);
				Line lpocket2 = new Line (155 - (pwidth / 1.5), 100 + (crotch / 2), 155 - (pwidth / 1.5), 100 + (crotch / 2) + 2);
				Line lpocket3 = new Line (155 , 100 + (crotch / 2) , 155, 100 + (crotch / 2) + 2);
				lpocket.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				lpocket1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				lpocket2.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				lpocket3.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(lpocket);
				cpane.getChildren().add(lpocket1);
				cpane.getChildren().add(lpocket2);
				cpane.getChildren().add(lpocket3);
				
				//right back pocket
				Line rpocket = new Line (175 + (pwidth / 1.5), 100 + (crotch / 2), 175, 100 + (crotch / 2));
				Line rpocket1 = new Line (175 + (pwidth / 1.5), 100 + (crotch / 2) + 2, 175, 100 + (crotch / 2) + 2);
				Line rpocket2 = new Line (175 + (pwidth / 1.5), 100 + (crotch / 2), 175 + (pwidth / 1.5), 100 + (crotch / 2) + 2);
				Line rpocket3 = new Line (175 , 100 + (crotch / 2) , 175, 100 + (crotch / 2) + 2);
				rpocket.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				rpocket1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				rpocket2.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				rpocket3.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(rpocket);
				cpane.getChildren().add(rpocket1);
				cpane.getChildren().add(rpocket2);
				cpane.getChildren().add(rpocket3);
				
			}else if(bpocketstype == 2) {
				
				pheight = crotch / 2;
				
				//left back pocket
				Line lpocket = new Line (155 - (pwidth / 1.5), 100 + (crotch / 3), 155, 100 + (crotch / 3));
				Line lpocket1 = new Line (155 - (pwidth / 1.5), 100 + (crotch / 3) + pheight, 155, 100 + (crotch / 3) + pheight);
				Line lpocket2 = new Line (155 - (pwidth / 1.5), 100 + (crotch / 3), 155 - (pwidth / 1.5), 100 + (crotch / 3) + pheight);
				Line lpocket3 = new Line (155 , 100 + (crotch / 3) , 155, 100 + (crotch / 3) + pheight);
				lpocket.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				lpocket1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				lpocket2.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				lpocket3.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(lpocket);
				cpane.getChildren().add(lpocket1);
				cpane.getChildren().add(lpocket2);
				cpane.getChildren().add(lpocket3);
				
				//right back pocket
				Line rpocket = new Line (175 + (pwidth / 1.5), 100 + (crotch / 3), 175, 100 + (crotch / 3));
				Line rpocket1 = new Line (175 + (pwidth / 1.5), 100 + (crotch / 3) + pheight, 175, 100 + (crotch / 3) + pheight);
				Line rpocket2 = new Line (175 + (pwidth / 1.5), 100 + (crotch / 3), 175 + (pwidth / 1.5), 100 + (crotch / 3) + pheight);
				Line rpocket3 = new Line (175 , 100 + (crotch / 3) , 175, 100 + (crotch / 3) + pheight);
				rpocket.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				rpocket1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				rpocket2.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				rpocket3.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(rpocket);
				cpane.getChildren().add(rpocket1);
				cpane.getChildren().add(rpocket2);
				cpane.getChildren().add(rpocket3);
				
			}
		}catch(Exception e) {
			
			System.out.println("colorProblem" + e);
			
	}
		 
		
	}
}

