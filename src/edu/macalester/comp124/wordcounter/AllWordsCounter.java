package edu.macalester.comp124.wordcounter;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.Set;

/**
 * A counter that keeps track of counts for all words
 * 
 * @author shilad
 *
 */
public class AllWordsCounter {

    public static final int MAX_WORDS = 10000;

	// TODO: initialize instance variable to hold MAX_WORDS objects
    SingleWordCounter counters[] = new SingleWordCounter[MAX_WORDS];

    public int getNumWords() {
        // TODO: count the number of distinct words,
        // ie. the number of non-null counter objects.
        for (int i = 0; i < counters.length; i++ ) {
            if (counters[i] == null) {
                return (i);
            }
        }
        return -1;
    }
	
	/**
	 * Increment the count for the specified word.  Remember that this may
     * be the first time the word counter has seen this particular word.
	 * 
	 * @param word
	 */
	public void count(String word) {
        int n = getNumWords();
        for (int i = 0; i < n; i++) {
            // If you find the word increment the count and return
            if (counters[i].wordMatches(word)) {
                counters[i].incrementCount();
                return;
            }

        }
        int appendHere = getNumWords();
        SingleWordCounter newWord = new SingleWordCounter(word);
        newWord.incrementCount();
        counters[appendHere] = newWord;

        // You didn't find the word. Add a new word counter to the array.
        // Don't forget to increment the word's count to get it to 1!
	}
	
	/**
	 * Return the count for the particular word.  Remember that the
	 * word may not have been seen before.
	 * @param word
	 * @return
	 */
	public int getCount(String word) {
        // TODO: pattern this after the count() function.
        // Make sure to return 0 for words you haven't seen before.
        for (int i = 0; i < getNumWords(); i++) {
            // If you find the word increment the count and return //Shilad, I am not incrementing the count
            if (counters[i].wordMatches(word)) {
                return counters[i].getCount();
            }
        }
        return 0;
	}
	
	/**
	 * @return The an array of all words that have been counted
	 * (just the words, not the values).
	 */
	public String[] getAllWords() {
        // part one: create an array of strings of size equal to the number of words
        int n = getNumWords();
        String words[] = new String[n];  // FIXME //already did

        // part two: fill the array of strings using a loop
        for (int i = 0; i < n; i++) {
            words[i] = counters[i].getWord();
        }

        //return words;
        return words;
    }
}

