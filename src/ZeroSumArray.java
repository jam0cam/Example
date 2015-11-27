/**
 * Created by jitse on 10/31/15.
 */
public class ZeroSumArray {

    static int arr[] = {0, 1, 2, 5, -8, -7, -5, 0, -1, 0};

    public static void main(String[] args) {

        solution1();
    }

    static void solution1() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    System.out.println("(" + arr[i] + "," + arr[j] + ")");
                }
            }
        }
    }


}