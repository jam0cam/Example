package algorithm.sort;

/**
 * User: jitse
 * Date: 9/21/15
 * Time: 9:39 AM
 */
public class BaseSort {
//    static int [] numbers = {2,3,5,6,1,2,4,10,5,2,3,1,8,5,3,9};
    static int [] numbers = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };

    public static void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void printNumbers() {
        for (Integer i: numbers) {
            System.out.println(i);
        }
    }
}
