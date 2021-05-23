package NO_0101_Symmetric_Tree;

import java.util.LinkedList;

class Solution {
    /**
     * 递归
     */
    public boolean isSymmetric_1(TreeNode root) {
        return isSymmetric(root, root);
    }

    /**
     * 该方法亦可用以比较两棵树是否对称
     */
    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else if (root1.val != root2.val) {
            return false;
        }
        // 递归，就该节点而言，只需要关注自己的左右孩子是否对称即可
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    /**
     * 迭代
     */
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int l = 0, r = size - 1; l < r; l++, r--) {
                TreeNode lNode = q.get(l);
                TreeNode rNode = q.get(r);
                if ((lNode == null && rNode != null)
                        || (lNode != null && (rNode == null || lNode.val != rNode.val)) ) {
                    return false;
                }
            }
            while (size > 0) {
                TreeNode cur = q.removeFirst();
                if (cur != null) {
                    q.addLast(cur.left);
                    q.addLast(cur.right);
                }
                size--;
            }
        }
        return true;
    }
}