import java.util.ArrayList;

public class Word {

    private String wordName;

    private String wordDescription;
    
    private int xPos;
    
	private int yPos;
	
	private boolean isVertical;

    private ArrayList<String> wordList = new ArrayList<String>();
    private ArrayList<String> descriptionList = new ArrayList<String>();
    private ArrayList<String> fullList = new ArrayList<String>();
    
    private ArrayList<Word> wordBank = new ArrayList<Word>();


    public Word(String w, int xP, int yP, boolean isVert) {
		wordName = w;
		xPos = xP;
		yPos = yP;
		isVertical = isVert;
	}

	public Word() {
		// TODO Auto-generated constructor stub
	}

	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public boolean getIsVert() {
		return isVertical;
	}
    
    /**
     *
     * @return
     */
    public String getWordName() {
    	return wordName;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
    	this.wordName = name;
    }

    /**
     *
     * @return
     */
    public String getWordDescription() {
    	return wordDescription;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
    	this.wordDescription = description;
    }

    /**
     *
     */
    public void addToWordBank (Word word) {
        wordBank.add(word);
    }
    
    public void addToWordList (String word) {
        wordList.add(word);
    }
    
    public void addToDescriptionList (String description) {
        descriptionList.add(description);
    }
    
    public void addToFullList(String word, String description) {
        String s = "";
        s+= word + ":" + description;
        fullList.add(s);
    }

    /**
     *
     * @return
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
