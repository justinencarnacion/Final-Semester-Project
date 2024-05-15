package CrosswordVisuals;

import CrosswordLogic.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TestJSwing implements ActionListener {
    private Word w = new Word();

    private JTextField t1 = new JTextField(50);
    private JTextField t2 = new JTextField(50);

    private JFrame f = new JFrame("Testing");

    private JButton B = new JButton("View");

    private String word = "";

    private String description = "";


    public TestJSwing() {
        f.setSize(800,800);
        f.setLocationRelativeTo(null);
        f.add(new JLabel("Word"));
        t1.setEditable(false);
        f.add(t1);

        f.add(new JLabel("Description"));
        t2.setEditable(false);
        f.add(t2);

        B.addActionListener(this);
        f.add(B);


        f.setLayout(new FlowLayout());
        f.setSize(500,500);
        f.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == B) {
            for (String s : w.getWordList()) {
                word += s + "\n";
                t1.setText(word);
            }

            for (String s : w.getDescriptionList()) {
                description += s + "\n";
                t2.setText(description);
            }
        }
    }



}
