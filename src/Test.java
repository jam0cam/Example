import com.sun.source.tree.BinaryTree;

import java.util.LinkedList;

/**
 * User: jitse
 * Date: 8/29/14
 * Time: 8:02 PM
 */
public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(5);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(1);

        BinaryTree tree;

        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
