class Solution {

    private int index;

    public int kthSmallest(TreeNode root, int k) {
        // 二分查找，中序遍历
        int res = 0;
        if (root == null) {
            return res;
        }
        res = kthSmallest(root.left, k);
        if (index == k) {
            return res;
        }
        if (++index == k) {
            return root.val;
        }
        return kthSmallest(root.right, k);
    }
}