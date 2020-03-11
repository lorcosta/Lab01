package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole  elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtTime;

    @FXML
    void doCancella(ActionEvent event) {
    	
    	long start = System.nanoTime();
    	String selezionato = txtResult.getSelectedText();
    	if(selezionato==null) return;
    	elenco.cancellaParola(selezionato);
		txtParola.clear();    	
		String result = "";    	
		for(String s : elenco.getElenco()) {
			result += s + "\n";
		}    	
		txtResult.setText(result);
		long time = System.nanoTime()-start;
		txtTime.setText("Time LinkedList: "+time);
		
		start = System.nanoTime();
    	selezionato = txtResult.getSelectedText();
    	if(selezionato==null) return;
    	elenco.cancellaParolaA(selezionato);
		txtParola.clear();    	
		result = "";    	
		for(String s : elenco.getElencoA()) {
			result += s + "\n";
		}    	
		txtResult.setText(result);
		time = System.nanoTime()-start;
		txtTime.setText("Time ArrayList: "+time);
		    	
    }

    @FXML
    void doInsert(ActionEvent event) {
    	long start= System.nanoTime();
    	String parola= txtParola.getText();
    	if(parola.isBlank() || parola.isEmpty()) {
    		txtParola.setText("E' necessario aggiungere almeno una parola, premere Reset per inserire una nuova parola.");
    		return;
    	}
    	elenco.addParola(parola);
    	txtParola.clear();
    	String ritorno="";
    	for(String s: elenco.getElenco()) {
    		if(ritorno=="") ritorno+=s;
    		else ritorno+="\n"+s;
    	}  
    	txtResult.setText(ritorno);
    	long time= System.nanoTime()-start;
    	txtTime.setText("Time LinkedList: "+time);
    	
    	start= System.nanoTime();
    	parola= txtParola.getText();
    	if(parola.isBlank() || parola.isEmpty()) {
    		txtParola.setText("E' necessario aggiungere almeno una parola, premere Reset per inserire una nuova parola.");
    		return;
    	}
    	elenco.addParolaA(parola);
    	txtParola.clear();
    	ritorno="";
    	for(String s: elenco.getElencoA()) {
    		if(ritorno=="") ritorno+=s;
    		else ritorno+="\n"+s;
    	}  
    	txtResult.setText(ritorno);
    	time= System.nanoTime()-start;
    	txtTime.setText("Time ArrayList: "+time);
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	long start = System.nanoTime();
    	elenco.reset();
    	txtResult.clear();
    	long time = System.nanoTime()-start;
		txtTime.setText("Time LinkedList: "+time);
		
		start = System.nanoTime();
    	elenco.resetA();
    	txtResult.clear();
    	time = System.nanoTime()-start;
		txtTime.setText("Time ArrayList: "+time);
		
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        elenco = new Parole() ;
    }
}

