/**
 * Created by jitse on 11/26/15.
 */
public class BinarySearch {


    public static void main(String[] args) {

        int[] list;

        list = new int[] {1,2, 5, 7, 9, 11, 13, 21, 55};
        System.out.println(search(list, 7, 0, list.length-1));
        System.out.println(search(list, 9, 0, list.length-1));
        System.out.println(search(list, 11, 0, list.length-1));
        System.out.println(search(list, 13, 0, list.length-1));
    }

    /**
     * if not found, return -1, otherwise return the index of the value
     * @param list
     * @param val
     * @param start
     * @param end
     * @return the index
     */
    private static int search(int[] list, int val, int start, int end) {
        if (end - start < 2) {
            if (list[start] == val) {
                return start;
            } else if (list[end] == val) {
                return end;
            } else {
                return -1;
            }
        } else {
            //more than 2 left
            int mid = (start + end) / 2;
            if (list[mid] == val) {
                return mid;
            } else if (val < list[mid]) {
                return search(list, val, start, mid -1);
            } else {
                return search(list, val, mid + 1, end);
            }
        }
    }



}
