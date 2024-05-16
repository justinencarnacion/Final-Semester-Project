package CrosswordVisuals;

import CrosswordLogic.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CrosswordLayout {

    private CrosswordPanel panel;
    private String layoutDirectory;
    private String fileLayout;
    private String levelDirectory;
    private String fileLevel;
    private String verticalDescription;

    private String horizontalDescription;

    private String finalOutput;
    char[][] cw;

    private CrosswordGUI GUI;

    private Word word = new Word();
    private Scanner scan;

   /** Creates the layout of the crossword panel 
    * @param crosswordGUI
    * @param panel
    * @param layoutDirectory
    * @param fileLayout
    * @param levelDirectory
     */ @param fileLevel
    public CrosswordLayout(CrosswordGUI crosswordGUI, CrosswordPanel panel, String layoutDirectory, String fileLayout, String levelDirectory, String fileLevel) {
        this.GUI = crosswordGUI;
        this.panel = panel;
        this.layoutDirectory = layoutDirectory;
        this.fileLayout = fileLayout;
        this.levelDirectory = levelDirectory;
        this.fileLevel = fileLevel;
        this.verticalDescription = "";
        this.horizontalDescription = "";
    }

     /**
     * Generates crossword based on specified level
     */
    public void generate() {
        File levelLayout = new File(layoutDirectory + "/" + fileLayout);
        File level = new File(levelDirectory + "/" + fileLevel);


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
            System.out.println("It did not work");
        }
        this.panel.setCrossword(cw);
        open(level);
        read();
        addHorizontalDescription();
        addVerticalDescription();
        finalOutput = verticalDescription + "\n\n\n\n\n" + horizontalDescription;
        GUI.getDescriptionArea().setText(finalOutput);


    }

    /** Opens file and creates Scanner object to read through file
    * @param file
    */
    public void open(File file) {
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            // System.out.println("It did not work :(");
        }
    }

    /**
    * Creates a lists of the words and a list of all the descriptions
    */
    public void read() {
        String line;
        String word;
        String description;
        this.word.getDescriptionList().clear();
        this.word.getWordList().clear();
        this.word.getFullList().clear();
        do {
            line = scan.nextLine();
            word = line.substring(0, line.indexOf(":"));
            description = line.substring(line.indexOf(":") + 2);
            this.word.addToDescriptionList(description);
            this.word.addToWordList(word);
            this.word.addToFullList(word, description);
        } while (scan.hasNext());
        System.out.println(this.word.getFullList());
        System.out.println();

        scan.close();
    }

     /**
     * Creates the description of a vertical word for the crossword
     */
    public void addVerticalDescription() {
        verticalDescription = "DOWN:\n";
        for (String str : panel.wordsFoundVertical(getCw())) {
            for (String value : this.word.getFullList()) {
                String beginning = value.substring(0, value.indexOf(":"));
                String end = value.substring(value.indexOf(":") + 1);
                if (str.equalsIgnoreCase(beginning)) {
                    verticalDescription += "- " + end + "\n\n ";
                }
            }
        }
        verticalDescription = verticalDescription.substring(0, verticalDescription.length() - 2);
    }

     /**
     * Creates the description of a horizontal word for the crossword
     */
    public void addHorizontalDescription() {
        horizontalDescription = "ACROSS:\n";
        for (String str : panel.wordsFoundHorizontal(getCw())) {
            for (String value : this.word.getFullList()) {
                String beginning = value.substring(0,value.indexOf(":"));
                String end = value.substring(value.indexOf(":")+1);
                if (str.equalsIgnoreCase(beginning)) {
                    horizontalDescription += "- " + end + "\n\n ";
                }
            }
        }
        horizontalDescription = horizontalDescription.substring(0,horizontalDescription.length()-2);
    }

  /**
     * Creates a 2D character array comprised of the characters that make up a crossword
     */
    public char[][] getCw() {
        return cw;
    }
}
