package CrosswordVisuals;

import CrosswordLogic.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CrosswordLayout {

    private CrosswordPanel panel;
    private String layoutDirectory;
    private String fileLayout;
    private String levelDirectory;
    private String fileLevel;
    private String description;

    private String word;

    private CrosswordGUI GUI;

    private FileReader fileReader = new FileReader();

    Word w = new Word();

    public CrosswordLayout(CrosswordGUI crosswordGUI, CrosswordPanel panel, String layoutDirectory, String fileLayout, String levelDirectory, String fileLevel) {
        this.GUI = crosswordGUI;
        this.panel = panel;
        this.layoutDirectory = layoutDirectory;
        this.fileLayout = fileLayout;
        this.levelDirectory = levelDirectory;
        this.fileLevel = fileLevel;
        this.description = "";
        this.word = "";
    }

    public void generate() {
        File levelLayout = new File(layoutDirectory + "/" + fileLayout);
        File level = new File(levelDirectory + "/" + fileLevel);
        char[][] cw = null;

        try {
            Scanner sc = new Scanner(levelLayout);
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
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        panel.setCrossword(cw);
        fileReader.open(level);
        fileReader.read();
        description = "";
        for (String str : fileReader.getWord().getDescriptionList()) {
            description += str + "\n" + "\n";
        }
        GUI.getDescriptionArea().setText(description);
    }
    
}
