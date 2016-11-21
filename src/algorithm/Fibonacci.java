package algorithm;

/**
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, ....
 *
 * O(2^n)
 *
 * User: jitse
 * Date: 10/23/15
 * Time: 5:38 PM
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(5) + " : " + fib2(5));
        System.out.println(fib(6) + " : " + fib2(6));
        System.out.println(fib(7) + " : " + fib2(7));
        System.out.println(fib(8) + " : " + fib2(8));
        System.out.println(fib(9) + " : " + fib2(9));
        System.out.println(fib(10) + " : " + fib2(10));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    /**
     * This takes O(n) time
     * @param n
     * @return
     */
    public static int fib2(int n) {
        int p1 = 0;
        int p2 = 1;
        int counter = 2;
        int value = p1 + p2;

        if (n==0 || n == 1) {
            return n;
        }

        while (counter < n) {
            p1 = p2;
            p2 = value;
            value = p1 + p2;
            counter ++;
        }

        return value;
    }

}
