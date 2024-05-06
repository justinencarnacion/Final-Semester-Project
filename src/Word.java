import java.util.ArrayList;


public class Word {

    private String wordName;

    private String wordDescription;

    private boolean isConnected;

    private static ArrayList<String> wordList = new ArrayList<String>();
    private static ArrayList<String> descriptionList = new ArrayList<String>();

    private static ArrayList<Word> wordBank = new ArrayList<Word>();


    public Word() {
        this.wordName = "empty name";
        this.wordDescription = "empty desc";
    }

    public Word(String name) {
        this.wordName = name;
        this.wordDescription = "empty desc";
    }
    /**
     *
     * @param wordName
     * @param wordDescription
     */
    public Word(String wordName, String wordDescription) {
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
     */
    public void addToWordBank () {
        wordBank.add(this);
    }
    public void addToWordList () {
        wordList.add(this.getWordName());
    }
    public void addToDescriptionList () {
        descriptionList.add(this.getWordDescription());
    }

    /**
     *
     * @return
     */
    public static String getWordBank() {
        String a = "[";
        for (Word w : wordBank ) {
            a+= w.getWordName() + ":" + w.getWordDescription() + ", ";
        }
        return (a.substring(0,a.length()-2) + "]");

    }
    public static ArrayList<String> getWordList() {
        ArrayList<String> returnList = new ArrayList<String>();
        for (String name : wordList ) {
            returnList.add(name);
        }
        return returnList;
    }
    public static ArrayList<String> getDescriptionList() {
        ArrayList<String> returnList = new ArrayList<String>();
        for (String description : descriptionList ) {
            returnList.add(description);
        }
        return returnList;
    }

    /**
     * Checks to see if there are at least 2 connections
     * between word1 and word2
     * @param word1
     * @param word2
     * @return
     */
    public boolean isConnected(Word word1, Word word2) {
        String w1 = word1.getWordName();
        String w2 = word2.getWordName();
        for (int i = 0; i < w1.length() ; i++) {
            for (int j = 0; j < w2.length(); j++) {
                return (w2.substring(j, j+1).equals(w1.substring(i, i+1)));
            }
        }
        return false;
    }

    public int compareTo(Word actualWord) {
        return this.getWordName().compareTo(actualWord.getWordName());
    }

    /**
     * Pre-Condition: actual word is a word with length > 0
     * @param actualWord
     * @return
     */
    public int compareLettersTo(String actualWord) {
        if (this.getWordName().length() == 0) return -99;
        for (int i = 0; i < this.getWordName().length(); i++) {
            char userLetter = this.getWordName().toLowerCase().charAt(i);
            char actualLetter = actualWord.toLowerCase().charAt(i);

            if (userLetter != actualLetter ) return -1;

        }
        return 1;

    }

}

