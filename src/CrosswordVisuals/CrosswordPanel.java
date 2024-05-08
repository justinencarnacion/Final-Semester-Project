package CrosswordVisuals;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CrosswordPanel extends JPanel{
    private JTextField textFields[][];

    void setCrossword(char array[][])
    {
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
                if (c != 0)
                {
                    textFields[x][y] = new JTextField(String.valueOf(c));
                    textFields[x][y].setFont(textFields[x][y].getFont().deriveFont(20.0f));
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

    char[][] getCrossword()
    {
        int w = textFields.length;
        int h = textFields[0].length;
        char crossword[][] = new char[w][h];
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
                    }

                }
            }
        }
        return crossword;
    }
}

