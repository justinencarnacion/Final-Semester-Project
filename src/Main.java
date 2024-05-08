import CrosswordVisuals.Frame;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Word word1 = new Word("", "Something that Arjun says");
        Word word2 = new Word("Zane", "Daddy ice bear");
        Word word3 = new Word("Arjun", "He is a Rutgers commit");
        Word word4 = new Word("Mr. Vu", "My math teacher");

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);

        for (Word w : words) {
            w.addToWordBank();
            w.addToWordList();
            w.addToDescriptionList();
        }

        System.out.println(word1.compareLettersTo("Hi"));
        System.out.println(word2.compareLettersTo(word4.getWordName()));

        SwingUtilities.invokeLater(() -> {
            Frame frame = new Frame();
            frame.setVisible(true);
        });










    }
}