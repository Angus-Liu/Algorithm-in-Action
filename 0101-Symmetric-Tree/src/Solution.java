class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    /**
     * 该方法亦可用以比较两棵树是否对称
     *
     * @param root1
     * @param root2
     * @return
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
}