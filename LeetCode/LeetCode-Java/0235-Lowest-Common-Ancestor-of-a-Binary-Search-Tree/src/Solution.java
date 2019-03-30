class Solution {
    /**
     * 递归
     */
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {

        // p、q 的值均小于节点的值，则在节点左子树中寻找公共祖先
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // p、q 的值均大于节点的值，则在节点右子树中寻找公共祖先
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // p、q 其一大于或等于root，其一在 root 小于或等于root，此时 root 都为其公共祖先
        return root;
    }

    /**
     * 迭代
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            // p、q 的值均小于节点的值，则在节点左子树中寻找公共祖先
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // p、q 的值均大于节点的值，则在节点右子树中寻找公共祖先
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // p、q 其一大于或等于root，其一在 root 小于或等于root，此时 root 都为其公共祖先
            else {
                return root;
            }
        }
    }
}