import java.util.LinkedList;
import java.util.List;

/**
 *
 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each
 * depth (i.e., if you have a tree with depth D, you’ll have D linked lists).
 *
 * User: jitse
 * Date: 7/24/15
 * Time: 11:23 AM
 */
public class BSTLL {

    static BinaryTree tree;

    private static void init() {

        //constructs this tree: https://en.wikipedia.org/wiki/Binary_search_tree

        BinaryTreeNode four = new BinaryTreeNode(4, null, null);
        BinaryTreeNode seven = new BinaryTreeNode(7, null, null);
        BinaryTreeNode six = new BinaryTreeNode(6, four, seven);

        BinaryTreeNode one = new BinaryTreeNode(1, null, null);
        BinaryTreeNode three = new BinaryTreeNode(3, one, six);

        BinaryTreeNode thirteen = new BinaryTreeNode(13, null, null);
        BinaryTreeNode fourteen = new BinaryTreeNode(14, thirteen, null);
        BinaryTreeNode ten = new BinaryTreeNode(10, null, fourteen);

        BinaryTreeNode eight = new BinaryTreeNode(8, three, ten);

        tree = new BinaryTree(eight);

    }

    public static void main(String[] args) {
        init();

        /**
         * Should return:
         * {8}
         * {3, 10}
         * {1, 6, 14}
         * {4, 7, 13}
         *
          */

        List<LinkedList<BinaryTreeNode>> linkedLists = tree.constructLinkedList();



        for (int i=0; i<linkedLists.size(); i++) {
            LinkedList<BinaryTreeNode> list = linkedLists.get(i);
            System.out.print(i + ": ");
            for (BinaryTreeNode node : list) {
                System.out.print(node.data + " ");
            }

            System.out.println();
        }

    }
}
