/**
 * Given a price, say $0.63, What is the minimum number of coins needed to make up that amount. Using pennies, nickels, dimes, quarters
 * User: jitse
 * Date: 9/20/15
 * Time: 4:01 PM
 */
public class OptimalCoinChange {

    static int table[][];
    static int[] denom = {1,5,10,25};

    public static void main(String[] args) {
        System.out.println(getMin(99));
    }

    private static int getMin(int n) {
        table = new int[4][n+1];
        for (int i=0; i<=n; i++) {
            table[0][i] = i;
        }

        for (int j=1; j<4; j++) {
            for (int i=0; i<=n; i++) {
                if (i < denom[j]) {
                    table[j][i] = table[j-1][i];
                    continue;
                }

                table[j][i] = Math.min(table[j-1][i], table[j][i-denom[j]] + 1);
            }
        }

        return table [3][n];
    }
}
