package CrosswordLogic;

import java.util.ArrayList;

public class Word {

    private String wordName;

    private String wordDescription;

    private boolean isConnected;

    private ArrayList<String> wordList = new ArrayList<String>();
    private ArrayList<String> descriptionList = new ArrayList<String>();

    private ArrayList<String> fullList = new ArrayList<String>();

    private ArrayList<Word> wordBank = new ArrayList<Word>();


    public Word() {
    }

    public void setName(String name) {
        this.wordName = name;
    }

    public void setDescription(String description) {
        this.wordDescription = description;
    }

    /**
     * @return
     */
    public String getWordName() {
        return wordName;
    }


    public String getWordDescription() {
        return wordDescription;
    }

    public void addToWordBank() {
        wordBank.add(this);
    }

    public void addToWordList(String word) {
        wordList.add(word);
    }

    public void addToDescriptionList(String description) {
        descriptionList.add(description);
    }

    public void addToFullList(String word, String description) {
        String s = "";
        s+= word + ":" + description;
        fullList.add(s);
    }

    public String getWordBanktoString() {
        String a = "[";
        for (Word w : wordBank) {
            a += w.getWordName() + ":" + w.getWordDescription() + ", ";
        }
        return (a.substring(0, a.length() - 2) + "]");

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


    public Word getWord() {
        return this;
    }

}