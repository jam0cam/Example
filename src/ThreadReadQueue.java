import java.util.ArrayList;
import java.util.List;

/**
 * Created by jitse on 12/24/15.
 */
public class ThreadReadQueue {

    static List<String> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (!list.isEmpty()) {
                    System.out.println(list.remove(list.size() - 1));

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        thread.start();
    }
}
