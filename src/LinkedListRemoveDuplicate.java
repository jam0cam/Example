import java.util.LinkedList;

/**
 * User: jitse
 * Date: 7/15/15
 * Time: 5:38 PM
 */
public class LinkedListRemoveDuplicate {

    static LinkedList<Integer> mList;

    public static void main(String[]  args) {
        mList = new LinkedList<>();
        mList.add(5);
        mList.add(3);
        mList.add(1);
        mList.add(5);
        mList.add(2);
        mList.add(4);

        printList(mList);
        System.out.println("===================");
//        LinkedList<Integer> newList = removeDuplicates(mList);
//        printList(newList);


        inplaceRemove();
        printList(mList);
    }

    static void inplaceRemove() {
        for (int i=1; i<mList.size(); i++) {
            Integer item = mList.get(i);

            for (int y=0; y<i; y++) {
                Integer prevItem = mList.get(y);
                if (prevItem.equals(item)) {
                    mList.remove(item);
                    break;
                }
            }
        }
    }

    /**
     * My solution, not that great.
     * @param list
     * @return
     */
    static LinkedList<Integer> removeDuplicates(LinkedList<Integer> list) {
        LinkedList<Integer> temp = new LinkedList<>();

        for (Integer i : list) {
            if (!temp.contains(i)) {
                temp.add(i);
            }
        }

        return temp;
    }

    static void printList(LinkedList<Integer> list) {
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
