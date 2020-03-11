package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	LinkedList<String> parole= new LinkedList<String>();
	
	public Parole() {
		//TODO
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}
	public void cancellaParola(String parola) {
		parole.remove(parola);
	}
}
