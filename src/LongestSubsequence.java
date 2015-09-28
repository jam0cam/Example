import java.awt.*;

/**
 *
 * A circus is designing a tower routine consisting of people standing atop one another’s shoulders.
 * For practical and aesthetic reasons, each person must be both shorter and lighter than the person
 * below him or her. Given the heights and weights of each person in the circus, write a method to
 * compute the largest possible number of people in such a tower.
 *
 * EXAMPLE:
 * Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 * Output: The longest tower is length 6 and includes from top to bottom:
 * (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
 *
 * User: jitse
 * Date: 9/22/15
 * Time: 8:27 AM
 */
public class LongestSubsequence {

    static Point[] points;
    static int[] table;

    public static void main(String[] args) {
        points = new Point[9];
        table = new int[9];

        //different input than the sample input
        points[0] = new Point(60,95);
        points[1] = new Point(68,110);
        points[2] = new Point(70, 150);
        points[3] = new Point(57, 80);
        points[4] = new Point(56, 90);
        points[5] = new Point(75, 190);
        points[6] = new Point(58, 81);
        points[7] = new Point(65, 100);
        points[8] = new Point(67, 50);


        System.out.println(getMax());
    }


    public static int getMax() {
        sort();

        table[0] = 1;
        int max;
        for (int i=1; i<points.length; i++) {
            Point p = points[i];
            max = 1;
            for (int j=0; j<i; j++) {
                Point p2 = points[j];
                if (p.x > p2.x && p.y > p2.y) {
                    if (table[j] +1 > max) {
                        max = table[j] + 1;
                    }
                }
            }

            table[i] = max;
        }

        //search the table for max
        max = 0;
        for (int i=0; i<points.length; i++) {
            if (table[i] > max) {
                max = table[i];
            }
        }

        return max;
    }

    /**
     * Sort by height only.
     */
    private static void sort() {
        for (int i=0; i<points.length-1; i++) {
            for (int j=i+1; j<points.length; j++) {
                if (points[i].x > points[j].x) {
                    Point temp = points[i];
                    points[i] = points[j];
                    points[j] = temp;
                }
            }
        }
    }


}
