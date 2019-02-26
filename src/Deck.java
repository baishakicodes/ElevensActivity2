/**
 * Created by Teacher on 1/7/2019.
 */
import com.sun.xml.internal.ws.client.sei.ValueSetter;

import java.util.List;
import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

    /**
     * cards contains all the cards in the deck.
     */
    private List<Card> cards;

    /**
     * size is the number of not-yet-dealt cards.
     * Cards are dealt from the top (highest index) down.
     * The next card to be dealt is at size - 1.
     */
    private int size;


    /**
     * Creates a new <code>Deck</code> instance.<BR>
     * It pairs each element of ranks with each element of suits,
     * and produces one of the corresponding card.
     * @param ranks is an array containing all of the card ranks.
     * @param suits is an array containing all of the card suits.
     * @param values is an array containing all of the card point values.
     */
    public Deck(String[] ranks, String[] suits, int[] values) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        this.cards = new ArrayList<Card>();
        int suitsNum = 0;
        int ranksNum = 0;
        int pointsNum = 0;
        for(int i=0; i<(ranks.length*suits.length); i++) {
            if (ranksNum==ranks.length && pointsNum== values.length) {
                ranksNum = 0;
                pointsNum = 0;
                suitsNum++;
            }
            cards.add(new Card(ranks[ranksNum], suits[suitsNum], values[pointsNum]));
            ranksNum++;
            pointsNum++;

        }
        size = cards.size();
        this.shuffle();
    }



    /**
     * Determines if this deck is empty (no undealt cards).
     * @return true if this deck is empty, false otherwise.
     */
    public boolean isEmpty() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        if(size==0){
            return true;
        }
        return false;
    }

    /**
     * Accesses the number of undealt cards in this deck.
     * @return the number of undealt cards in this deck.
     */
    public int size() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        return cards.size()-1;

    }

    /**
     * Randomly permute the given collection of cards
     * and reset the size to represent the entire deck.
     */
    public void shuffle() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */

        //I know K is supposed to start at 51 but I'm testing this out on a smaller deck of cards so
        //I made k start at size-1 to test, I 'll change it later when we make a real deck of 52 cards
        for(int k =size-1; k>0; k--){
            int r = (int) (Math.random()*k+1);
            Card temp = cards.get(k);
            cards.set(k, cards.get(r));
            cards.set(r, temp);

        }

    }

    /**
     * Deals a card from this deck.
     * @return the card just dealt, or null if all the cards have been
     *         previously dealt.
     */
    public Card deal() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
       if(this.isEmpty()!=true) {
           size--;
           return cards.get(size);
       }
       return null;
    }

    /**
     * Generates and returns a string representation of this deck.
     * @return a string representation of this deck.
     */
    @Override
    public String toString() {
        String rtn = "size = " + size + "\nUndealt cards: \n";

        for (int k = size - 1; k >= 0; k--) {
            rtn = rtn + cards.get(k);
            if (k != 0) {
                rtn = rtn + ", ";
            }
            if ((size - k) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\nDealt cards: \n";
        for (int k = cards.size() - 1; k >= size; k--) {
            rtn = rtn + cards.get(k);
            if (k != size) {
                rtn = rtn + ", ";
            }
            if ((k - cards.size()) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\n";
        return rtn;
    }
}
