/**
 * Pick a random element and partition the array, such that all numbers that are less than
 * it come before all elements that are greater than it. Then do that for each half, then
 * each quarter, etc. O(n log n) expected, O(n^2) worst case.
 *
 * User: jitse
 * Date: 9/21/15
 * Time: 10:45 AM
 */
public class QuickSort extends BaseSort {


    public static void main(String[] args) {
        quickSort(0, numbers.length-1);
        printNumbers();
    }

    static void quickSort(int start, int end) {
        if (start > end) {
            return;
        }
        if (end - start < 2) {
            //swap if necessary
            if (numbers[start] > numbers[end]) {
                swap(start, end);
            }
            return;
        }


        //taking the middle number as pivot;
        int pivotLocation = (start + end) /2;
        int pivot = numbers[pivotLocation];

        int temp[] = new int[end-start+1];
        int counter = 0;
        for (int i=start; i<=end; i++) {
            if (numbers[i] < pivot) {
                temp[counter++] = numbers[i];
            }
        }

        int newPivotLocation = counter;
        temp[counter++] = pivot;

        for (int i=start; i<=end; i++) {
            if (numbers[i] >= pivot) {
                if (i == pivotLocation) {
                    continue;
                }
                temp[counter++] = numbers[i];
            }
        }

        //copy everything from temp back onto the original array
        int copyStart = start;

        for (int i=0; i<counter; i++) {
            numbers[copyStart++] = temp[i];
        }

        //by this point, everything on the left of the pivot is smaller
        //everything to the right of the pivot is bigger
        quickSort(start, start + newPivotLocation-1);
        quickSort(start + newPivotLocation+1, end);
    }
}
