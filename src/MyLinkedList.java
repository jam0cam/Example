import java.util.Hashtable;

/**
 * User: jitse
 * Date: 7/22/15
 * Time: 5:47 PM
 */
public class MyLinkedList<T> {

    Node head;
    int size;

    public T getFirst() {
        return head.data;
    }

    public int getSize() {
        return size;
    }

    public void add(T data) {
        Node incoming = new Node(data);

        if (head == null) {
            head = incoming;
            size ++;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = incoming;
            size ++;
        }
    }

    public void removeDuplicates() {
        Hashtable table = new Hashtable();

        Node current = head;
        Node previous = head;

        while (current != null) {
            if (table.containsKey(current.data)) {
                previous.next = current.next;
                current = current.next;
            } else {
                table.put(current.data, true);
                previous = current;
                current = current.next;
            }
        }
    }

    public T getNFromLast(int n) {
        if (n > size || n < 0) {
            return null;
        }

        Node p1 = head;
        Node p2 = head;

        for (int i=0; i<n-1 ;i++) {
            p2 = p2.next;
        }

        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p1.data;
    }

    public void removeInlineDuplicates() {
        Node loop1 = head;
        Node loop2 = head.next;
        Node loop2Prev = head;

        if (loop2 == null) {
            //only 1 element, no duplicates
            return;
        }

        int counter = 1;
        boolean changes = false;
        while (loop2 != null) {
            changes = false;
            loop1 = head;
            for (int i=0; i<counter; i++) {
                if (loop1.data.equals(loop2.data)) {
                    loop2Prev.next = loop2.next;
                    changes = true;
                    break;
                } else {
                    loop1 = loop1.next;
                }
            }

            if (!changes) {
                loop2Prev = loop2;
                counter++;
            }

            loop2 = loop2.next;

        }
    }

    /**
     * This typically would not appear as a method in a linked list.
     */
    public void print() {
        if (head != null) {
            Node current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }

    class Node {
        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
        }
    }
}
