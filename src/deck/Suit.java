package deck;

/**
 * User: jitse
 * Date: 10/23/15
 * Time: 6:58 PM
 */
public enum Suit {
    DIAMOND(0), CLUB(1), HEART(2), SPADE(3);

    int value;

    Suit(int i) {
        value = i;
    }

    public static Suit fromValue(int i) {
        for (Suit s : values()) {
            if (s.value == i) {
                return s;
            }
        }

        return null;
    }
}
