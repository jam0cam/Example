package deck;

/**
 * User: jitse
 * Date: 10/23/15
 * Time: 6:57 PM
 */
public class Card {
    public Rank rank;
    public Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
}
