import java.util.*;

/**
 * Created by jitse on 12/28/15.
 */
public class Handy {

    public static void main(String[] args) {

        String str = "Hello New York, New York. hello new day. Hi New Jersey";

        printTopWords(str, 2);



    }

    static class MyItem {
        String key;
        int value;

        public MyItem (String k, int v){
            key = k;
            value = v;
        }
    }

    private static void printTopWords(String str, int top) {
        str = str.toLowerCase();
        String[] words = str.split("\\s*(,|\\.|\\s)\\s*");
        Hashtable<String, MyItem> table = new Hashtable<>();

        for (String s : words) {
            if (!table.containsKey(s)) {
                table.put(s, new MyItem(s, 1) );
            } else {
                MyItem item = table.get(s);
                item.value++;
            }
        }

        Collection<MyItem> items = table.values();
        List<MyItem> myList = new ArrayList<>(items);


        Collections.sort(myList, new Comparator<MyItem>() {
            @Override
            public int compare(MyItem o1, MyItem o2) {
                return Integer.compare(o2.value, o1.value);
            }
        });

        for (int i=0; i<top; i++) {
            if (i < myList.size()) {
                System.out.println(myList.get(i).key + ":" + myList.get(i).value);
            }
        }
    }


}
