import CrosswordVisuals.CrosswordGUI;
import CrosswordVisuals.CrosswordPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        char[][] cw = { {'A','P','P','L','E'},
                        {'P','A','P','L','E'}, 
                        {'P','P','A','L','E'},
                        {'L','P','P','L','E'},
                        {'E','P','P','L','E'} };
        System.out.println(CrosswordPanel.wordsFoundVertical(cw));

        CrosswordGUI GUI = new CrosswordGUI();
        GUI.createAndShowGUI();

        
    }
}