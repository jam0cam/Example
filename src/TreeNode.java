import java.util.ArrayList;
import java.util.List;

/**
 * User: jitse
 * Date: 7/24/15
 * Time: 9:07 AM
 */
public class TreeNode {
    int data;
    List<TreeNode> children;

    public TreeNode(int data) {
        this.data = data;
    }

    boolean hasChildren() {
        return children != null && !children.isEmpty();
    }

    void addChild(TreeNode node) {
        if (children == null) {
            children = new ArrayList<>();
        }

        children.add(node);
    }
}
