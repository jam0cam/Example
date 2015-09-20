/**
 *
 * Implement a function to check if a tree is balanced. For the purposes of this question,
 * a balanced tree is defined to be a tree such that no two leaf nodes differ in distance
 * from the root by more than one.
 *
 * User: jitse
 * Date: 7/24/15
 * Time: 9:05 AM
 */
public class BalancedTree {

    static Tree tree;



    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        TreeNode three = new TreeNode(3);
        TreeNode ten = new TreeNode(10);

        root.addChild(three);
        root.addChild(ten);

        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        three.addChild(one);
        three.addChild(six);

        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        six.addChild(four);
        six.addChild(seven);

        TreeNode fourteen = new TreeNode(14);
        ten.addChild(fourteen);

        TreeNode thirteen = new TreeNode(13);
        fourteen.addChild(thirteen);


        tree = new Tree(root);

        System.out.println(tree.isBalanced());


        TreeNode extraNode = new TreeNode(12);
        thirteen.addChild(extraNode);

        System.out.println(tree.isBalanced());
    }

}
