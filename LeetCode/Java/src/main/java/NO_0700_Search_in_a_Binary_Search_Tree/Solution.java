package NO_0700_Search_in_a_Binary_Search_Tree;


class Solution {
    /**
     * 递归
     */
    public TreeNode searchBST_1(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    /**
     * 迭代
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (true) {
            if (root == null || root.val == val) return root;
            root = root.val > val ? root.left : root.right;
        }
    }
}