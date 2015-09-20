import java.util.*;

/**
 * User: jitse
 * Date: 7/21/15
 * Time: 9:04 AM
 */
public class ConcurrentModicationExample {

    static Map<Integer, String> map;

    public static void main(String [] args) throws InterruptedException {
        String[] names = {"Hello", "world", "this", "is", "tuesday"};

        List<String> nameList = Arrays.asList(names);

        map = new HashMap<>();

        int index = 0;
        for (String s : nameList) {
            map.put(index, s);
            index ++;
        }


        Set<Integer> st = map.keySet();

        Thread thread = new Thread();
        Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (Integer i : map.keySet()) {
                        System.out.println(System.currentTimeMillis());
                        System.out.println(map.get(i));
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        new Thread(mRunnable).start();

        Thread.sleep(2000);
        System.out.println("removing 2");
        System.out.println(System.currentTimeMillis());
        map.remove(2);
        System.out.println(System.currentTimeMillis());
        System.out.println("removed 2");


//        for (Integer i : map.keySet()) {
//            if (i == 2) {
//                map.remove(i);
//            }
//        }
//
//        Iterator it = map.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            System.out.println(pair.getKey() + " = " + pair.getValue());
//            it.remove(); // avoids a ConcurrentModificationException
//        }
    }
}
