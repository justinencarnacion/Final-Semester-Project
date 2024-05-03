public class Puzzle extends Words {

    private final char[][] GRID = new char[10][10];

    private boolean canTypeInCell;

    /**
     * @param wordName
     * @param wordDescription
     */
    public Puzzle(String wordName, String wordDescription) {
        super(wordName, wordDescription);
    }

    public char[][] createPuzzle() {
        char[][] grid = GRID;
        return grid;
    }



    Words word1 = new Puzzle("Wallahi", "A saying that Arjun says");
    Words word2 = new Puzzle("Justin", "The team leader of this project");
    Words word3 = new Puzzle("Arjun", "The person who always studies calc in CS");
    Words word4 = new Puzzle("Zane", "The Brawler (a person who plays Brawl Stars)");






}
