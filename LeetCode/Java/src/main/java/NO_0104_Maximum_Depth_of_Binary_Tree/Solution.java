package NO_0104_Maximum_Depth_of_Binary_Tree;



import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
     * 递归（自顶向下）
     */
    private int maxDepth;

    public int maxDepth(TreeNode root) {
        topDown(root, 0);
        return maxDepth;
    }

    private void topDown(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = depth > maxDepth ? depth : maxDepth;
            return;
        }
        topDown(node.left, depth + 1);
        topDown(node.right, depth + 1);
    }

    /**
     * 递归（自底向上）
     */
    public int maxDepth2(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    /**
     * 迭代
     */
    public int maxDepth3(TreeNode root) {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = root;
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node = node.left;
        node.left = new TreeNode(4);

        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root));
    }
}