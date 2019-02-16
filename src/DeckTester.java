/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        String[] ranks = {"A", "B", "C"};
        String[] suits = {"Giraffes", "Lions","penguins"};
        int[] pointValues = {2, 1,6};
        Deck deck1 = new Deck(ranks, suits, pointValues);
        System.out.println(deck1.toString());
    }
}
