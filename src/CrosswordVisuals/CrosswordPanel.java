package CrosswordVisuals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CrosswordPanel extends JPanel {
    private static JTextField[][] textFields;
    private char[][] data;
    private ArrayList<Word> keyWords;

    public void setKey(ArrayList<Word> words) {
    	keyWords = words;
    }

    public void setCrossword(char[][] array) {
        data = array;
        removeAll();
        int w = array.length;
        int h = array[0].length;
        setLayout(new GridLayout(w, h));
        textFields = new JTextField[w][h];

        for (int x = 0; x < w; x++)
        {
            for (int y = 0; y < h; y++)
            {
                char c = array[x][y];
                if (c != '0')
                {

                    if (x == 0 && y == 2) {
                        textFields[x][y] = new LetteredTextField("1");
                    } else {
                        textFields[x][y] = new LetteredTextField("");
                    }
                    textFields[x][y].setPreferredSize(new Dimension(50, 50));
                    textFields[x][y].setFont(textFields[x][y].getFont().deriveFont(50.0f));
                    textFields[x][y].setDocument(new JTextFieldLimit(1));
                    add(textFields[x][y]);
                }
                else
                {
                    add(new JLabel());
                }
            }
        }
        getParent().validate();
        repaint();
    }

    public char[][] getCrossword() {
		int w = textFields.length;
        int h = textFields[0].length;
        char[][] crossword = new char[w][h];
        for (int x = 0; x < w; x++)
        {
            for (int y = 0; y < h; y++)
            {
                if (textFields[x][y] != null)
                {
                    String s = textFields[x][y].getText();
                    if (s.length() > 0)
                    {
                        crossword[x][y] = s.charAt(0);
                    } else {
                        crossword[x][y] = '0';
                    }

                } else {
                    crossword[x][y] = '0';
                }
            }
        }
        return crossword;
    }

    public void checkWords() {
    	if (textFields != null) {
    		ArrayList<Word> textWords = wordsFound(getCrossword());
        	
        	compare(textWords, keyWords);
    	}
    }
    
    public static void setGreen(Word word) {
        if (word.getIsVert()) {
            for (int x = word.getXPos(); x < word.getXPos() + word.getWordName().length(); x++) {
                textFields[x][word.getYPos()].setBackground(Color.green);
                textFields[x][word.getYPos()].setEditable(false);
            }
        } else {
            for (int y = word.getYPos(); y < word.getYPos() + word.getWordName().length(); y++) {
                textFields[word.getXPos()][y].setBackground(Color.green);
                textFields[word.getXPos()][y].setEditable(false);
            }
        }
    }
    
    public ArrayList<String> wordsFoundHorizontal(char[][] crossword){ //FINISHED
        ArrayList<String> wordList = new ArrayList<String>();
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
                    wordList.add(word);
                    j = k;
                } else {
                    j++;
                }
            }
        }
        return wordList;
    }

    public ArrayList<String> wordsFoundVertical(char[][] crossword){ //FINISHED
        ArrayList<String> wordList = new ArrayList<String>();
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
                    wordList.add(word);
                    j = k;
                } else {
                    j++;
                }
            }
        }
        return wordList;
    }
    
    public static ArrayList<Word> wordsFound(char[][] crossword){ //FINISHED
        ArrayList<Word> wordList = new ArrayList<Word>();
        for (int i = 0; i < crossword.length; i++) { //finds words horizontally
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
        for (int i = 0; i < crossword[0].length; i++) { //finds words vertically
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
    
    
    public void compare(ArrayList<Word> wordList, ArrayList<Word> answerList) { //NOT WORKING
    	for (Word tempWord : wordList) {
    		for (Word tempKey : answerList) {
    			if (tempWord.getWordName().equalsIgnoreCase(tempKey.getWordName()) && tempWord.getIsVert() == tempKey.getIsVert() && tempWord.getXPos() == tempKey.getXPos() && tempWord.getYPos() == tempKey.getYPos()) {
	    			setGreen(tempWord);
	    		}
    		}
    	}
    }

    public void printArray(ArrayList<Word> cw) { //method that prints all words found in array I was using for debugging
        for (int i = 0; i < cw.size(); i++) {
            System.out.println(cw.get(i).getWordName());
        }
    }

}
