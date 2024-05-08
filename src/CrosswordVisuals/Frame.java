package CrosswordVisuals;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame () {
        setTitle("Word Search Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeUI();
    }

    public void initializeUI() {
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        add(boardPanel, BorderLayout.CENTER);

        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setText("Word Search Descriptions Go Here");
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.EAST);

        scrollPane.setPreferredSize(new Dimension(200, getHeight()));
    }

}