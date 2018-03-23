package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    AlienDictionary ad = new AlienDictionary();
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String inserita = txtWord.getText();
    	boolean ok = false;
    	
    	if(inserita.contains(" ")) {
    		String[] inserite = inserita.split(" ");
    		if (inserite[0].matches("[a-zA-Z]*") && inserite[1].matches("[a-zA-Z]*")) {
    			txtResult.appendText("\nNuovo inserimento:\n"
    						+"Alien word: "+ inserite[0] + " " +"Traduzione: "+ inserite[1]);
    			ad.addWord(inserite[0], inserite[1]);
    			ok = true;
    		}
    	}	
		
		if(!inserita.contains(" ") && inserita.matches("[a-zA-Z]*")){
			List<String>  list = ad.translateWord(inserita);
				for(String s : list) {
					txtResult.appendText("\n"+s);
				}
			ok = true;
		}
		
		if(inserita.matches("[a-zA-Z?]*")) {
			String[] insert = inserita.split("?");
			for(String s : ad.getAlWord()) {
				if(s.contains(insert[0]) && s.contains(insert[1])) {
					List<String>  list = ad.translateWord(inserita);
					for(String sx : list) {
						txtResult.appendText("\n"+sx);
					}
				}
			}ok = true;
		}
		
		if (ok == false && !inserita.matches("[a-zA-Z]*")) {
			txtResult.appendText("\nAttenzione! Formato non riconosciuto.");
		}
				
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtResult.appendText("Welcome to Alien Dictionary v2016.");
    }
    
}
