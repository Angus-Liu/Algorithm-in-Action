package NO_0101_Symmetric_Tree;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /**
     * 递归
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    /**
     * 该方法亦可用以比较两棵树是否对称
     */
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        // 递归，就该节点而言，只需要关注自己的左右孩子是否对称即可
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 迭代
     */
    public boolean isSymmetric2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int l = 0, r = size - 1; l < r; l++, r--) {
                TreeNode lNode = queue.get(l);
                TreeNode rNode = queue.get(r);
                if ((lNode == null && rNode != null)
                        || (lNode != null && (rNode == null || lNode.val != rNode.val))) {
                    return false;
                }
            }
            while (size > 0) {
                TreeNode cur = queue.removeFirst();
                if (cur != null) {
                    queue.addLast(cur.left);
                    queue.addLast(cur.right);
                }
                size--;
            }
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}