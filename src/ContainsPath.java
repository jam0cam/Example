/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 *
 * User: jitse
 * Date: 7/24/15
 * Time: 9:44 AM
 */
public class ContainsPath {

    static Tree tree;


    static void init() {

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

    }

    public static void main(String[] args) {
        init();

        //three has a path to seven
        System.out.println(tree.hasPath(3, 7));


        //three does not have a path to 13
        System.out.println(tree.hasPath(3, 13));
    }
}
