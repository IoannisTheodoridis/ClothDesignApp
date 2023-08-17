package application;

import javafx.scene.paint.Color;
import java.util.Arrays;
import java.util.Random;
import Constructos.TShirtC;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;


public class TShirt {
	
	private int resulty,resultx, lpheight, slwidth, slheight, pocketsflag, pocketstype, pheight, pwidth, colar;
	private double endX, endY;
	private double prefchances = 0.5;
	private int[] white = { 255, 255, 255};
	private int[] vlyellow = { 255, 255, 204};
	private int[] lyellow = { 255, 255, 153};
	private int[] yellow = { 255, 255, 0};
	private int[] vlgreen = { 102, 255, 102};
	private int[] lgreen = { 0, 255, 51};
	
	public void createTshirt(Pane cpane, TShirtC a, boolean flag, String prefcolor, String prefsltype, String prefsh, String prefneck, String prefpockets ) {		
		
		int arrayColor[][] = new int[4][3];
		Random r = new Random();
		double chances = r.nextInt();
		
		
		if(flag == false) {
			
			//random number for body lower part
			if(prefsh == "ANY" || prefchances > chances) {
				
				lpheight = a.Randomlowerpart();
			
			}else if(prefsh == "SHORT") {
				
				lpheight = 0;
				
			}else {
				
				do {
					
					lpheight = a.Randomlowerpart();
					
				}while(lpheight > 0);
				
			}
			
			if(prefsltype == "ANY" || prefchances > chances) {
				
				// random number for sleeves width
				resulty = a.Randomsleevesw();
				
				// random number for sleeves height
				resultx = a.Randomsleevesh();	
				endX = 100 - resultx;
				endY = 100 + resultx;
				
			}else if(prefsltype == "NO SLEEVES") {
				
				// random number for sleeves width
				resulty = 0;
				
				// random number for sleeves height
				resultx = 0;	
				endX = 100 - resultx;
				endY = 100 + resultx;
				
			}else if(prefsltype == "SHORT SLEEVES") {
				
				do {
					
					// random number for sleeves width
					resulty = a.Randomsleevesw();
					
					// random number for sleeves height
					resultx = a.Randomsleevesh();
					
				}while(resultx > 60);
						
				endX = 100 - resultx;
				endY = 100 + resultx;
				
			}else if(prefsltype == "LONG SLEEVES") {
				
				do {
					
					// random number for sleeves width
					resulty = a.Randomsleevesw();
					
					// random number for sleeves height
					resultx = a.Randomsleevesh();
					
				}while(resultx < 60 && resultx > 0);
						
				endX = 100 - resultx;
				endY = 100 + resultx;
				
			}else if(prefsltype == "3/4") {
				
				// random number for sleeves width
				resulty = a.Randomsleevesw();
					
				// random number for sleeves height
				resultx = 60;

						
				endX = 100 - resultx;
				endY = 100 + resultx;
				
			}
			
			//random neck type
			if(prefneck == "ANY" || prefchances > chances) {
				
				colar = a.randomNeck();
				
			}else if(prefneck == "REGULAR") {
				
				colar = 0;
				
			}else if(prefneck == "POLO") {
				
				colar = 1;
				
			}else if(prefneck == "CREW") {
				
				colar = 2;
				
			}else if(prefneck == "FUNNEL") {
				
				colar = 3;
				
			}else if(prefneck == "HIGH") {
				
				colar = 4;
				
			}else if(prefneck == "ROLL") {
				
				colar = 5;
				
			}
			
			//random sleeves lower part height, width
			int max = 2;
			int min = 1;
			int chances1 = (int) ((Math.random() * ((max - min) + 1)) + min);
			if(resultx > 80 && chances1 == 1) {
				
				slheight = a.Randomlpsleevesheight();
				slwidth = a.Randomlpsleeveswidth();
				
			}else {
				
				slheight = 0;
				slwidth = 0;

			}
					
			if(prefpockets == "ANY" || prefchances > chances) {
				
				//random pockets
				pocketsflag = a.Randompocketsex();
				
				if(pocketsflag ==0) {
					
					//random pocket type
					pocketstype = a.Randompockettype();
			
					//random pocket height
					pheight = a.Randompocketsh();
			
					//random pocket height
					pwidth = a.Randompocketsw();
					
				} else {
					
					//because there are no pockets its value equals 0
					pocketstype = 0;
					pheight =  0;
					pwidth =  0;
					
				}	
			}else if (prefpockets == "YES") {
				
				pocketsflag = 0;
				
				//random pocket type
				pocketstype = a.Randompockettype();
		
				//random pocket height
				pheight = a.Randompocketsh();
		
				//random pocket height
				pwidth = a.Randompocketsw();
				
				
			}else if (prefpockets == "NO") {
				
				// no sleeves
				pocketsflag = 1;
				pocketstype = 0;
				pheight = 0;
				pwidth = 0;
			
			}
			
			//set values 
			int[] array = {resultx, resulty};			
			int[] array1 = {slheight, slwidth};
			int[] array2 = {pocketsflag , pocketstype, pheight, pwidth};
			
			if( prefchances > chances ) {
				
				arrayColor = a.RandomColorCombination( a, "");
				
			}else {
			
				arrayColor = a.RandomColorCombination( a, prefcolor);
				
			}
			
			a.setSleevehw(array);
			a.setLowerparthw(array1);
			a.setPockets(array2);
			a.setLowerpartheight(lpheight);
			a.setPoloneck(colar);
			a.setColors(arrayColor);
			
		}else {
			
			// get sleeves height and width
			int[] array = a.getSleevehw();
			resultx = array[0];
			resulty = array[1];	
					
			endX = 100 - resultx;
			endY = 100 + resultx;
			
			//body lower part height
			lpheight = a.getLowerpartheight();
			
			// lower sleeves height and width
			int[] array1 = a.getLowerparthw();
			slheight = array1[0];
			slwidth = array1[1];
			
			//neck type
			colar = a.getPoloneck();
			
			//get pockets existence type height and width
			int[] array2 = a.getPockets();
			pocketsflag = array2[0];
			pocketstype = array2[1];
			pheight = array2[2];
			pwidth = array2[3];
			
			//get colors
			arrayColor = a.getColors();
		}
		
		//check for lighter colors and change the background if needed
		for(int i = 0; i < 3; i ++) {			
			if(Arrays.equals(arrayColor[i], white) 
					|| Arrays.equals(arrayColor[i], lyellow) 
					|| Arrays.equals(arrayColor[i], vlyellow) 
					|| Arrays.equals(arrayColor[i], yellow) 
					|| Arrays.equals(arrayColor[i], vlgreen) 
					|| Arrays.equals(arrayColor[i], lgreen)) {
				
				cpane.setStyle("-fx-background-color: #000000");
				
			}
		}
		 
		try {				
		//if we have no sleeves then
		if(resultx >= 20) {
		
		//create left sleeve			
		Line line = new Line(100, 100, endX, endY);
		Line line3 = new Line( resulty + 110, resulty + 110, endX + 10 + resulty, endY + 10 + resulty);
		Line line5 = new Line( endX, endY, endX + 10 + resulty, endY + 10 + resulty );
		line.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
		line3.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
		line5.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
		cpane.getChildren().add(line);
		cpane.getChildren().add(line3);
		cpane.getChildren().add(line5);	
		
		for(double i = 0; i < resulty + 10;) {
			
			i = i + 1;
			
			Line inline  = new Line( endX + i, endY + i, 100 + i, 100 + i);
			inline.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
			cpane.getChildren().add(inline);
			
		}
				
		//create right sleeve
		
		Line line2 = new Line( 230, 100, 330 - endX, endY);
		Line line4 = new Line( 220 - resulty, 110 + resulty, 320 - endX - resulty, endY + 10 + resulty );
		Line line6 = new Line( 330 - endX, endY, 320 - endX - resulty, endY + 10 + resulty );
		line2.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
		line4.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
		line6.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
		cpane.getChildren().add(line2);
		cpane.getChildren().add(line4);
		cpane.getChildren().add(line6);
			
		for(double i = 0; i < resultx;) {
			
			i = i + 1;
			
			Line inline = new Line( 330 - endX - i, endY - i, 320 - endX - resulty - i, endY + 10 + resulty - i);
			inline.setStroke(Color.rgb(arrayColor[1][0], arrayColor[1][1], arrayColor[1][2]));
			cpane.getChildren().add(inline);
			
			}						
		}
		
		//create body		
		//Line linebody1 = new Line( resulty + 110, resulty + 110, 220 - resulty, 110 + resulty );
		Line linebody2 = new Line( resulty + 110, resulty + 110, resulty + 110, resulty + 210 );
		Line linebody3 = new Line( 220 - resulty,resulty + 110, 220 - resulty, resulty + 210 );
		//Line linebody4 = new Line( resulty + 110, resulty + 210 , 220 - resulty, resulty + 210 );
		//linebody1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
		linebody2.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
		linebody3.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
		//linebody4.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
		//cpane.getChildren().add(linebody1);
		cpane.getChildren().add(linebody2);
		cpane.getChildren().add(linebody3);
		//cpane.getChildren().add(linebody4);
		
		//create lower body part
		if(lpheight > 0) {
			
			Line linelp1 = new Line(resulty + 110, resulty + 210, resulty + 110, resulty + 210 + lpheight);
			Line linelp2 = new Line(220 - resulty, resulty + 210, 220 - resulty, resulty + 210 + lpheight);
			Line linelp3 = new Line(resulty + 110, resulty + 210 + lpheight, 220 - resulty, resulty + 210 + lpheight);
			linelp1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			linelp2.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			linelp3.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			cpane.getChildren().add(linelp1);
			cpane.getChildren().add(linelp2);
			cpane.getChildren().add(linelp3);
			
		}
		
		for(int i = 0; i <= 100 + lpheight; i ++) {
			
			Line inline  = new Line(resulty + 110, resulty + 210 + lpheight - i, 220 - resulty, resulty + 210 + lpheight - i);
			inline.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			cpane.getChildren().add(inline);
			
		}
		
		//create neck and upper part
		if(resultx >= 20) {
			
			Line neckline = new Line(145, 100 ,100,100 );
			Line neckline1 = new Line(185, 100 ,230,100 );
			neckline.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			neckline1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			cpane.getChildren().add(neckline);
			cpane.getChildren().add(neckline1);
			
			for(int i = 1; i < 10 + resulty; i ++) {
				
				Line inline  = new Line(100 + i, 100 + i, 230 - i, 100 + i);
				inline.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(inline);				
				
			}			
		} else {
			
			Line neckline = new Line(145, 100 ,resulty + 110,100 );
			Line neckline1 = new Line(185, 100 ,220 - resulty, 100 );
			Line neckline2 = new Line(resulty + 110, resulty + 110, resulty + 110, 100 );
			Line neckline3 = new Line(220 - resulty, 220 - resulty ,220 - resulty, 100 );
			neckline.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			neckline1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			neckline2.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			neckline3.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			cpane.getChildren().add(neckline);
			cpane.getChildren().add(neckline1);
			cpane.getChildren().add(neckline2);
			cpane.getChildren().add(neckline3);
			
			for(int i = 1; i < 10 + resulty; i ++) {
				
				Line inline  = new Line(110 + resulty , 100 + i, 220 - resulty , 100 + i);
				inline.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(inline);				
				
			}
		}
		
		//create colar type neck
		if(colar == 0) {
			
			//regular neck
			for(int i = 0; i < 5; i ++) {
				
				QuadCurve neck = new QuadCurve(145, 100 ,165, 140, 185, 100);
				neck.setStroke(Color.WHITE);
				neck.setFill(Color.WHITE);
				for(int j = 0; j < 4; j ++) {			
					if(Arrays.equals(arrayColor[j], white) || Arrays.equals(arrayColor[j], lyellow) || Arrays.equals(arrayColor[j], vlyellow) || Arrays.equals(arrayColor[j], yellow) || Arrays.equals(arrayColor[j], vlgreen) || Arrays.equals(arrayColor[j], lgreen)) {
						
						neck.setStroke(Color.BLACK);
						neck.setFill(Color.BLACK);
						
					}
				}
				
				cpane.getChildren().add(neck);
				
			}
		}else if(colar == 1) {
			
			//polo neck
			QuadCurve neck = new QuadCurve(145, 100 ,165, 140, 185, 100);
			neck.setStroke(Color.WHITE);
			neck.setFill(Color.WHITE);
			
			for(int i = 0; i < 5; i ++) {
				for(int j = 0; j < 4; j ++) {			
					if(Arrays.equals(arrayColor[j], white) || Arrays.equals(arrayColor[j], lyellow) || Arrays.equals(arrayColor[j], vlyellow) || Arrays.equals(arrayColor[j], yellow) || Arrays.equals(arrayColor[j], vlgreen) || Arrays.equals(arrayColor[j], lgreen)) {
						
						neck.setStroke(Color.BLACK);
						neck.setFill(Color.BLACK);
						
					}
				}
				
				Line neckline = new Line (140, 100, 143, 125);
				Line neckline1 = new Line (143, 125, 165, 120);
				Line neckline2 = new Line (190, 100, 188, 125);
				Line neckline3 = new Line (188, 125, 165, 120);
				neckline.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				neckline1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				neckline2.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				neckline3.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(neckline);
				cpane.getChildren().add(neckline1);
				cpane.getChildren().add(neckline2);
				cpane.getChildren().add(neckline3);
				
			}
			
			cpane.getChildren().add(neck);
			
		}else if(colar == 2) {
			
			//crew neck
			QuadCurve neck = new QuadCurve(145, 100 ,165, 120, 185, 100);
			neck.setStroke(Color.WHITE);
			neck.setFill(Color.WHITE);
			for(int j = 0; j< 4; j ++) {			
				if(Arrays.equals(arrayColor[j], white) || Arrays.equals(arrayColor[j], lyellow) || Arrays.equals(arrayColor[j], vlyellow) || Arrays.equals(arrayColor[j], yellow) || Arrays.equals(arrayColor[j], vlgreen) || Arrays.equals(arrayColor[j], lgreen)) {
					
					neck.setStroke(Color.BLACK);
					neck.setFill(Color.BLACK);
					
				}
			}
			
			cpane.getChildren().add(neck);
			
		}else if(colar == 3) {
			
			//funnel neck
			QuadCurve neck = new QuadCurve(145, 100 ,165, 110, 185, 100);
			neck.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			neck.setFill(Color.TRANSPARENT);
			cpane.getChildren().add(neck);
			
			for(int i = 0; i < 10; i++) {
				
				Line neckline = new Line (145, 100 - i, 185, 100 - i);
				neckline.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(neckline);
				
			}
			
		}else if(colar == 4) {
			
			//high neck
			QuadCurve neck = new QuadCurve(145, 100 ,165, 110, 185, 100);
			neck.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			neck.setFill(Color.TRANSPARENT);
			cpane.getChildren().add(neck);
			
			for(int i = 0; i < 15; i++) {
				
				Line neckline = new Line (145, 100 - i, 185, 100 - i);
				neckline.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(neckline);
				
			}			
		}else if(colar == 5) {
			
			//roll neck
			QuadCurve neck1 = new QuadCurve(145, 97 ,165, 107, 185, 97);
			neck1.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
			neck1.setFill(Color.TRANSPARENT);
			cpane.getChildren().add(neck1);
			
			for(int i = 3; i < 15; i++) {
				
				Line neckline = new Line (143, 100 - i, 187, 100 - i);
				neckline.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(neckline);
				
			}
			for(int i = 0; i < 3; i++) {
				
				Line neckline = new Line (145, 100 - i, 185, 100 - i);
				neckline.setStroke(Color.rgb(arrayColor[0][0], arrayColor[0][1], arrayColor[0][2]));
				cpane.getChildren().add(neckline);
				
			}
		}
		
		//create sleeves lower part 
		if(resultx >= 60 && slheight!= 0 && slwidth != 0){
		
			//left sleeve
			double endX1;
			double endY1;
			endX1 = ((2*endX + 10 + resulty)/2);
			endY1 = ((2*endY + 10 + resulty)/2);
			
			//( endX1 - slheight, endY1 + slheight, endX1, endY1)
		
			Line slline1 = new Line ( endX1 - (slwidth/2) - slheight, endY1 - (slwidth /2) + slheight, endX1 + (slwidth/2) - slheight, endY1 + (slwidth/2) + slheight);
			Line slline = new Line ( endX1 - (slwidth/2) - slheight, endY1 - (slwidth /2) + slheight, endX, endY);
			Line slline2 = new Line(endX + 10 + resulty, endY + 10 + resulty ,endX1 + (slwidth/2) - slheight, endY1 + (slwidth/2) + slheight);
			slline.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
			slline1.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
			slline2.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
			cpane.getChildren().add(slline);
			cpane.getChildren().add(slline1);
			cpane.getChildren().add(slline2);
		
			//right sleeve
			double endX2;
			double endY2;		
			endX2 = (((330- endX)-(320 - endX - resulty))/2) + (320 - endX - resulty);
			endY2 = (((endY)-(endY + 10 + resulty))/2) + (endY + 10 + resulty);
			
			//( endX2, endY2, endX2 + slheight, endY2 + slheight)
		
			Line slline3 = new Line (  endX2 + (slwidth/2) + slheight , endY2 - (slwidth/2) + slheight, 330 - endX, endY);
			Line slline4 = new Line ( endX2 - (slwidth/2) + slheight, endY2 + (slwidth /2) + slheight, endX2 + (slwidth/2) + slheight , endY2 - (slwidth/2) + slheight);
			Line slline5 = new Line ( endX2 - (slwidth/2) + slheight, endY2 + (slwidth /2) + slheight, 320 - endX - resulty, endY + 10 + resulty );
			slline3.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
			slline4.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
			slline5.setStroke(Color.rgb(arrayColor[2][0], arrayColor[2][1], arrayColor[2][2]));
			cpane.getChildren().add(slline3);
			cpane.getChildren().add(slline4);
			cpane.getChildren().add(slline5);
		
	}
		
			if (pocketsflag == 0) {
				
				if(pocketstype == 0) {
					
					//left pocket
					Line pocketline = new Line(155, 135, 155 - pwidth, 135);
					Line pocketline1 = new Line(155, 135, 155, 135 + pheight);
					Line pocketline2 = new Line(155 - pwidth, 135, 155 - pwidth, 135 + pheight);
					Line pocketline3 = new Line(155 - pwidth, 135, 155 - pwidth, 135);
					Line pocketline4 = new Line(155 - pwidth, 135 + pheight, 155, 135 + pheight );
					pocketline.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline1.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline2.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline3.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline4.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					cpane.getChildren().add(pocketline);
					cpane.getChildren().add(pocketline1);
					cpane.getChildren().add(pocketline2);
					cpane.getChildren().add(pocketline3);
					cpane.getChildren().add(pocketline4);
					
					for(int i = 0; i < pheight; i ++) {
						
						Line inline  = new Line(155, 135 + i, 155 - pwidth, 135 + i);
						inline.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
						cpane.getChildren().add(inline);				
						
					}
					
				}else if(pocketstype == 1) {
					
					//right pocket
					Line pocketline = new Line(175, 135, 175 + pwidth, 135);
					Line pocketline1 = new Line(175, 135, 175, 135 + pheight);
					Line pocketline2 = new Line(175 + pwidth, 135, 175 + pwidth, 135 + pheight);
					Line pocketline3 = new Line(175 + pwidth, 135, 175 + pwidth, 135);
					Line pocketline4 = new Line(175 + pwidth, 135 + pheight, 175, 135 + pheight );
					pocketline.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline1.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline2.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline3.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline4.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					cpane.getChildren().add(pocketline);
					cpane.getChildren().add(pocketline1);
					cpane.getChildren().add(pocketline2);
					cpane.getChildren().add(pocketline3);
					cpane.getChildren().add(pocketline4);
					
					for(int i = 0; i < pheight; i ++) {
						
						Line inline  = new Line(175, 135 + i, 175 + pwidth, 135 + i);
						inline.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
						cpane.getChildren().add(inline);				
						
					}
					
				}
				else {
					
					//both pockets
					Line pocketline = new Line(155, 135, 155 - pwidth, 135);
					Line pocketline1 = new Line(155, 135, 155, 135 + pheight);
					Line pocketline2 = new Line(155 - pwidth, 135, 155 - pwidth, 135 + pheight);
					Line pocketline3 = new Line(155 - pwidth, 135, 155 - pwidth, 135);
					Line pocketline4 = new Line(155 - pwidth, 135 + pheight, 155, 135 + pheight );
					pocketline.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline1.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline2.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline3.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline4.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					cpane.getChildren().add(pocketline);
					cpane.getChildren().add(pocketline1);
					cpane.getChildren().add(pocketline2);
					cpane.getChildren().add(pocketline3);
					cpane.getChildren().add(pocketline4);
					
					Line pocketline5 = new Line(175, 135, 175 + pwidth, 135);
					Line pocketline6 = new Line(175, 135, 175, 135 + pheight);
					Line pocketline7 = new Line(175 + pwidth, 135, 175 + pwidth, 135 + pheight);
					Line pocketline8 = new Line(175 + pwidth, 135, 175 + pwidth, 135);
					Line pocketline9 = new Line(175 + pwidth, 135 + pheight, 175, 135 + pheight );
					pocketline5.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline6.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline7.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline8.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					pocketline9.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
					cpane.getChildren().add(pocketline5);
					cpane.getChildren().add(pocketline6);
					cpane.getChildren().add(pocketline7);
					cpane.getChildren().add(pocketline8);
					cpane.getChildren().add(pocketline9);
					
					for(int i = 0; i < pheight; i ++) {
						
						Line inline  = new Line(155, 135 + i, 155 - pwidth, 135 + i);
						inline.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
						cpane.getChildren().add(inline);				
						
					}
					
					for(int i = 0; i < pheight; i ++) {
						
						Line inline  = new Line(175, 135 + i, 175 + pwidth, 135 + i);
						inline.setStroke(Color.rgb(arrayColor[3][0], arrayColor[3][1], arrayColor[3][2]));
						cpane.getChildren().add(inline);				
						
					}
				}
			}
		}catch(Exception e) {
			
			System.out.println("colorProblem" + e);
			
		}
	}
}
