import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
 *
 * User: jitse
 * Date: 7/24/15
 * Time: 10:22 AM
 */
public class ConstructBinaryTree {

    static List<Integer> numbers;

    static void init() {
        numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
    }

    public static void main(String[] args) {
        init();

        BinaryTree tree = new BinaryTree(construct(0, numbers.size()-1));

        tree.bfsTraversal();
    }

    static BinaryTreeNode construct(int min, int max) {
        if (max < min)
            return null;

        int mid = (max + min) / 2 ;
        BinaryTreeNode n = new BinaryTreeNode(numbers.get(mid));

        n.left = construct(min, mid-1);
        n.right = construct(mid +1, max);

        return n;
    }
}