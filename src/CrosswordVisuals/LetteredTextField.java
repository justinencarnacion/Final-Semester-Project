package CrosswordVisuals;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import CrosswordLogic.Word;

public class LetteredTextField extends JTextField {

    private String topRightCharacter;

    private Word wordObject;

    private ArrayList<String> verticalWords;
    private ArrayList<String> horizontalWords;

    CrosswordPanel fileReader = new CrosswordPanel();

    CrosswordPanel panel;

    CrosswordLayout layout;



    public LetteredTextField(String topRightCharacter) {
        this.topRightCharacter = topRightCharacter;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.drawRect(0, 0, this.getWidth() - 2, this.getHeight() - 2);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        graphics2D.drawString(topRightCharacter, 5, 20);

        graphics2D.dispose();
    }

    /*
    Step 1:
    - put the wordsFoundHorizontal into horizontalWords
    - put wordsFoundVertical into verticalWords

    Step 2:
    - Create 2 methods that adds the 1A, 1D (A for Across, D for down) at the start of the word



     */



}
