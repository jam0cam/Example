/**
 *
 * Start at the beginning of an array and swap the first two elements if the first is bigger than the second.
 * Go to the next pair, etc, continuously making sweeps of the array until sorted. O(n^2).
 *
 * User: jitse
 * Date: 9/21/15
 * Time: 9:34 AM
 */
public class BubbleSort extends BaseSort {

    public static void main(String[] args) {

        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i=0; i<numbers.length-1; i++) {
                if (numbers[i] > numbers[i+1]) {
                    swap(i, i+1);
                    swapped = true;
                }
            }
        }

        printNumbers();
    }

}
