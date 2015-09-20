import java.util.Arrays;

/**
 * User: jitse
 * Date: 7/14/15
 * Time: 5:33 PM
 */
public class ArrayCopyExample {

    static int[] one = {1,2,3,4,5};
    static int[] two;

    public static void main(String[] args) {
        arrayCopyExample();
    }

    private static void printResults() {
        print(one);
        print(two);

        for (int i=0; i<two.length; i++) {
            two[i] = 0;
        }

        System.out.println("==========================");
        print(one);
        print(two);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    private static void arrayCopyExample() {
        two = Arrays.copyOf(one, one.length);
        printResults();
    }


    private static void equalsExample() {
        two = one;
        printResults();
    }


    private static void cloneExample() {
        two = one.clone();
        printResults();
    }
}
