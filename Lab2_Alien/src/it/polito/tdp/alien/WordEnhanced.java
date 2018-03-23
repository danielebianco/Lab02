package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
	private String translation;
	private List<String> traduzioni;
	
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
		this.traduzioni = new LinkedList<String>();
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
			
	public List<String> getTraduzioni() {
		return traduzioni;
	}
	
	public void aggiungiTraduzione(String traduzione) {
		this.traduzioni.add(traduzione);
	}
		
	public boolean equals(Object obj) {
		if (this.alienWord.equals(obj))
			return true;
		return false;		
	}

}
