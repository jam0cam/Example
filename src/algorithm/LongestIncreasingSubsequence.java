package algorithm;

/**
 *
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given
 * sequence such that all elements of the subsequence are sorted in increasing order. For example,
 * the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 *
 * Time: O(n^2)
 * Space: O(n)
 * Created by Jia on 2/13/17.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        int[] array = new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println("LIS 6:" + solve(array));

        array = new int[] {3, 10, 2, 1, 20};
        System.out.println("LIS 3:" + solve(array));

        array = new int[] {3, 2};
        System.out.println("LIS 1:" + solve(array));

        array = new int[] {50, 3, 10, 7, 40, 80};
        System.out.println("LIS 4:" + solve(array));

        array = new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println("LIS 6:" + solve(array));

    }

    /**
     * The idea is that at a given index i, we want to see how the value at array[i] can help increase LIS values
     * that are before index i;
     *
     * Example: {10, 22, 9, 33, 21, 50, 41, 60, 80}.  At index i=3, (array[i] = 33), it has to look at LIS values
     * for 10, 22, 9, and see if adding 33 to it will help increase the LIS. Take the max that it can help extend
     * @param array
     * @return
     */
    private static int solve(int[] array) {
        int rval;
        int[] lis = new int[array.length];

        //initialize everything to 1, because the minimum subsequence is itself.
        for (int i=0; i<array.length; i++) {
            lis[i] = 1;
        }

        //loops through the array
        for (int i=1; i<array.length; i++) {
            int currentNumber = array[i];

            //loops to see all the LIS values before index i
            for (int j=0; j<i; j++) {
                //the current number can extend the sequence ending at array[j] to create a bigger LIS value
                if (currentNumber > array[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        //find the max LIS value;
        int max=lis[0];
        for (int i=0; i<lis.length; i++) {
            if (lis[i] > max) {
                max = lis[i];
            }
        }

        return max;
    }
}
