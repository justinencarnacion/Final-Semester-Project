package CrosswordVisuals;
import CrosswordLogic.Word;

import java.util.Scanner;
import java.io.*;

public class FileReader {

    private Scanner scan;

    private Word word = new Word();

    public void open(File file) {
        try {
            scan = new Scanner(file);
            //System.out.println("Yas it works");
        } catch (FileNotFoundException e) {
            //System.out.println("It did not work :(");
        }
    }

    public void read() {
        String line;
        String word;
        String description;
        this.word.getDescriptionList().clear();
        do {
            line = scan.nextLine();
            word = line.substring(0, line.indexOf(":"));
            description = line.substring(line.indexOf(":") + 2);
            this.word.addToDescriptionList(description);
            this.word.addToWordList(word);
        } while (scan.hasNext());
        //System.out.println(this.word.getDescriptionList());
        //System.out.println(this.word.getWordList());
        scan.close();
    }

    public Word getWord() {
        return word;
    }
}
