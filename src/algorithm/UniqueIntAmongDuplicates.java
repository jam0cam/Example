package algorithm;

import java.util.Hashtable;

/**
 *
 * Your company delivers breakfast via autonomous quadcopter drones. And something mysterious has happened.
 * Each breakfast delivery is assigned a unique ID, a positive integer. When one of the company's 100 drones takes
 * off with a delivery, the delivery's ID is added to an array, deliveryIdConfirmations. When the drone comes back
 * and lands, the ID is again added to the same array.
 *
 * After breakfast this morning there were only 99 drones on the tarmac. One of the drones never made it back from a
 * delivery. We suspect a secret agent from Amazon placed an order and stole one of our patented drones. To track them
 * down, we need to find their delivery ID.
 *
 * Given the array of IDs, which contains many duplicate integers and one unique integer, find the unique integer.
 *
 * The IDs are not guaranteed to be sorted or sequential. Orders aren't always fulfilled in the order they were
 * received, and some deliveries get cancelled before takeoff.
 *
 * https://www.interviewcake.com/question/java/find-unique-int-among-duplicates
 *
 * Created by jtse on 11/21/16.
 */
public class UniqueIntAmongDuplicates {

    public static void main(String[] args) {
        int[] ids = {2, 4, 6, 8, 10, 4, 6, 8, 10};
        System.out.println(solve(ids) + " : " + findUniqueDeliveryId(ids));

        int[] id2 = {1, 4, 2, 1, 3, 4, 2};
        System.out.println(solve(id2) + " : " + findUniqueDeliveryId(id2));

    }

    /**
     * This is the book answer. Uses XOR.
     *
     * O(n) time complexity
     * O(1) space complexity
     * @param deliveryIds
     * @return
     */
    public static int findUniqueDeliveryId(int[] deliveryIds) {

        int uniqueDeliveryId = 0;

        for (int i = 0; i < deliveryIds.length; i++) {
            uniqueDeliveryId ^= deliveryIds[i];
        }

        return uniqueDeliveryId;
    }

    /**
     *
     * O(n) space complexity
     * O(n) time complexity (assuming the hash function is implemented properly)
     *
     * @param ids
     * @return -1 on invalid inputs, otherwise the unique integer among duplicates
     */
    private static int solve(int[] ids) {
        if (ids == null || ids.length == 0) {
            return -1;
        }

        Hashtable<Integer, Boolean> table = new Hashtable<>();

        for (int i=0; i<ids.length; i++) {
            if (table.containsKey(ids[i])) {
                table.remove(ids[i]);
            } else {
                table.put(ids[i], true);
            }
        }

        if (table.keys() == null || !table.keys().hasMoreElements()) {
            return -1;
        }

        return table.keys().nextElement();
    }
}
