package CrosswordVisuals;

import CrosswordLogic.Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class CrosswordGUI {

    private String w;
    private String description;

    private JTextArea descriptionArea = new JTextArea();

    private CrosswordLayout layout1;
    private CrosswordLayout layout2;
    private CrosswordLayout layout3;
    private CrosswordLayout layout4;
    private CrosswordLayout layout5;

    private CrosswordPanel panel;

    private Frame frame;

    private Word word;

    public JTextArea getDescriptionArea() {
        return descriptionArea;
    }

    // Creates the GUI comprised of the crossword panel and word bank 
    // @param none
    // @return none
    public void createAndShowGUI()
    {
        frame = new Frame(this);
        frame.createFrame();
        this.panel = frame.getPanel();
        layout1 = new CrosswordLayout(this, panel, "levelLayout", "levelOne", "level", "dOne");
        layout2 = new CrosswordLayout(this, panel, "levelLayout", "levelTwo", "level", "dTwo");
        layout3 = new CrosswordLayout(this, panel, "levelLayout", "levelThree", "level", "dThree");
        layout4 = new CrosswordLayout(this, panel, "levelLayout", "levelFour", "level", "dFour");
        layout5 = new CrosswordLayout(this, panel, "levelLayout", "levelFIve", "level", "dFive");

        // creates level 1 crossword frame
        frame.getLvl1Button().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                layout1.generate();
            }

        });

        // creates a level 2 crossword frame
        frame.getLvl2Button().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                layout2.generate();
            }

        });

        // creates the level 3 crossword frame
        frame.getLvl3Button().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                layout3.generate();
            }

        });

        // creates the level 4 crossword frame
        frame.getLvl4Button().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                layout4.generate();
            }

        });

        //creates the level 5 crossword frame
        frame.getLvl5Button().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                layout5.generate();
            }

        });


    }



}
