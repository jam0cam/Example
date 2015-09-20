/**
 * User: jitse
 * Date: 9/20/15
 * Time: 1:37 PM
 */
public class CoinChange {

    static int[][] table = new int[4][101];

    static int[] denominations = {1,5,10,25};

    public static void main(String[] args) {

//        System.out.println(makeChangeCareerCup(100, 25));
//        System.out.println(makeChangeUCF(100, 25));
        System.out.println(dynamicProgramming(100));
    }


    public static int dynamicProgramming(int n) {
        //there is only 1 way to make things if all we had are pennies
        for (int i=0; i<=n; i++) {
            table[0][i] = 1;
        }

        for (int j=1; j<4; j++) {   //this loops the different denominations.
            for (int i=0; i<=n; i++) {      //this loops through the amount we have to make change for

                //hard to explain, create a table and look at it. For j=1 (nickel), for anything less than
                //5 cents, we just copy the value down from j=0 (penny). The nickel has no effect for anything less than 5 cents.
                if (i < denominations[j]) {
                    table[j][i] = table[j-1][i];
                    continue;
                }

                //For example, j=1 (nickel), i = 11 cents. the number of ways to make 11 cents is equal to
                //the number of ways to make 11 cents without using nickel (table[j-1][i]) plus the number
                //of ways to 6 cents (table[j][i-denomination[j]).
                table[j][i] = table[j-1][i] + table[j][i-denominations[j]];
            }
        }
        return table[3][n];
    }

    public static int makeChangeUCF(int n, int denom) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else {
            int ways = 0;
            if (denom == 25) {
                ways +=makeChangeUCF(n - 25, 25);
                ways +=makeChangeUCF(n - 10, 10);
                ways +=makeChangeUCF(n - 5, 5);
                ways ++;
            } else if (denom == 10) {
                ways +=makeChangeUCF(n - 10, 10);
                ways +=makeChangeUCF(n - 5, 5);
                ways ++;
            } else if (denom == 5) {
                ways +=makeChangeUCF(n - 5, 5);
                ways ++;
            } else {
                ways ++;
            }

            return ways;
        }
    }

    public static int makeChangeCareerCup(int n, int denom) {
        int next_denom = 0;
        switch (denom) {
            case 25:
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }

        int ways = 0;
        for (int i=0; i*denom <= n; i++) {
            ways += makeChangeCareerCup(n - i * denom, next_denom);
        }

        return ways;
    }
}
