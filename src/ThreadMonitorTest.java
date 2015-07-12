/**
 * User: jitse
 * Date: 11/9/14
 * Time: 2:41 PM
 */
public class ThreadMonitorTest {

    public static void main(String[] args) {
        int message = 0;

        if (message++ == 0) {
            System.out.println("hello world");
        } else {
            System.out.println("major burn");
        }
    }
}
