/**
 *
 * Sort each pair of elements. Then, sort every four elements by merging every two pairs.
 * Then, sort every 8 elements, etc. O(n log n) expected and worst case.
 *
 * User: jitse
 * Date: 9/21/15
 * Time: 9:57 AM
 */
public class MergeSort extends BaseSort {

    public static void main(String[] args) {
        mergeSort(0, numbers.length-1);
        printNumbers();
    }


    public static void mergeSort(int begin, int end) {
        if (begin > end) {
            return;
        }
        if (end - begin < 2) {
            if (numbers[begin] > numbers[end]) {
                swap(begin, end);
            }  else {
                //already in the correct order, no need to swap
            }
            return;
        } else {
            //do mergeSort on left half
            int midpt = (begin + end)/2;
            mergeSort(begin, midpt);

            //do mergeSort on right half
            mergeSort(midpt+1, end);

            //merge both halves together
            merge(begin, midpt, midpt + 1, end);
        }
    }


    public static void merge(int start1, int end1, int start2, int end2) {
        int temp[] = new int[end2-start1 +1];
        int tempCounter = 0;
        int originalStart = start1;

        while (start1 <= end1 && start2 <= end2) {
            if (numbers[start1] < numbers[start2]) {
                temp[tempCounter] = numbers[start1];
                start1++;
            } else {
                temp[tempCounter] = numbers[start2];
                start2++;
            }
            tempCounter++;
        }

        while (start1 <= end1) {
            temp[tempCounter] = numbers[start1];
            tempCounter++;
            start1++;
        }

        while (start2 <= end2) {
            temp[tempCounter] = numbers[start2];
            start2++;
            tempCounter++;
        }


        //copy temp back into the main array
        int count = 0;
        while (count < tempCounter) {
            numbers[originalStart] = temp[count];
            originalStart++;
            count++;
        }
    }
}
