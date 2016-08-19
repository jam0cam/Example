import java.util.ArrayList;
import java.util.List;

/**
 * Created by jtse on 4/26/16.
 */
public class Test  {



    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");


        List<String> list2 = new ArrayList<>();

        list2.add(list.get(2));
        list2.add(list.get(1));
        list2.add(list.get(0));

        for (String s : list2) {
            System.out.println(s);
        }
    }
}
