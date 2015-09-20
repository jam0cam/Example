/**
 * This is the better representation of what a linked list will look like
 * User: jitse
 * Date: 7/22/15
 * Time: 5:45 PM
 */
public class LinkedListRemoveDuplicates2 {

    static MyLinkedList<Integer> mList;

    public static void init() {
        mList = new MyLinkedList();
        mList.add(2);
        mList.add(1);
        mList.add(7);
        mList.add(1);
        mList.add(8);
        mList.add(5);
        mList.add(0);

    }

    public static void main(String[] args) {
        init();
        mList.print();

        System.out.println("=====================");
//        mList.removeDuplicates();
//        mList.print();


        mList.removeInlineDuplicates();
        mList.print();

    }
}
