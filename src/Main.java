import CrosswordVisuals.CrosswordGUI;
import CrosswordVisuals.CrosswordPanel;

import javax.swing.*;

public class Main {
     /**
     * Main method in charge of implementing
     * the methods that create and display the GUI
     */
    public static void main(String[] args)
    {
        char[][] cw = { {'A','P','P','L','E'},
                        {'P','A','P','L','E'}, 
                        {'P','P','A','L','E'},
                        {'L','P','P','L','E'},
                        {'E','P','P','L','E'} };

        CrosswordPanel c = new CrosswordPanel();
        System.out.println(c.wordsFoundHorizontal(cw));

        CrosswordGUI GUI = new CrosswordGUI();
        GUI.createAndShowGUI();

        
    }
}
