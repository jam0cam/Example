/**
 *
 * You are given an array of integers (both positive and negative). Find the continuous sequence with the largest sum. Return the sum.
 * EXAMPLE
 * Input: {2, -8, 3, -2, 4, -10}
 * Output: 5 (i.e., {3, -2, 4} )

 * User: jitse
 * Date: 9/22/15
 * Time: 6:14 PM
 */
public class ContiguousSum {

    private static int[] numbers;

    public static void main(String[] args) {
        numbers = new int[] {2, -8, 3, -2, 4, -10};
        System.out.println("contiguous sequence with maximum sum: " + findSum());

        numbers = new int[] {-10, 5, 3, 2, -11, 8, 15};
        System.out.println("contiguous sequence with maximum sum: " + findSum());

        numbers = new int[] {-10, 5, 3, 2, -9, 8, 15};
        System.out.println("contiguous sequence with maximum sum: " + findSum());

        numbers = new int[] {-3, -10, -5};
        System.out.println("contiguous sequence with maximum sum: " + findSum());

    }

    static int findSum() {
        int[] table = new int[numbers.length];

        table[0] = numbers[0];
        for (int i=1; i<numbers.length; i++) {
            table[i] = Math.max(numbers[i], numbers[i] + table[i-1]);
        }

        int max = Integer.MIN_VALUE;
        for (int i=0; i<numbers.length; i++) {
            if (table[i] > max) {
                max = table[i];
            }
        }

        return max;
    }


}
