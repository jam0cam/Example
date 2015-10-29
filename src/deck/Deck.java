package deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: jitse
 * Date: 10/23/15
 * Time: 6:55 PM
 */
public class Deck {

    List<Card> deck;

    public Deck() {
        initializeDeck();
    }

    public void printDeck() {
        for (Card c : deck) {
            System.out.println(c.rank + " " + c.suit);
        }
    }

    public void shuffle() {
        Random rand = new Random();
        List<Card> newDeck = new ArrayList<>();

        for (int i=51; i>0; i--) {
            int idx = rand.nextInt(i);
            newDeck.add(deck.remove(idx));
        }

        newDeck.add(deck.remove(0));

        deck = newDeck;
    }

    private void initializeDeck() {
        deck = new ArrayList<>(52);
        for (int i=1; i<=13; i++) {
            for (int j=0; j<4; j++) {
                deck.add(new Card(Rank.fromValue(i), Suit.fromValue(j)));
            }
        }
    }

}
