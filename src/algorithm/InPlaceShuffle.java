package algorithm;

import java.util.Random;

/**
 *
 * The shuffle must be "uniform," meaning each item in the original array must have the
 * same probability of ending up in each spot in the final array.
 * Assume that you have a function getRandom(floor, ceiling) for getting a random
 * integer that is >= floor and <= ceiling.
 *
 * Time: O(n)
 * Space: O(1)
 * 
 * Created by Jia on 12/2/16.
 */
public class InPlaceShuffle {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5,6,7,8,9,10};
        inPlaceShuffle(arr1);
        print(arr1);

        inPlaceShuffle(null);
        print(null);

    }

    public static void print(int[]arr) {
        if (arr == null) {
            return;
        }

        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.println();
    }

    public static void inPlaceShuffle(int[] arr) {
        if (arr == null) {
            return;
        }

        int n = arr.length;
        for (int i=0; i<n; i++) {
            int np = getRandom(i, n-1);
            int temp = arr[i];
            arr[i] = arr[np];
            arr[np] = temp;
        }
    }

    public static int getRandom(int floor, int ceiling) {
        return new Random().nextInt(ceiling - floor + 1) + floor;
    }
}
