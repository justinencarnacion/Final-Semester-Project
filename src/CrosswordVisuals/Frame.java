package CrosswordVisuals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {

    private JFrame f;
    private JPanel container;
    private JButton lvl1Button;
    private JButton lvl2Button;
    private JButton lvl3Button;
    private JButton lvl4Button;
    private JButton lvl5Button;
    private CrosswordPanel panel;

    private CrosswordGUI GUI;

    public Frame(CrosswordGUI GUI) {
        this.GUI = GUI;
    }

    public void createFrame() {


        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.getContentPane().setLayout(new BorderLayout());

        container = new JPanel(new FlowLayout());
        panel = new CrosswordPanel();
        container.add(panel);
        f.getContentPane().add(container, BorderLayout.CENTER);
        f.setResizable(false);

        JPanel btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton checkButton = new JButton("Check Words");
        checkButton.addActionListener(new ActionListener(){ //CALL TO checkWords
            public void actionPerformed(ActionEvent ae){
                //panel.checkWords();
            }
        });
        btnPnl.add(checkButton);

        lvl1Button = new JButton("Level 1");
        lvl2Button = new JButton("Level 2");
        lvl3Button = new JButton("Level 3");
        lvl4Button = new JButton("Level 4");
        lvl5Button = new JButton("Level 5");
        btnPnl.add(lvl1Button);
        btnPnl.add(lvl2Button);
        btnPnl.add(lvl3Button);
        btnPnl.add(lvl4Button);
        btnPnl.add(lvl5Button);
        btnPnl.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        f.getContentPane().add(btnPnl, BorderLayout.SOUTH);



        GUI.getDescriptionArea().setFont(GUI.getDescriptionArea().getFont().deriveFont(16f));
        GUI.getDescriptionArea().setText("Word Search Descriptions Go Here");
        GUI.getDescriptionArea().setEditable(false);
        GUI.getDescriptionArea().setLineWrap(true);
        GUI.getDescriptionArea().setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(GUI.getDescriptionArea());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        f.add(scrollPane, BorderLayout.EAST);

        scrollPane.setPreferredSize(new Dimension(200, f.getHeight()));

        f.setSize(800, 800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public CrosswordPanel getPanel() {
        return panel;
    }


    public JButton getLvl1Button(){return lvl1Button;}
    public JButton getLvl2Button(){return lvl2Button;}
    public JButton getLvl3Button(){return lvl3Button;}
    public JButton getLvl4Button(){return lvl4Button;}

    public JButton getLvl5Button(){return lvl5Button;}
}
