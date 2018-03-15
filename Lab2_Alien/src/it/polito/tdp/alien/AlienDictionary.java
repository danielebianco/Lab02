package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<WordEnhanced> wordList;

	public AlienDictionary() {
		this.wordList = new LinkedList<WordEnhanced>();
	}
	
	public void addWord(String alienWord, String translation) {
		for(WordEnhanced w : wordList) {
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())) {
				w.aggiungiTraduzione(translation); // qui aggiungo le diverse traduzioni alla lista
			}
		}
		WordEnhanced wtemp = new WordEnhanced(alienWord,translation);
		wordList.add(wtemp);
		if(!wtemp.getTraduzioni().contains(translation)) {
			wtemp.aggiungiTraduzione(translation);
		}
	}
	
	public String translateWord(String alienWord) {
		for(WordEnhanced w : wordList) {
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())) {
				return w.getTranslation();
			}
		}		
		return null;
	}
}
