package application;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;
import Constructos.TShirtC;
import Constructos.TrousersC;
import EA.Crossover;
import EA.Selection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Controller{
	
	@FXML VBox mansub, womansub, all, StatsPane,StatsVBox, filter1, filter2, trend1, trend2, recentimages;
	@FXML Button buttons, buttons1, buttons2, newGen, finalGen, resetB, generateB;
	@FXML ChoiceBox<Integer> gennumber, maxgens;
	@FXML ChoiceBox<String> colorpal, pocketsch, shirtsheight, sleevesheight, poloneck, colorpalT, panttype, crotch, pocketschT, pantslowerpart, colorpal1, pocketsch1, shirtsheight1, sleevesheight1, poloneck1, colorpalT1, panttype1, crotch1, pocketschT1, pantslowerpart1;
	@FXML AnchorPane bganchor, notev;
	@FXML Tab generation, options;
	@FXML Label help, chromosomes, selcetedcloth, gennum, fitavg;
	@FXML Text notevp;
	@FXML ProgressBar pb;
	@FXML TabPane tabM;
	@FXML ScrollPane sp;
	@FXML FlowPane atome;
	@FXML Pane pantsbackside;
	
	private boolean chflag = false;
	private boolean initializeflag = false;
	private boolean generationflag = false;
	TShirtC[] parents = new TShirtC[2];
	TShirtC[] newgen = new TShirtC[200];
	TShirt tshirt = new TShirt();
	TrousersC[] parentsT = new TrousersC[2];
	TrousersC[] newgenT = new TrousersC[200];
	Trouser trouser = new Trouser();
	private int[] rating, ev;
	private int len, mgen;
	private int cgen = 0;
	private int imagecount = 0;
	private float fitnessavg = 0;
	Selection eva = new Selection();
	Crossover cr= new Crossover();
	@SuppressWarnings("rawtypes")
	private ChoiceBox[] chb;
	private Pane[] ng;
	private TShirtC[] nt;
	private TrousersC[] ntr;
	private String[] colorpalet = {"", "RED", "BLUE", "GREEN", "YELLOW", "ORANGE", "GREY", "BROWN", "PURPLE", "BLACK", "WHITE"};
	private String[] sleevestype = {"ANY", "NO SLEEVES", "SHORT SLEEVES", "LONG SLEEVES", "3/4"};
	private String[] pocketsex = {"ANY", "YES", "NO"};
	private String[] shirth = {"ANY", "LONG", "SHORT"};
	private String[] necktype = {"ANY", "REGULAR", "POLO", "CREW", "FUNNEL","HIGH", "ROLL"};
	private String[] crotchtype = {"ANY", "HIGH", "MIDDLE", "LOW"};
	private String[] pantslp = {"ANY", "REGULAR", "WIDE"};
	
	//enable option tab options for SHIRT
	public void optionsEnabledShirt() {
		
		SingleSelectionModel<Tab> selectionModel = tabM.getSelectionModel();
		selectionModel.select(1);
		filter2.setDisable(true);
		filter1.setDisable(false);
		generateB.setDisable(false);
		
	}
	
	//enable option tab options for SHIRT
	public void optionsEnabledTrousers() {
			
		SingleSelectionModel<Tab> selectionModel = tabM.getSelectionModel();
		selectionModel.select(1);
		filter1.setDisable(true);
		filter2.setDisable(false);
		generateB.setDisable(false);
			
	}
	
	//reset button
	public void resetGen() {
		
		atome.getChildren().clear();
		SingleSelectionModel<Tab> selectionModel = tabM.getSelectionModel();
		chflag = false;
		initializeflag = false;
		cgen = 0;
		gennum.setText("GENERATION NUM : " + cgen);
		fitavg.setText("FITNESS AVG : ");
		newGen.setDisable(false);
		finalGen.setDisable(false);
		generateB.setDisable(true);
		filter1.setDisable(true);
		filter2.setDisable(true);
		for(int i = 0; i < ng.length; i++) {
			
			removeAll(ng[i]);
	
		}
		for(int i = 0; i < parents.length; i++) {
			
			parents[i] = null;
	
		}
		for(int i = 0; i < newgen.length; i++) {
			
			newgen[i] = null;
	
		}
		for(int i = 0; i < ev.length; i++) {
			
			ev[i] = 0;
	
		}
		options.setDisable(false);
		selectionModel.select(1);
		generation.setDisable(true);
		buttons.setDisable(false);
		buttons1.setDisable(false);
		buttons2.setDisable(false);
		help.setText("Generation Board: Deactivated");
		pb.setProgress(0F);
		
		// Defautl the choice boxes			
		colorpal.setValue("");			
		colorpalT.setValue("");			
		colorpal1.setValue("");
		colorpalT1.setValue("");
		sleevesheight.setValue("ANY");
		sleevesheight1.setValue("ANY");
		pocketsch.setValue("ANY");
		pocketschT.setValue("ANY");
		pocketsch1.setValue("ANY");
		pocketschT1.setValue("ANY");
		shirtsheight.setValue("ANY");
		panttype.setValue("ANY");
		shirtsheight1.setValue("ANY");
		panttype1.setValue("ANY");
		crotch.setValue("ANY");
		crotch1.setValue("ANY");
		pantslowerpart.setValue("ANY");
		pantslowerpart1.setValue("ANY");
		poloneck.setValue("ANY");
		poloneck1.setValue("ANY");
			
	}
	
	//final generation button
	public void finalGen() {
		
		try {
			
			File home = FileSystemView.getFileSystemView().getHomeDirectory();
			String path = home.getAbsolutePath() + "\\dc" + imagecount + ".png";
			Robot robot = new Robot();
			Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			Bounds bounds = atome.localToScene(atome.getBoundsInLocal());
			rect.setBounds((int) bounds.getMinX(), (int) bounds.getMinY()
					+ 20, (int) bounds.getWidth() - 20, (int) bounds.getHeight() - 20);
			BufferedImage screens = robot.createScreenCapture(rect);
			ImageIO.write(screens, "png", new File (path));
			
			if(imagecount == 0) {
				
				ImageView nimage = new ImageView(path);
				nimage.getStyleClass().add("RecentImagesI");
				nimage.setId("image" + 1);
				nimage.setFitWidth(600);
				nimage.setFitHeight(300);
				recentimages.getChildren().add(nimage);
				
			}else if(imagecount == 1){
				
				ImageView nimage = new ImageView(path);
				nimage.getStyleClass().add("RecentImagesI");
				nimage.setId("image" + 2);
				nimage.setFitWidth(600);
				nimage.setFitHeight(300);
				recentimages.getChildren().add(nimage);
				
			}
			
			imagecount++;
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		newGen.setDisable(true);
		finalGen.setDisable(true);
		help.setText("Generation Board: Final Generation has been selected");
		pb.setProgress(1F);
		cgen = 0;
		
		
	}
	
	//panel of "not evaluated designs"  
	public void closePopEv(ActionEvent event) {
		
		notev.setVisible(false);
		
	}
	
	//fills the choice boxes of generation size, max generation number, filters and trends
	public void fillgenn() {
		
		if(generationflag == false) {
			
			// fill siblings per generation choice box and set default 
			for(int i = 2; i <=10; i ++) {
		
				gennumber.getItems().add(i);
				generationflag = true;
				
			}
			
			gennumber.setValue(10);
			
			
			// fill max generation choice box and set default
			for(int i = 6; i <= 30; i ++) {
				
				maxgens.getItems().add(i);
				generationflag = true;
				
			}
			
			maxgens.setValue(10);
			
			// fill color of choice choice boxes and set default values
			for(int i = 0; i < colorpalet.length; i++) {
				
				colorpal.getItems().add(colorpalet[i]);
				colorpalT.getItems().add(colorpalet[i]);
				colorpal1.getItems().add(colorpalet[i]);
				colorpalT1.getItems().add(colorpalet[i]);
				
			}
			
			colorpal.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->
			colorpal.setStyle("-fx-background-color: "+ colorpal.getValue() + ";"));
			
			colorpal.setValue("");
			
			colorpalT.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->
			colorpalT.setStyle("-fx-background-color: "+ colorpalT.getValue() + ";"));
			
			colorpalT.setValue("");
			
			colorpal1.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->
			colorpal1.setStyle("-fx-background-color: "+ colorpal1.getValue() + ";"));
			
			colorpal1.setValue("");
			
			colorpalT1.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->
			colorpalT1.setStyle("-fx-background-color: "+ colorpalT1.getValue() + ";"));
			
			colorpalT1.setValue("");
			
			// fill sleeves type choice box and set default
			for(int i = 0; i < sleevestype.length; i++) {
				
				sleevesheight.getItems().add(sleevestype[i]);
				sleevesheight1.getItems().add(sleevestype[i]);
				
			}
			
			sleevesheight.setValue("ANY");
			sleevesheight1.setValue("ANY");
			
			// fill pockets choice box and set default
			for(int i = 0; i < pocketsex.length; i++) {
				
				pocketsch.getItems().add(pocketsex[i]);
				pocketschT.getItems().add(pocketsex[i]);
				pocketsch1.getItems().add(pocketsex[i]);
				pocketschT1.getItems().add(pocketsex[i]);
				
			}
			
			pocketsch.setValue("ANY");
			pocketschT.setValue("ANY");
			pocketsch1.setValue("ANY");
			pocketschT1.setValue("ANY");
			
			// fill shirts height choice box and set default
			for(int i = 0; i < shirth.length; i++) {
				
				shirtsheight.getItems().add(shirth[i]);
				panttype.getItems().add(shirth[i]);
				shirtsheight1.getItems().add(shirth[i]);
				panttype1.getItems().add(shirth[i]);
				
			}
			
			shirtsheight.setValue("ANY");
			panttype.setValue("ANY");
			shirtsheight1.setValue("ANY");
			panttype1.setValue("ANY");
			
			//fill crotch choice box and set default
			for(int i = 0; i < crotchtype.length; i++) {
				
				crotch.getItems().add(crotchtype[i]);
				crotch1.getItems().add(crotchtype[i]);
				
			}
			
			crotch.setValue("ANY");
			crotch1.setValue("ANY");
			
			//fill pants lower part choice box
			for(int i = 0; i < pantslp.length; i++) {
				
				pantslowerpart.getItems().add(pantslp[i]);
				pantslowerpart1.getItems().add(pantslp[i]);
				
			}
			
			pantslowerpart.setValue("ANY");
			pantslowerpart1.setValue("ANY");
			
			// fill polo neck choice box and set default
			for(int i = 0; i < necktype.length; i++) {
				
				poloneck.getItems().add(necktype[i]);
				poloneck1.getItems().add(necktype[i]);
				
			}
			
			poloneck.setValue("ANY");
			poloneck1.setValue("ANY");
		}
	}
	
	//creates the panels of the generations and set the number for max generations
	public void createGen() {
		
		atome.getChildren().clear();
		
		if(initializeflag == false) {
			
			try {
				
				len = gennumber.getValue().intValue();
				chb = new ChoiceBox[len];
				ng = new Pane[len];
				ev = new int[len];
				
				if(filter1.isDisable() == false) {
					
					nt = new TShirtC[len];
					
				}else if(filter2.isDisable() == false) {
					
					ntr = new TrousersC[len];
					
				}
				
			}catch(Exception e) {
				
				len = 10;
				chb = new ChoiceBox[len];
				ng = new Pane[len];
				ev = new int[len];
				
				if(filter1.isDisable() == false) {
					
					nt = new TShirtC[len];
					
				}else if(filter2.isDisable() == false) {
					
					ntr = new TrousersC[len];
					
				}
				
			}
			
			try {
				
				mgen = maxgens.getValue().intValue();
				
			}catch(Exception e) {
				
				mgen = 10;
			}
		}
		
		for(int i = 0; i < len; i ++) {
			
			try {
				
				Pane pane = new Pane();
				pane.setId("atom" + i);
				pane.getStyleClass().add("atome");
				pane.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					
					public void handle(MouseEvent e) {
						
						String string = pane.getId();
						int num = Integer.parseInt(string.substring(string.length() - 1));
						int num1 = num + 1;
						selcetedcloth.setText("SELECTED CLOTHING :" + num1);
						
						if(filter1.isDisable() == false) {
							
							String cr = nt[num].statspane(nt[num]);
							chromosomes.setText(cr);
							
						}else if(filter1.isDisable() == true) {
							
							String cr = ntr[num].statspane(ntr[num]);
							chromosomes.setText(cr);
							
						}
						
						if(filter1.isDisable() == true && pantsbackside.isVisible() == false) {
							
							if(num < 4) {
								
								pantsbackside.setLayoutX(pane.getLayoutX() + 200 + 330);
								pantsbackside.setLayoutY(pane.getLayoutY());
								
							}else if(num == 4) {
								
								pantsbackside.setLayoutX(pane.getLayoutX() + 200 - 330);
								pantsbackside.setLayoutY(pane.getLayoutY());
								
							}else if(num < 9) {
								
								pantsbackside.setLayoutX(pane.getLayoutX() + 200 + 330);
								pantsbackside.setLayoutY(pane.getLayoutY());
								
							}else {
								
								pantsbackside.setLayoutX(pane.getLayoutX() + 200 - 330);
								pantsbackside.setLayoutY(pane.getLayoutY());
								
							}
							trouser.createBackTrousers(pane, pantsbackside, ntr[num]);
							pantsbackside.setVisible(true);
							
						}	
					}
				});
				pane.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					
					public void handle(MouseEvent e) {
						
						chromosomes.setText("");
						selcetedcloth.setText("SELECTED CLOTHING :");
						
						if(filter1.isDisable() == true) {
							
							pantsbackside.setVisible(false);
							pantsbackside.getChildren().clear();
							
						}	
					}
				});
				atome.getChildren().add(pane);
				ng[i] = pane;
				
				ChoiceBox<Object> cb = new ChoiceBox<Object>();
				cb.setId("ch" + i);
				cb.getStyleClass().add("rating");
				pane.getChildren().add(cb);
				chb[i] = cb;
				
			}catch(Exception e) {
				
				System.out.println(e);
				
			}	
		}
	}
	
	//creates the TShirtC for generation
	public void createGenT() {
			
		try {
				
			len = gennumber.getValue().intValue();
				
		}catch(Exception e) {
				
			len = 10;
				
		}
			
		for(int i = 0; i < len; i ++) {
				
			try {
					
				TShirtC nb = new TShirtC(null, 0, null, null, 0, null);
				nt[i] = nb;
			
			}catch(Exception e) {
					
				System.out.println(e);
				
			}	
		}
	}
	
	//creates the TrousersC for generation
	public void createGenTr() {
		
		try {
				
			len = gennumber.getValue().intValue();
				
		}catch(Exception e) {
				
			len = 10;
				
		}
			
		for(int i = 0; i < len; i ++) {
				
			try {
					
				TrousersC nb = new TrousersC(null, null, null, 0, null);
				ntr[i] = nb;
			
			}catch(Exception e) {
					
				System.out.println(e);
				
			}	
		}
	}	
	
	//min max button for the statistics panel 
	public void minmaxStatsPane() {
		
		if(StatsPane.isVisible() == false) {
			
			StatsPane.setVisible(true);
			sp.setVisible(true);
		}
		else {
			StatsPane.setVisible(false);
			sp.setVisible(false);
		}
	}
	
	//loads the options of the man menu
	public void LoadManSub() {
		
		sp.setStyle("-fx-focus-color: #D70026;");
		womansub.setVisible(false);
		all.setVisible(false);
		
		if(mansub.isVisible() == false) {
			
			mansub.setVisible(true);
		}else {
			mansub.setVisible(false);
			
		}
		
	}
	
	//loads the options of the woman menu
	public void LoadWomanSub() {
		
		sp.setStyle("-fx-focus-color: #D70026;");
		mansub.setVisible(false);
		all.setVisible(false);
		
		if(womansub.isVisible() == false) {
			
			womansub.setVisible(true);
		}else {
			womansub.setVisible(false);
		}
		
	}
	
	//loads all the options of the menu
	public void LoadAllSub() {
		
		sp.setStyle("-fx-focus-color: #D70026;");
		mansub.setVisible(false);
		womansub.setVisible(false);
		
		if(all.isVisible() == false) {
			
			all.setVisible(true);
		}else {
			all.setVisible(false);
		}
		
	}
	
	//fill the designs choice boxes
	@SuppressWarnings("unchecked")
	public void checkB() {
		
		if(chflag == false) {
			for(int j = 0; j < len; j ++) {
				for(int i = 0; i <=10; i++) {
			
					chb[j].getItems().add(i);
					
				}
			}
			
			chflag = true;
			
		}else {
			for(int j = 0; j < len; j ++) {
			
				chb[j].setValue(null);
					
			}
		}
	}
	
	//starts the initialisation
	public void loadPopulation(ActionEvent event){
		
		options.setDisable(true);
		
		if(filter1.isDisable() == false) {
			
			createGen();
			createGenT();
			cgen ++;
			gennum.setText("GENERATION NUM : " + cgen);
			
			if(this.initializeflag == false) {
				
				for(int i = 0; i < len; i++) {
					
					tshirt.createTshirt(ng[i], nt[i], chflag, colorpal.getValue(), sleevesheight.getValue(),
							shirtsheight.getValue(), poloneck.getValue(), pocketsch.getValue());
					nt[i].atome(nt[i], "atom " + i);
				}
				
	    		this.initializeflag = true;
			
			}
			
		}else if(filter2.isDisable() == false){
			
			createGen();
			createGenTr();
			cgen ++;
			gennum.setText("GENERATION NUM : " + cgen);
			
			if(this.initializeflag == false) {
				
				for(int i = 0; i < len; i++) {
					
					trouser.createTrouser(ng[i], ntr[i], chflag, colorpalT.getValue(), panttype.getValue(),
							pantslowerpart.getValue(), crotch.getValue(), pocketschT.getValue());
					ntr[i].atome(ntr[i], "atom " + i);
				}
				
	    		this.initializeflag = true;
			
			}
			
		}		

		SingleSelectionModel<Tab> selectionModel = tabM.getSelectionModel();
		
		if(generation.isDisabled() == true) {
				
			mansub.setVisible(false);
			womansub.setVisible(false);
			all.setVisible(false);
			checkB();
			selectionModel.select(0);
			generation.setDisable(false);
			buttons.setDisable(true);
			buttons1.setDisable(true);
			buttons2.setDisable(true);
			help.setText("Generation Board: Activated");
			pb.setProgress(1F);
			pb.setStyle("-fx-accent: #EDB83D;"); 
				
		}else {
				
			for(int i = 0; i < len; i++) {
					
				removeAll(ng[i]);
			
			}	
			selectionModel.select(1);
			generation.setDisable(true);
			buttons.setDisable(false);
			buttons1.setDisable(false);
			buttons2.setDisable(false);
			help.setText("Generation Board: Deactivated");
			pb.setProgress(0F);
			
			}
		
		
		}
	
	//next generation
    public void loadNewPopulation(ActionEvent event){
    	
    	cgen++;
    	gennum.setText("GENERATION NUM : " + cgen);
    	int dgen = mgen - cgen;
    	float sumfa = 0;
    	
    	switch (dgen) {
    	case 0:
    		try {
        		
    			//get and send ratings for evaluation 
    			for(int i = 0; i < len; i++) {
    			
    				ev[i] = (int) chb[i].getValue();
    				sumfa = sumfa + (int) chb[i].getValue();
    			
    			}
    			
    			System.out.println("sumfa :" + sumfa);
    			
    			fitnessavg = (fitnessavg + (sumfa/len)) / (cgen - 1);
    			fitavg.setText("FITNESS AVG : " + fitnessavg);
    			
    			if(sumfa == 0) {
    				
    				rating[0] = 0;
    				rating[1] = 1;
    				
    			}else {
    				
    				rating = eva.select(ev);
    				
    			}
        		
        	
        		help.setText("Generation Board: Evaluation completed");
        		pb.setProgress(0.25F);
        	
        		//remove old generation
        		createGen();
        		chflag = false;
        		checkB();
        		help.setText("Generation Board: Crossover and mutation in the process");
        		pb.setProgress(0.75F);
        		
        		if(filter1.isDisable() == false) {
        			
        			parents[0] = nt[rating[0]];
            		parents[1] = nt[rating[1]];   	
    			
    				newgen = cr.CrossoverTshirts(parents[0], parents[1]);
    			
    				for(int i = 0; i < len; i ++) {
    				
    					nt[i] = newgen[i];
    					nt[i].atome(nt[i], "sibling" + i);
    					tshirt.createTshirt(ng[i], nt[i], initializeflag, colorpal.getValue(), sleevesheight.getValue(), shirtsheight.getValue(), poloneck.getValue(), pocketsch.getValue());
    					nt[i].atome(nt[i], "atom " + i);
    				
    				} 
        		}else if(filter2.isDisable() == false) {
        			
        			parentsT[0] = ntr[rating[0]];
            		parentsT[1] = ntr[rating[1]];   	
    			
    				newgenT = cr.CrossoverTrousers(parentsT[0], parentsT[1]);
    			
    				for(int i = 0; i < len; i ++) {
    				
    					ntr[i] = newgenT[i];
    					ntr[i].atome(ntr[i], "sibling" + i);
    					trouser.createTrouser(ng[i], ntr[i], initializeflag, colorpalT.getValue(), panttype.getValue(), pantslowerpart.getValue(), crotch.getValue(), pocketschT.getValue());
    					nt[i].atome(nt[i], "atom " + i);
    				
    				} 
        			
        		}
        		       	
    		}catch(Exception e) {
        		
        		System.out.println("ProblemOnLoadGen" + e);
        		help.setText("Generation Board: Please evaluate the solutions");
        		notev.setVisible(true);
       		}
    		
    		help.setText("Generation Board: Maximum Generation Number");
    		pb.setProgress(1.0F);
    		newGen.setDisable(true);
    		notevp.setText("PLEASE SELECT FINAL GENERATION TO SAVE THE DESIGNS");
    		notev.setVisible(true);
    		break;
    		
    	default:
    		try {
    			
    			 sumfa = 0;
    			
    			//get and send ratings for evaluation 
    			for(int i = 0; i < len; i++) {
    			
    				ev[i] = (int) chb[i].getValue();
    				sumfa = sumfa + (int) chb[i].getValue();
    			}
    			
    			System.out.println("sumfa :" + sumfa);
    			
    			fitnessavg = (fitnessavg + (sumfa/len)) / (cgen - 1);
    			fitavg.setText("FITNESS AVG : " + fitnessavg);
    			
    			if(sumfa == 0) {
    				
    				rating[0] = 0;
    				rating[1] = 1;    				
    				
    			}else {
    				
    				rating = eva.select(ev);
    				
    			}
        	
        		help.setText("Generation Board: Evaluation completed");
        		pb.setProgress(0.25F);
        	
        		//remove old generation
        		createGen();
        		chflag = false;
        		checkB();
        		help.setText("Generation Board: Crossover and mutation in the process");
        		pb.setProgress(0.75F);
        		
        		if(filter1.isDisable() == false) {
        			
        			parents[0] = nt[rating[0]];
            		parents[1] = nt[rating[1]];   	
    			
    				newgen = cr.CrossoverTshirts(parents[0], parents[1]);
    				int[] urpass = new int[len];
    				
    				urpass = userPrefEvaluationShirt(newgen);
    				
    				for(int i = 0; i < len; i ++) {
    					
    					System.out.println("top rated: " + urpass[i]);
    					nt[i] = newgen[urpass[i]];
    					nt[i].atome(nt[i], "sibling" + i);
    					tshirt.createTshirt(ng[i], nt[i], initializeflag, colorpal.getValue(), sleevesheight.getValue(), shirtsheight.getValue(), poloneck.getValue(), pocketsch.getValue());
    					nt[i].atome(nt[i], "atom " + i);
    				}        			
        		}else if(filter2.isDisable() == false) {
        			
        			parentsT[0] = ntr[rating[0]];
            		parentsT[1] = ntr[rating[1]];   	
    			
    				newgenT = cr.CrossoverTrousers(parentsT[0], parentsT[1]);
    				int[] urpass = new int[len];
    				
    				urpass = userPrefEvaluationTrouser(newgenT);
    				
    				for(int i = 0; i < len; i ++) {
    					
    					System.out.println("top rated: " + urpass[i]);
    					ntr[i] = newgenT[urpass[i]];
    					ntr[i].atome(ntr[i], "sibling" + i);
    					trouser.createTrouser(ng[i], ntr[i], initializeflag, colorpalT.getValue(), panttype.getValue(), pantslowerpart.getValue(), crotch.getValue(), pocketschT.getValue());
    					ntr[i].atome(ntr[i], "atom " + i);
    				}
        		}
    		}catch(Exception e) {
        		
        		System.out.println("ProblemOnLoadGen" + e);
        		help.setText("Generation Board: Please evaluate the solutions");
        		notev.setVisible(true);
       		}
    		
    		break;
    	}	
    }
    
    public int[] userPrefEvaluationTrouser(TrousersC[] evgen) {
    	
    	int colortemp = 0;
    	int[] ur = new int[200];
    	int[] urpass = new int[len];
    	String option1 = panttype1.getValue();
    	String option2 = crotch1.getValue();
    	String option3 = pocketschT1.getValue();
    	String option4 = pantslowerpart1.getValue();
    	String option5 = colorpalT1.getValue();
    	
    	for(int i = 0; i < ur.length; i ++) {
    		
    		// check pants type users preference
    		//"LONG", "SHORT"
    		int[] pantstype = evgen[i].getPantshw();
    		
    		if(option1 == "LONG" && pantstype[0] > 60) {
    			
    			ur[i]++;
    			    	
    		}else if(option1 == "SHORT" && pantstype[0] > 60) {
    			
    			ur[i]++;
    			
    		}
    		
    		//check users preference in crotch
    		//"HIGH", "MIDDLE", "LOW"
    		if(option2 == "HIGH" && evgen[i].getCrotch() == 30) {
    			
    			ur[i]++;
    			
    		}else if(option2 == "MIDDLE" && evgen[i].getCrotch() > 30 && evgen[i].getCrotch() <= 39) {
    			
    			ur[i]++;
    		}else if(option2 == "LOW" && evgen[i].getCrotch() >= 40) {
    			
    			ur[i]++;
    		}
    		
    		// check pockets user preference
    		//"YES", "NO"
    		int[] pex = evgen[i].getPocketsT();
    		
    		if(option3 == "YES" && pex[0] == 0) {
    			
    			ur[i]++;
    			    	
    		}else if(option3 == "NO" && pex[0] == 1) {
    			
    			ur[i]++;
    			
    		}
    		
    		// check users preference in pants lower part
    		//"REGULAR", "WIDE"
    		int[] lpt = evgen[i].getPocketsT();
    		
    		if(option4 == "REGULAR" && lpt[0] == 0) {
    			
    			ur[i]++;
    			    	
    		}else if(option4 == "WIDE" && lpt[0] == 1) {
    			
    			ur[i]++;
    			
    		} 
    		
    		colortemp = TrousersC.evaluate(evgen[i], option5);
    		ur[i] = colortemp + ur[i];
    		
    	}
    	
    	urpass = universalSurviveNextGen(ur);
    	
    	for(int i = 0; i < len; i ++) {
    		
    		System.out.println("trouser :" + urpass[i]);
    			
    	}
    	
    	return urpass;
    	
	}
    
    public int[] userPrefEvaluationShirt(TShirtC[] evgen) {
    	
    	int colortemp = 0;
    	int[] ur = new int[200];
    	int[] urpass = new int[len];
    	String option1 = poloneck1.getValue();
    	String option2 = sleevesheight1.getValue();
    	String option3 = shirtsheight1.getValue();
    	String option4 = pocketsch1.getValue();
    	String option5 = colorpal1.getValue();
    	
    	for(int i = 0; i < ur.length; i ++) {
    		
    		// check neck users preference
    		//"ANY", "REGULAR", "POLO", "CREW", "FUNNEL","HIGH", "ROLL"
    		int poloneck = evgen[i].getPoloneck();
    		
    		if(option1 == "REGULAR" && poloneck == 0) {
    			
    			ur[i]++;
    			    	
    		}else if(option1 == "POLO" && poloneck == 1) {
    			
    			ur[i]++;
    			
    		}else if(option1 == "CREW" && poloneck == 2) {
    			
    			ur[i]++;
    			
    		}else if(option1 == "FUNNEL" && poloneck == 3) {
    			
    			ur[i]++;
    			
    		}else if(option1 == "HIGH" && poloneck == 4) {
    			
    			ur[i]++;
    			
    		}else if(option1 == "ROLL" && poloneck == 5) {
    			
    			ur[i]++;
    			
    		}
    		
    		// check sleeves user preference
    		//"ANY", "NO SLEEVES", "SHORT SLEEVES", "LONG SLEEVES", "3/4"
    		int[] slhw = evgen[i].getSleevehw();
    		
    		if(option2 == "NO SlEEVES" && slhw[0] == 0) {
    			
    			ur[i]++;
    			    	
    		}else if(option2 == "SHORT SLEEVES" && slhw[0] < 60 && slhw[0] > 0) {
    			
    			ur[i]++;
    			
    		}else if(option2 == "LONG SLEEVES" && slhw[0] > 60) {
    			
    			ur[i]++;
    			
    		}else if(option2 == "3/4" && slhw[0] == 60) {
    			
    			ur[i]++;
    			
    		}
    		
    		//check users preference in shirts height
    		//"LONG", "SHORT"
    		if(option3 == "SHORT" && evgen[i].getLowerpartheight() == 0) {
    			
    			ur[i]++;
    			
    		}else if(option3 == "LONG" && evgen[i].getLowerpartheight() > 0) {
    			
    			ur[i]++;
    		}
    		
    		// check pockets user preference
    		//"YES", "NO"
    		int[] pex = evgen[i].getPockets();
    		
    		if(option4 == "YES" && pex[0] == 0) {
    			
    			ur[i]++;
    			    	
    		}else if(option4 == "NO" && pex[0] == 1) {
    			
    			ur[i]++;
    			
    		}  
    		
    		colortemp = TShirtC.evaluate(evgen[i], option5);
    		ur[i] = colortemp + ur[i];
    	
    	
    	}
    	
    	urpass = universalSurviveNextGen(ur); 
    	
    	return urpass;
    	
	}
    
    public int[] universalSurviveNextGen(int[] gen) {
    	
    	int[][] ngen = new int[gen.length][2];
    	int[] high = new int[len];
    	int cnt = 0;
    	
    	for(int i = 0; i < gen.length; i ++) {
    		
    		ngen[i][1] = i;
    		ngen[i][0] = gen[i];
    			
    	}
    	
    	Arrays.sort(ngen, Comparator.comparingInt(o -> o[0]));
    	
    	
    	for(int i = gen.length - 1; i >= 0; i --) {
    		
    		if (ngen[i][0] > 0) {
    			
    			System.out.println(ngen[i][1] + "rating :" + ngen[i][0]);
    			
    		}  		
    		
    		if(cnt < len) {
    			
    			high[cnt] = ngen[i][1];
    			cnt ++;
    			
    		}
    			
    	}  	
    	
    	return high;
    }
    
    @SuppressWarnings("rawtypes")
    public void removeAll(Pane cpane) {
		
		ChoiceBox choiceBox = new ChoiceBox();
		choiceBox = (ChoiceBox) cpane.getChildren().get(0);
		cpane.getChildren().clear();
		cpane.getChildren().add(choiceBox);
		
	}
}
