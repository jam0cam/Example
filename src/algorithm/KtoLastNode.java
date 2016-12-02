package algorithm;

/**
 * You have a linked list ↴ and want to find the kth to last node.
 *
 * Write a function kthToLastNode() that takes an integer k and the headNode of a singly linked list,
 * and returns the kth to last node in the list.
 *
 * Time: O(n)
 * Space: O(1)
 *
 * Created by Jia on 12/2/16.
 *
 */
public class KtoLastNode {

    public static void main(String[] args) {

        LinkedListNode a = new LinkedListNode("Angel Food");
        LinkedListNode b = new LinkedListNode("Bundt");
        LinkedListNode c = new LinkedListNode("Cheese");
        LinkedListNode d = new LinkedListNode("Devil's Food");
        LinkedListNode e = new LinkedListNode("Eccles");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        // returns the node with value "Devil's Food" (the 2nd to last node)
        System.out.println(twoPassSolution(2, a));
        System.out.println(slidingWindowSolution(2, a));

    }

    /**
     * Users 2 pointers. One pointer will go down k steps. The second pointer points at the head, and move lock-steps
     * until the first pointer reaches the end.
     *
     * Time: O(n)
     * Space: O(1)
     *
     * @param k
     * @param head
     * @return
     */
    private static LinkedListNode slidingWindowSolution(int k, LinkedListNode head) {
        if (k < 0) {
            return null;        //invalid input
        }

        LinkedListNode firstNode = head;
        LinkedListNode secondNode = head;

        //advance firstNode k-1 times
        for (int i=0; i<k-1; i++) {
            if (firstNode.next == null) {
                return null;        //invalid input
            } else {
                firstNode = firstNode.next;
            }
        }

        while (firstNode.next != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        return secondNode;
    }

    /**
     * 2 passes. First past gets the length. Second pass goes up to k, and return that node.
     *
     * Time: O(n)
     * Space: O(1)
     *
     * @param k
     * @param head
     * @return
     */
    private static LinkedListNode twoPassSolution(int k, LinkedListNode head) {
        int count = 1;

        if (head == null) {
            return null;
        } else if (head.next == null && k == 1) {
            return head;
        }

        LinkedListNode node = head;
        while (node.next != null) {
            count ++;
            node = node.next;
        }

        //imagine there are 5 items and we want 2nd to last. Then we want the 4th item returned
        int i=count - k + 1;
        if (i < 1 || i > count) {
            return null;
        }

        count = 1;
        node = head;
        while (count < i) {
            count ++;
            node = node.next;
        }

        return node;
    }

    public static class LinkedListNode {

        public String value;
        public LinkedListNode next;

        public LinkedListNode(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
