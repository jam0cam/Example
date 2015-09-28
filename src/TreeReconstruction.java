/**
 *
 * Given a preorder traversal and a inorder traversal, reconstruct the binary tree.
 *
 * EXAMPLE:
 * inorder: gdhbeiafjc
 * preorder: abdgheicfj
 *
 * Reference: https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&ved=0CB0QFjAAahUKEwjvk8u-tpjIAhXRO4gKHTPRAME&url=http%3A%2F%2Fwww.cise.ufl.edu%2F~sahni%2Fcop3530%2Fpowerpoint%2Flec21.ppt&usg=AFQjCNGytOiBBXmK-Lp2tmS0k3-v2rUF_g&sig2=Ac3Q-hVEE9endaB5V2ps8Q&cad=rja
 * Reference: https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&ved=0CCQQFjABahUKEwi___2prpjIAhXXnIgKHdloDAM&url=http%3A%2F%2Fmy.fit.edu%2F~tgillett%2Fcse5100%2Fweek11%2FTreeTraversal.ppt&usg=AFQjCNHC2yVG_pBLdE2M_np45Q-g5HgyaA&sig2=3S_fKSy0xW_r9BwScBYc8A&bvm=bv.103388427,d.cGU&cad=rja
 *
 *
 * User: jitse
 * Date: 9/27/15
 * Time: 5:00 PM
 */
public class TreeReconstruction {

    public static String inorder = "gdhbeiafjc";
    public static String preorder = "abdgheicfj";

    public static int ptr = 0;

    public static void main(String[] args) {
        BinaryTreeNode root = construct(0, inorder.length()-1);

        BinaryTree tree = new BinaryTree(root);

        System.out.print("inorder is: ");
        tree.inOrderTraversal();

        System.out.print("preorder is: ");
        tree.preOrderTraversal();
    }

    /**
     * start and end are inclusive to the array bounds
     * @param start
     * @param end
     * @return
     */
    static BinaryTreeNode construct(int start, int end) {
        char root = preorder.charAt(ptr++);

        BinaryTreeNode node = new BinaryTreeNode(root);
        int location = inorder.indexOf(root);

        if (location >= start && location <= end) {
            if (location > start) {     //there is a left sub tree
                node.left = construct(start, location-1);
            }

            if (location < end) {       //there is a right sub tree
                node.right = construct(location +1, end);
            }

            return node;
        }

        System.out.println("error case. Should not happen");
        return null;
    }
}
