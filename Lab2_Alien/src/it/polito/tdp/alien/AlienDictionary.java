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
		if(!wtemp.getTraduzioni().contains(translation)) {
			wtemp.aggiungiTraduzione(translation);
		}
		wordList.add(wtemp);
	}
	
	public List<String> translateWord(String alienWord) {
		for(WordEnhanced w : wordList) {
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())) {
				return w.getTraduzioni();
			}
		}		
		return null;
	}
}
