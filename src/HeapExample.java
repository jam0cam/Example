import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * This is an example showing the usage of heaps in Java.
 *
 * Created by jitse on 11/26/15.
 */
public class HeapExample {

    public static PriorityQueue<Integer> minHeap;

    public static void main(String[] args) {

        minHeap = new PriorityQueue<>();
        fillHeap();
        printHeap();

        System.out.println("------------------");

        minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        fillHeap();
        printHeap();
    }

    static void fillHeap() {
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(5);
        minHeap.add(5);
        minHeap.add(8);
        minHeap.add(4);
        minHeap.add(2);
    }

    static void printHeap() {
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.remove());
        }
    }
}
