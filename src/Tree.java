import java.util.LinkedList;
import java.util.Queue;

/**
 * User: jitse
 * Date: 7/24/15
 * Time: 9:06 AM
 */
public class Tree {
    public TreeNode root;

    int maxHeight;
    int minHeight;

    public Tree(TreeNode root) {
        this.root = root;
    }

    boolean hasPath(int from, int to) {
        TreeNode a = find(root, from);

        if (a != null) {
            TreeNode res = find(a, to);
            return res != null;
        }

        return false;
    }

    /**
     * Use BFS to find val can be obtained going from node.
     * @param node
     * @param value
     * @return
     */
    TreeNode find (TreeNode node, int value) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode n = queue.remove();
            if (n.data == value) {
                return n;
            }

            if (n.hasChildren()) {
                for (TreeNode c : n.children) {
                    queue.add(c);
                }
            }
        }

        return null;
    }

    boolean isBalanced() {
        if (root == null) {
            return true;
        }

        minHeight = Integer.MAX_VALUE;
        maxHeight = -1;

        dfs(root, 0);

        if (maxHeight - minHeight> 1) {
            return false;
        } else {
            return true;
        }
    }

    void dfs(TreeNode n, int h) {
        h++;

        if (n.hasChildren()) {
            for (TreeNode node : n.children) {
                dfs(node, h);
            }
        } else {    //child node
            if (h > maxHeight) {
                maxHeight = h;
            }
            if (h < minHeight) {
                minHeight = h;
            }
        }
    }
}
