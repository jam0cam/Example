/**
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, ....
 *
 * User: jitse
 * Date: 10/23/15
 * Time: 5:38 PM
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(9));
        System.out.println(fib(10));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

}
