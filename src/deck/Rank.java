package deck;

/**
 * User: jitse
 * Date: 10/23/15
 * Time: 6:58 PM
 */
public enum Rank {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    int value;

    Rank(int i) {
        this.value = i;
    }

    public static Rank fromValue(int i) {
        for (Rank r : values()) {
            if (r.value == i) {
                return r;
            }
        }

        return null;
    }
}
