package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<Word> wordList;

	public AlienDictionary() {
		this.wordList = new LinkedList<Word>();
	}
	
	public void addWord(String alienWord, String translation) {
		for(Word w : wordList) {
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())) {
				w.setTranslation(translation);
			}
		}
		wordList.add(new Word(alienWord,translation));
	}
	
	public String translateWord(String alienWord) {
		for(Word w : wordList) {
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())) {
				return w.getTranslation();
			}
		}		
		return null;
	}
}
