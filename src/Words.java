import java.awt.*;

import javax.swing.*;

public class Words extends JFrame {

    JPanel panel;
    JLabel label;

    public Words() {
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout( new FlowLayout() );
        label = new JLabel("Hello Swing!");
        add(label);
    }

    public static void main(String[] args) {
        // this will be our driver class

        JFrame frame = new JFrame("Test Frame");
        frame.setVisible(true);


    }

}
