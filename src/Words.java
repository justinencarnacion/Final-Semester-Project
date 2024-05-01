import java.util.ArrayList;
import java.util.Scanner;


public class Words  {

    private String wordName;

    private String wordDescription;

    /**
     * if a word is connected, then there is one letter
     * in common, if there is one letter in common
     *
     */
    private boolean isConnected;




    private ArrayList<Words> wordBank = new ArrayList<Words>();

    /**
     *
     * @param wordName
     * @param wordDescription
     */
    public Words(String wordName, String wordDescription) {
        this.wordName = wordName;
        this.wordDescription = wordDescription;
    }

    /**
     *
     * @return
     */
    public String getWordName() {return wordName;}

    /**
     *
     * @param name
     */
    public void setName(String name) {this.wordName = name;}

    /**
     *
     * @return
     */
    public String getWordDescription() {return wordDescription;}

    /**
     *
     * @param description
     */
    public void setDescription(String description) {this.wordDescription = description;}

    /**
     *
     * @param words
     * @return
     */
    public void addWordToWordBank (Words words) {
        wordBank.add(words);
    }
    public void addMultipleWords(ArrayList<Words> newWords) {
        for (Words newWord : newWords) {
            addWordToWordBank(newWord);
        }
    }


    /**
     *
     * @return
     */
    public ArrayList<Words> getWordBank() {return wordBank;}

    /**
     * Checks to see if there are at least 2 connections
     * between word1 and word2
     * @param word1
     * @param word2
     * @return
     */
    public boolean isConnected(Words word1, Words word2) {
        String w1 = word1.getWordName();
        String w2 = word2.getWordName();
        for (int i = 0; i < w1.length() ; i++) {
            for (int j = 0; j < w2.length(); j++) {
                return (w2.substring(j, j+1).equals(w1.substring(i, i+1)));
            }
        }
        return false;
    }

    /**
     * Checks to see if the user inputted word equals the set word
     * in the Crossword cells, if this returns false, the cells will be highlighted
     * red
     * This method will be used in later class
     * @param userWord
     * @param word1
     * @return
     */
    public boolean isWordInBank(Words userWord, Words word1) {
        return (userWord.getWordName().toLowerCase().equals(word1.getWordName().toLowerCase()));
    }








}

