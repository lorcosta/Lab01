package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	LinkedList<String> parole= new LinkedList<String>();
	ArrayList<String> paroleA;
	
	public Parole() {
		//TODO
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	public void addParolaA(String p) {
		paroleA.add(p);
	}
	public List<String> getElenco() {
		Collections.sort(parole);
		return parole;
	}
	public List<String> getElencoA() {
		Collections.sort(paroleA);
		return paroleA;
	}
	
	public void reset() {
		parole.clear();
	}
	public void resetA() {
		paroleA.clear();
	}
	
	public void cancellaParola(String parola) {
		parole.remove(parola);
	}
	public void cancellaParolaA(String parola) {
		paroleA.remove(parola);
	}
}
