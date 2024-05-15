package CrosswordVisuals;

import javax.swing.*;
import javax.swing.border.StrokeBorder;
import java.awt.*;

public class LetteredTextField extends JTextField {

    private String topRightCharacter;

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
}
