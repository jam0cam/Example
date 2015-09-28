/**
 *
 * Find the smallest element using a linear scan and move it to the front. Then, find the second smallest
 * and move it, again doing a linear scan. Continue doing this until all the elements are in place. O(n^2).
 *
 * User: jitse
 * Date: 9/21/15
 * Time: 9:38 AM
 */
public class SelectionSort extends BaseSort {

    public static void main(String[] args) {

        for (int i=0; i<numbers.length; i++) {
            int min = Integer.MAX_VALUE;
            int indexOfMin = -1;
            for (int j=i; j<numbers.length; j++) {
                if (numbers[j] < min) {
                    min = numbers[j];
                    indexOfMin = j;
                }
            }

            if (i != indexOfMin) {
                //swap
                swap(i, indexOfMin);
            }
        }


        printNumbers();
    }
}
