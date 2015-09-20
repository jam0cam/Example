/**
 * User: jitse
 * Date: 7/23/15
 * Time: 11:15 AM
 */
public class LLGetNFromLast {

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

    public static void main (String[] args) {
        init();

        System.out.println(mList.getNFromLast(0));
        System.out.println(mList.getNFromLast(7));
        System.out.println(mList.getNFromLast(3));
        System.out.println(mList.getNFromLast(2));
    }

}
