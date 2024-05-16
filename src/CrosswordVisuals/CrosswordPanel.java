package CrosswordVisuals;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CrosswordPanel extends JPanel {
    private JTextField[][] textFields;
    private char[][] data;


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
                    }
                    else {
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

    public String toString() {
        String s = "";
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                s += data[i][j];
            }
        }
        return s;
    }



    void setGreen() {  //WORK ON THIS PLEASE

    }

    /*public String wordsFound() { //UNFINISHED
        char[][] crossword = getCrossword();
        // Puts all words found horizontal and vertical
        ArrayList<String> wordsHFound = wordsFoundHorizontal(crossword);
        ArrayList<String> wordsVFound = wordsFoundVertical(crossword);


        String foundWords = "";
        for (String wordF : list) {
            for (String wordB : wordBank) {
                foundWords += wordF + ", ";
                setGreen(wordF);
            }
        }
        foundWords = foundWords.substring(0,foundWords.length()-2) + " is/are correct";
    }*/


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

    public void printArray(ArrayList<String> cw) { //method that prints all words found in array I was using for debugging
        for (int i = 0; i < cw.size(); i++) {
            System.out.println(cw.get(i));
        }
    }


    public char[][] getData() {
        return data;
    }
}