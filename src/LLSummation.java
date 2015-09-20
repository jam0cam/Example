/**
 * User: jitse
 * Date: 7/23/15
 * Time: 11:44 AM
 */
public class LLSummation {
    static MyLinkedList<Integer> mList1;
    static MyLinkedList<Integer> mList2;


    //test cases: 315 + 592,  315 + 5923, 351 + 529
    public static void init() {
        mList1 = new MyLinkedList();
        mList1.add(3);
        mList1.add(5);
        mList1.add(1);



        mList2 = new MyLinkedList();
        mList2.add(5);
        mList2.add(2);
        mList2.add(9);
    }

    public static void main (String[] args) {
        init();


        MyLinkedList<Integer> result = add();
        result.print();
    }

    public static MyLinkedList<Integer> add() {
        MyLinkedList.Node node1 = mList1.head;
        MyLinkedList.Node node2 = mList2.head;

        MyLinkedList<Integer> result = new MyLinkedList<>();

        boolean carry = false;

        while (node1 != null || node2 != null) {
            int sum = 0;
            if (carry) {
                sum ++;
            }

            carry = false;

            if (node1 != null) {
                sum += (Integer)node1.data;
                node1 = node1.next;
            }

            if (node2 != null) {
                sum += (Integer)node2.data;
                node2 = node2.next;
            }

            if (sum >= 10) {
                carry = true;
                sum = sum % 10;
            }

            result.add(sum);
        }

        if (carry) {
            result.add(1);
        }

        return result;
    }

}
