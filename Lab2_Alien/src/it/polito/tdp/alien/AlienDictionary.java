package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<WordEnhanced> wordList;
	private List<String> alWord;

	public AlienDictionary() {
		this.wordList = new LinkedList<WordEnhanced>();
		this.alWord = new LinkedList<String>();
	}

	public List<String> getAlWord() {
		return alWord;
	}
	
	public void addWord(String alienWord, String translation) {
		for(WordEnhanced w : wordList) {
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())) {
				alWord.add(alienWord);
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
