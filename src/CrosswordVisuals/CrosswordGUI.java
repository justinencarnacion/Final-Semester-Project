package CrosswordVisuals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public abstract class CrosswordGUI extends JFrame implements ActionListener{

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.getContentPane().setLayout(new BorderLayout());

        JPanel container = new JPanel(new FlowLayout());
        final CrosswordPanel panel = new CrosswordPanel();
        container.add(panel);
        f.getContentPane().add(container, BorderLayout.CENTER);

        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                generate(panel);
            }

            private void generate(CrosswordPanel panel) {
                // TODO Auto-generated method stub
                File file = new File("crosswordExample.txt");

                char[][] cw = null;

                try {

                    Scanner sc = new Scanner(file);
                    int w = sc.nextInt();
                    int h = sc.nextInt();
                    cw = new char[w][h];
                    for (int r = 0; r < w; r++) {
                        for (int c = 0; c < h; c++) {
                            if (sc.hasNext()) {
                                String str = sc.next();
                                cw[r][c] = str.charAt(0);
                            }
                        }
                    }
                    sc.close();
                }
                catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }

                panel.setCrossword(cw);


            }


        });
        f.getContentPane().add(generateButton, BorderLayout.SOUTH);

        f.setSize(800, 800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

}
