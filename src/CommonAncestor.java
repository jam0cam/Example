/**
 *
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 *
 * User: jitse
 * Date: 7/26/15
 * Time: 11:06 AM
 */
public class CommonAncestor {

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
         * 6 & 14 have 8 in common
         * 4,7 have 6
         * 1 and 7 have 3
         * 4 and 6 have 6
         */

        System.out.println(tree.commonAncestor(6,14));
        System.out.println(tree.commonAncestor(4,7));
        System.out.println(tree.commonAncestor(1,7));
        System.out.println(tree.commonAncestor(4,6));


        /**
         * 3, 8 have 8
         * 1, 14 have 8
         * 10, 8 have 8
         */
        System.out.println(tree.commonAncestor(3,8));
        System.out.println(tree.commonAncestor(1,14));
        System.out.println(tree.commonAncestor(10,8));





    }

}
