/**
 * Created by jitse on 12/22/15.
 */
public class RotatedArray {

    static int[] arr;

    public static void main(String[] args) {

        arr = new int[] {20, 30, 35,     6, 8, 12};
        System.out.println(arr[simpleAnswer(arr)]);
        System.out.println(arr[binarySearchAnswer(arr, 0, arr.length-1)]);
        System.out.println("==============================");


        arr = new int[] {20, 30, 35,     5,     6, 8, 12};
        System.out.println(arr[simpleAnswer(arr)]);
        System.out.println(arr[binarySearchAnswer(arr, 0, arr.length-1)]);
        System.out.println("==============================");


        arr = new int[] {20, 30, 5,     6, 8, 12};
        System.out.println(arr[simpleAnswer(arr)]);
        System.out.println(arr[binarySearchAnswer(arr, 0, arr.length-1)]);
        System.out.println("==============================");


    }


    public static int binarySearchAnswer(int[] arr, int start, int end) {
        boolean found = false;
        boolean leftRotated = false;
        boolean rightRotated = false;

        if (end - start < 3) {
            return simpleAnswer(arr);
        }

        while (!found) {
            //split array in half
            int mid = (start + end) / 2;
            leftRotated = isRotated(arr, start, mid);
            rightRotated = isRotated(arr, mid+1, end);

            if (leftRotated) {
                //continue the while loop, searching only the left side now
                end = mid;
            } else if (rightRotated) {
                //continue the while loop, searching only the right side now
                start = mid +1;
            } else {
                //both not rotated, then the start is the minimal
                if (arr[start] < arr[mid+1]) {
                    return start;
                } else {
                    return mid+1;
                }
            }

        }

        return -1;
    }

    public static boolean isRotated(int[] arr, int start, int end) {
        return (arr[start] > arr[end]);
    }

    public static int simpleAnswer(int[] arr) {
        int current = arr[0];

        for (int i=1; i<arr.length; i++) {
            if (arr[i] > current) {
                current = arr[i];
            } else {
                return i;
            }
        }

        return 0;

    }
}
