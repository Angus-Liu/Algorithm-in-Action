package NO_0958_Check_Completeness_of_a_Binary_Tree;

import java.util.LinkedList;

class Solution {
    /**
     * 广度遍历二叉树，当出现 null 值时停止遍历，如果此时还有没有遍历到的结点，那么就说明该树非完全二叉树。
     */
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode cur;
        q.addLast(root);
        while ((cur = q.removeFirst()) != null) {
            q.addLast(cur.left);
            q.addLast(cur.right);
        }
        while (!q.isEmpty()) {
            if (q.removeLast() != null) {
                return false;
            }
        }
        return true;
    }
}