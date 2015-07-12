import java.util.LinkedList;

/**
 * User: jitse
 * Date: 11/4/14
 * Time: 9:25 AM
 */
public class ConcurrencyTest {

    static LinkedList<String> linkedList;

    public static void main(String[] args) {
        linkedList = new LinkedList<String>();

        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("three");
        linkedList.add("four");
        linkedList.add("five");
        linkedList.add("six");
        linkedList.add("seven");
        linkedList.add("eight");
        linkedList.add("nine");
        linkedList.add("ten");


        for (String s : linkedList) {
            if (s.equals("five")) {
                linkedList.remove(s);
            } else {
                System.out.println(s);
            }

        }

    }
}
