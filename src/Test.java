import java.util.*;

/**
 * User: jitse
 * Date: 8/29/14
 * Time: 8:02 PM
 */
public class Test {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        while (!list.isEmpty()) {
            list.remove(0);
        }

        System.out.println("list is empty");
    }


}
