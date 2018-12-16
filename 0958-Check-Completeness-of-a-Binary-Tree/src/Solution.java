import java.util.LinkedList;

class Solution {
    /**
     * 判定一棵树是不是完全二叉树的思路是广度遍历该二叉树，当出现NULL值时停止遍历，
     * 如果此时还有没有遍历到的结点，那么就说明该树非完全二叉树，因为有空洞。
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