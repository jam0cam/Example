/**
 * User: jitse
 * Date: 7/23/15
 * Time: 3:01 PM
 */
public class BinaryTreeTest {

    static BinaryTree tree;

    private static void init() {

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

        tree.inOrderTraversal();
        System.out.println("======================");


        tree.preOrderTraversal();
        System.out.println("======================");

        tree.bfsTraversal();
        System.out.println("======================");
    }
}
