package NO_0100_Same_Tree;



class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            // p == null && q != null || p != null && q == null
            return false;
        } else if (p.val != q.val) {
            // p != null && q != null && p.val != q.val
            return false;
        }
        // p != null && q != null && p.val == q.val
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}