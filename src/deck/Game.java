package deck;

/**
 * User: jitse
 * Date: 10/23/15
 * Time: 7:16 PM
 */
public class Game {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.printDeck();
        System.out.println("=================================");
        deck.shuffle();
        deck.printDeck();
    }
}
