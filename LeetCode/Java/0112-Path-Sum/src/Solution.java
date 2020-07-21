class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 该题的重点在于递归终止条件
        if (root == null) {
            return false;
        }
        // 确保该点为叶子节点
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}