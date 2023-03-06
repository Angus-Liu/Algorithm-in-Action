package NO_0199_Binary_Tree_Right_Side_View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    /**
     * 利用二叉树的层序遍历，取每层最右边的节点组成右试图
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        // 创建一个队列，用于层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // 将每层最右边节点加入右视图中
                if (i == size - 1) res.add(cur.val);
                // 将该节点的左右孩子推入队列
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return res;
    }
}