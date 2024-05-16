import java.util.ArrayList;

public class Word {

    private String wordName;

    private String wordDescription;
<<<<<<< Updated upstream
    
    private int xPos;
    
	private int yPos;
	
	private boolean isVertical;
=======

    private int xPos;

    private int yPos;

    private boolean isVertical;
>>>>>>> Stashed changes

    private ArrayList<String> wordList = new ArrayList<String>();
    private ArrayList<String> descriptionList = new ArrayList<String>();
    private ArrayList<String> fullList = new ArrayList<String>();
    
    private ArrayList<Word> wordBank = new ArrayList<Word>();

<<<<<<< Updated upstream

    public Word(String w, int xP, int yP, boolean isVert) {
		wordName = w;
		xPos = xP;
		yPos = yP;
		isVertical = isVert;
	}

	public Word() {
		// TODO Auto-generated constructor stub
	}
=======
    /**
     * default constructor
     */
    public Word() {
    }

    
    public Word(String w, int xP, int yP, boolean isVert) {
        wordName = w;
        xPos = xP;
        yPos = yP;
        isVertical = isVert;
    }

      /**
     * Returns x position of word
     * @return xPos
     */
    public int getXPos() {
        return xPos;
    }

        /**
     * Returns y position of word
     * @return yPos
     */
    public int getYPos() {
        return yPos; 
    }

      /**
     * Returns whether or not the word entered is vertical
     * @return xPos
     */
    public boolean getIsVert() {
        return isVertical;
    }

       /**
     * Sets the name of the word
     * @param name
     */
    public void setName(String name) {
        this.wordName = name;
    }

      /**
     * Sets the description of the word
     * @param description
     */
    public void setDescription(String description) {
        this.wordDescription = description;
    }
>>>>>>> Stashed changes

     /**
     * Returns the x position of a word
     * @return xPos
     */
	public int getXPos() {
		return xPos;
	}

    
     /**
     * Returns the y position of a word
     * @return yPos
     */
	public int getYPos() {
		return yPos;
	}

	
     /**
     * Returns whether or not the word entered is vertical
     * @return isVertical
     */
	public boolean getIsVert() {
		return isVertical;
	}
    
    /**
     *
<<<<<<< Updated upstream
     * @return
=======
     * @return wordName
>>>>>>> Stashed changes
     */
    public String getWordName() {
    	return wordName;
    }

    /**
     *
<<<<<<< Updated upstream
     * @param name
     */
    public void setName(String name) {
    	this.wordName = name;
    }

    /**
     *
     * @return
=======
     * @return wordDescription
>>>>>>> Stashed changes
     */
    public String getWordDescription() {
    	return wordDescription;
    }

    /**
<<<<<<< Updated upstream
     *
     * @param description
     */
    public void setDescription(String description) {
    	this.wordDescription = description;
    }

    /**
     * adds a word to the word bank
     * @param word
     */
    public void addToWordBank (Word word) {
        wordBank.add(word);
    }

     /**
     * adds a word to the word list
     * @param word
     */
    public void addToWordList (String word) {
        wordList.add(word);
    }

     /**
     * adds a description to the description list
     * @param description
     */
    public void addToDescriptionList (String description) {
        descriptionList.add(description);
    }
    
=======
     /* adds this word to wordBank
     * @param word
     */
    public void addToWordBank(Word word) {
        wordBank.add(word);
    }

    /**
     * adds this String word to wordList
     * @param word
     */
    public void addToWordList(String word) {
        wordList.add(word);
    }

    /**
     * adds this String description to descriptionList
     * @param description
     */
    public void addToDescriptionList(String description) {
        descriptionList.add(description);
    }

    /**
     * gets wordList
     * @return wordList
     */
    public ArrayList<String> getWordList() {
        return wordList;
    }

    /**
     * gets descriptionList
     * @return descriptionList
     */
    public ArrayList<String> getDescriptionList() {
        return descriptionList;
    }

    /**
     * gets the fullList
     * @return fullList
     */
    public ArrayList<String> getFullList() {
        return fullList;
    }

    /**
     * gets the wordBank of type Word
     * @return wordBank
     */
    public ArrayList<Word> getWordBankList(){
        return wordBank;
    }

    /**
     * returns this String word
     * @return word
     */
    public String getWord() {
        return wordName;
    }

    /**
     * adds both the word AND description to another ArrayList that holds
     * both description and words,
     * @param word
     * @param description
     */
>>>>>>> Stashed changes
    public void addToFullList(String word, String description) {
        String s = "";
        s+= word + ":" + description;
        fullList.add(s);
    }

<<<<<<< Updated upstream
    /**
     *Returns wordbank contents as a string
     * @return a.substring(0,a.length()-2)= "]"
     */
    public String getWordBankToString() {
        String a = "[";
        for (Word w : wordBank ) {
            a+= w.getWordName() + ":" + w.getWordDescription() + ", ";
        }
        return (a.substring(0,a.length()-2) + "]");

    }
    public ArrayList<String> getWordList() {
        return wordList;
    }
    public ArrayList<String> getDescriptionList() {
        return descriptionList;
    }
    public ArrayList<String> getFullList() {
        return fullList;
    }
    public ArrayList<Word> getWordBankList(){
    	return wordBank;
    }
=======

>>>>>>> Stashed changes

    public int compareTo(Word actualWord) {
        return this.getWordName().compareTo(actualWord.getWordName());
    }

    /**
     * Pre-Condition: actual word is a word with length > 0
     * @param actualWord
     * @return -1
     * @return 1
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
