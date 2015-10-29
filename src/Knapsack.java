import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Knapsack Problem:
 *
 * Given some items, pack the knapsack to get the maximum total value. Each item has some
 * weight and some value. Total weight that we can carry is no more than some fixed number W.
 * So we must consider weights of items as well as their values.
 *
 * REFERENCE: https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=4&ved=0CDQQFjADahUKEwjqxYLE5pjIAhWImoAKHc5AA2U&url=http%3A%2F%2Fcse.unl.edu%2F~ylu%2Fraik283%2Fnotes%2F0-1-knapsack.ppt&usg=AFQjCNEhfELhk_i72hbAQXouQd1uA4dR7Q&sig2=CmSzLuUp4EqnAkHrreL-nQ&bvm=bv.103388427,d.eXY&cad=rja
 *
 * User: jitse
 * Date: 9/27/15
 * Time: 9:51 PM
 */
public class Knapsack {

    static int capacity;
    static int table[][];
    static List<Point> items;


    public static void main(String[] args) {
        input1();
        input2();
        input3();
    }

    public static void input3() {
        capacity = 20;
        items = new ArrayList<>();
        items.add(new Point(0,0));  //dummy placeholder
        items.add(new Point(9,5));
        items.add(new Point(10,4));

        solve();
        System.out.println("Maximum possibly value is: " + table[capacity][items.size()-1]);

    }


    public static void input2() {
        capacity = 4;
        items = new ArrayList<>();
        items.add(new Point(0,0));  //dummy placeholder
        items.add(new Point(1,8));
        items.add(new Point(2,4));
        items.add(new Point(3,0));
        items.add(new Point(2,5));
        items.add(new Point(2,3));

        solve();
        System.out.println("Maximum possibly value is: " + table[capacity][items.size()-1]);

    }

    public static void input1() {
        capacity = 5;
        items = new ArrayList<>();
        items.add(new Point(0,0));  //dummy placeholder
        items.add(new Point(2,3));
        items.add(new Point(3,4));
        items.add(new Point(4,5));
        items.add(new Point(5,6));

        solve();
        System.out.println("Maximum possibly value is: " + table[capacity][items.size()-1]);

    }

    public static void solve() {
        table = new int[capacity+1][items.size()];

        for (int i=0; i<=capacity; i++) {
            table[i][0] = 0;
        }

        for (int i=0; i<items.size(); i++) {
            table[0][i] = 0;
        }


        for (int item=1; item<items.size(); item++) {
            for (int weight=1; weight<=capacity; weight++) {
                Point p = items.get(item);

                if (p.x > weight) {
                    //this item can't be used with this weight, so take answer from previous
                    table[weight][item] = table[weight][item-1];
                } else {
                    //see if adding this current p will help its cause
                    if (table[weight - p.x][item-1] + p.y > table[weight][item-1]) {
                        table[weight][item] = table[weight - p.x][item-1] + p.y;
                    } else {
                        table[weight][item] = table[weight][item-1];
                    }
                }
            }
        }

    }
}
