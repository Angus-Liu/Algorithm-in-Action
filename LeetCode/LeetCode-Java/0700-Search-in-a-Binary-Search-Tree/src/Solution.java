class Solution {
    /**
     * 递归
     */
    public TreeNode searchBST_1(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    /**
     * 迭代
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) return root;
            if (root.val > val) root = root.left;
            else root = root.right;
        }
        return null;
    }
}