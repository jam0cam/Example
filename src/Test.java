/**
 * User: jitse
 * Date: 8/29/14
 * Time: 8:02 PM
 */
public class Test {

    public static void main(String[] args) {

//
//
//        Scanner sc=new Scanner(System.in);
//        int a=sc.nextInt();
//        System.out.println("a=" + a);
//
//        a=sc.nextInt();
//        System.out.println("a=" + a);
//

        int[] arr = {12, 12};

        System.out.println(sumOfIntegers(arr));

        int[] arr2 = {1,2,3,4,5};
        System.out.println(sumOfIntegers(arr2));

    }


    static long sumOfIntegers(int[] arr) {

        long sum = 0;
        for (Integer i : arr) {
            sum += i;
        }

        return sum;
    }


    static void StairCase(int n) {

        for (int i=1; i<=n; i++) {
            String val = String.valueOf(n);
            int numSpaces = n - val.length();
            for (int j=0; j<numSpaces; j++) {
                System.out.print(" ");
            }
            for (int j=0; j<i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }

}
