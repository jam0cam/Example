import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User: jitse
 * Date: 7/23/15
 * Time: 3:00 PM
 */
public class BinaryTree {
    BinaryTreeNode root;

    BinaryTreeNode commonAncestor = null;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public void inOrderTraversal() {
        inOrder(root);
    }

    /**
     * Same as Depth First traversal
     */
    public void preOrderTraversal() {
        preOrder(root);
    }

    /**
     * no recursion needed
     */
    public void bfsTraversal() {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            System.out.println(node.data);

            //basically put all its children onto the queue
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    /**
     * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each
     * depth (i.e., if you have a tree with depth D, you’ll have D linked lists).
     *
     * @return
     */
    public List<LinkedList<BinaryTreeNode>> constructLinkedList() {
        LinkedList<BinaryTreeNode> ll = new LinkedList<>();
        List<LinkedList<BinaryTreeNode>> list = new ArrayList<>();

        ll.add(root);
        list.add(ll);

        for (int i=0; i<list.size(); i++) {
            LinkedList<BinaryTreeNode> temp = list.get(i);
            ll = new LinkedList<>();

            for (BinaryTreeNode node : temp) {
                if (node.left != null) ll.add(node.left);
                if (node.right != null) ll.add(node.right);
            }

            if (!ll.isEmpty()) {
                list.add(ll);
            }
        }

        return list;
    }

    /**
     * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
     * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
     *
     * @param a
     * @param b
     */
    public int commonAncestor(int a, int b) {
        commonAncestor = null;
        isFound(a, b, root);

        if (commonAncestor != null) {
            return commonAncestor.data;
        }

        return -1;
    }

    private boolean isFound(int a, int b, BinaryTreeNode n) {
        if (n == null)  return false;
        if (isFound(a, b, n.left) && isFound(a, b, n.right))    {
            commonAncestor = n;
            return false;
        }

        if (isFound(a,b,n.left) && (n.data == a || n.data == b)) {
            commonAncestor = n;
            return false;
        }

        if (isFound(a,b,n.right) && (n.data == a || n.data == b)) {
            commonAncestor = n;
            return false;
        }

        if (n.data == a || n.data == b || isFound(a,b,n.left) || isFound(a,b,n.right)) {
            return true;
        }

        return false;
    }

    /**
     *
     * print left, print current, print right
     * @param node
     */
    private void inOrder(BinaryTreeNode node) {
        if (node.left != null) {
            inOrder(node.left);
        }

        System.out.println(node.data);

        if (node.right != null) {
            inOrder(node.right);
        }
    }

    /**
     * same as dfs
     * @param node
     */
    private void preOrder(BinaryTreeNode node) {
        System.out.println(node.data);

        if (node.left != null) {
            preOrder(node.left);
        }

        if (node.right != null) {
            preOrder(node.right);
        }
    }

}
