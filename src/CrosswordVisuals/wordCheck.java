package CrosswordVisuals;

import CrosswordLogic.Word;

import java.util.ArrayList;

public class wordCheck {

		public static ArrayList<Word> wordsFound(char[][] crossword){ //FINISHED
	        ArrayList<Word> wordList = new ArrayList<Word>();
	        for (int i = 0; i < crossword.length; i++) {
	            int j = 0;
	            while (j < crossword[0].length) {
	                if ( j != crossword[0].length && crossword[i][j] != '0'){
	                    int k = j;
	                    String word = "";
	                    while (k != crossword[0].length && crossword[i][k] != '0') {
	                        word += crossword[i][k];
	                        k++;
	                    }
	                    wordList.add(new Word(word,i,j,false));
	                    j = k;
	                } else {
	                    j++;
	                }
	            }
	        }
	        for (int i = 0; i < crossword[0].length; i++) {
	            int j = 0;
	            while (j < crossword.length) {
	                if (j != crossword.length && crossword[j][i] != '0'){
	                    int k = j;
	                    String word = "";
	                    while (k != crossword.length && crossword[k][i] != '0') {
	                        word += crossword[k][i];
	                        k++;
	                    }
	                    wordList.add(new Word(word,j,i,true));
	                    j = k;
	                } else {
	                    j++;
	                }
	            }
	        }
	        return wordList;
	    }

		
	    public static String compare(ArrayList<Word> wordList, char[][] crosswordKey) {
	    	String wordsCorrect = "";
	    	ArrayList<Word> answerKey = wordsFound(crosswordKey);
	    	for (Word tempWord : wordList) {
	    		for (Word tempKey : answerKey) {
	    			if (tempWord.getWord().equals(tempKey.getWord()) && tempWord.getIsVert() == tempKey.getIsVert() && tempWord.getXPos() == tempKey.getXPos() && tempWord.getYPos() == tempKey.getYPos()) {
		    			wordsCorrect += tempWord.getWord() + ", ";
		    			//setGreen(tempWord);
		    		}
	    		}
	    	}
	    	wordsCorrect = wordsCorrect.substring(0, wordsCorrect.length() - 2) + " is/are correct";
	    	return wordsCorrect;
	    }

}
