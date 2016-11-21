package algorithm.linkedlist;

/**
 * Write a function for reversing a linked list. Do it in-place.
 * Your function will have one input: the head of the list.
 * Your function should return the new head of the list.
 *
 * https://www.interviewcake.com/question/java/reverse-linked-list
 *
 * Created by Jia on 11/21/16.
 */
public class ReverseLinkList {

    public static LinkedListNode sHead;

    public static void main(String[] args) {
        testCase1();

        System.out.println("========================");
        //case with just one node as head.
        sHead = new LinkedListNode(0);

        LinkedListNode newHead = reverseList(sHead);
        printList(newHead);


        //case with nothing, should return null;
        newHead = reverseList(null);
        System.out.println(newHead);


    }

    /**
     * Standard case with 10 items
     */
    public static void testCase1() {
        sHead = new LinkedListNode(0);
        LinkedListNode next = sHead;
        for (int i = 1; i <= 10; i++) {
            next.next = new LinkedListNode(i);
            next = next.next;
        }

        printList(sHead);

        LinkedListNode newHead = reverseList(sHead);

        System.out.println("======================");
        printList(newHead);
    }

    public static LinkedListNode reverseList(LinkedListNode head) {
        if (head == null) {
            return null;
        }

        LinkedListNode current = head;
        LinkedListNode next = head.next;
        current.next = null;

        while (next != null) {
            LinkedListNode tempNext = next.next;
            next.next = current;
            current = next;
            next = tempNext;
        }

        return current;
    }

    public static void printList(LinkedListNode head) {
        LinkedListNode current = head;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
