/**
 * Created by jitse on 1/7/16.
 */
public class BarberShop {
    static int[] speeds = { 2, 3, 5, 7, 10};

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
