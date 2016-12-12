package algorithm;

/**
 *
 * Write an efficient function that takes stockPrices
 * Yesterday and returns the best profit I could have made from
 * 1 purchase and 1 sale of 1 Apple stock yesterday.
 *
 *   int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};
 *   getMaxProfit(stockPricesYesterday);
 *   //returns 6 (buying for $5 and selling for $11)
 *
 *
 * solution: http://stackoverflow.com/questions/7086464/maximum-single-sell-profit
 * https://www.interviewcake.com/question/java/stock-price
 *
 * Created by jitse on 1/6/16.
 */
public class StockPrices {
    static int[] prices;

    public static void main(String[] args) {
        prices = new int[] {10, 7, 5, 8, 11, 9};
        System.out.println(solve());        //6

        prices = new int[] {10, 7, 6, 100, 5, 8, 11, 9};
        System.out.println(solve());        //94


        prices = new int[] {5, 10, 4, 6, 7};
        System.out.println(solve());        //5


        prices = new int[] {5, 10, 4, 6, 12};
        System.out.println(solve());    //8

        prices = new int[] {1,2,3,4,5};
        System.out.println(solve());        //4
    }

    private static int solve() {
        //If we have just one element, we already know that it has to be the best buy/sell pair.
        //Now suppose we know the best answer for the first k elements and look at the (k+1)st element.
        // Then the only way that this value can create a solution better than what we had for the first
        // k elements is if the difference between the smallest of the first k elements and that new element
        // is bigger than the biggest difference we've computed so far.

        int maxProfitSoFar;
        int minSoFar;

        maxProfitSoFar = 0;
        minSoFar = prices[0];
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < minSoFar) {
                //this becomes the new min;
                minSoFar = prices[i];
            } else if (prices[i] - minSoFar > maxProfitSoFar) {
                maxProfitSoFar = prices[i] - minSoFar;
            }
        }

        return maxProfitSoFar;
    }
}
