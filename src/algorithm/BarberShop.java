package algorithm;

/**
 *
 * Given a list of speeds at which a barber serves clients. There are N customers in line.
 * How many time units will you have to wait before you can get a haircut?
 *
 */
public class BarberShop {
    static int[] speeds;

    public static void main(String[] args) {

        speeds = new int[] { 1, 3};
        System.out.println(solve(speeds, 6));


        speeds = new int[] { 2, 3, 5, 7, 10};
        System.out.println(solve(speeds, 10));

    }

    private static int solve(int[] speeds, int n) {

        int i=0;
        int served = 0;

        while (served < n) {
            i++;
            served = 0;
            for (int x=0; x<speeds.length; x++) {
                served += (i / speeds[x]);
            }
        }

        return i;
    }
}
