import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int TreeDepth_1(TreeNode root) {
        return root == null ? 0 : Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    /**
     * 层次遍历
     *
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode n = queue.remove();
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
        }
        return level;
    }
}