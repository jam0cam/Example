package algorithm;

/**
 *
 * I suspect the online poker game I'm playing shuffles cards by doing a single "riffle."
 * To prove this, let's write a function to tell us if a full deck of cards shuffled_deck is a single riffle of
 * two other halves half1 and half2. We'll represent a stack of cards as a list of integers in the range
 * 1..52 (since there are 52 distinct cards in a deck).
 *
 * Why do I care? A single riffle is not a completely random shuffle. If I'm right, I can make more
 * informed bets and get rich and finally prove to my ex that I am not a "loser with an unhealthy cake
 * obsession" (even though it's too late now because she let me go and she's never getting me back).
 *
 * Time: O(n)
 * Space: O(1)
 *
 * Created by Jia on 12/2/16.
 */
public class SingleRiffleShuffle {

    public static void main(String[] args) {

    }

    public static boolean isSingleRiffleShuffle(int[] half1, int[] half2, int[] deck) {
        int ctrD, ctr1, ctr2;
        ctrD = ctr1 = ctr2 = 0;

        while (ctrD < 52) {
            int card = deck[ctrD];

            if (ctr1 < half1.length  && half1[ctr1] == card) {
                ctr1 ++;
                ctrD ++;
                continue;
            } else if (ctr2 < half2.length && half2[ctr2] == card) {
                ctr2 ++;
                ctrD ++;
                continue;
            }

            return false;
        }

        return true;
    }
}
