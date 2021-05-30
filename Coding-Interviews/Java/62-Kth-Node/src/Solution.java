public class Solution {

    private int k;

    TreeNode KthNode(TreeNode pRoot, int k) {
        this.k = k;
        return kthNode(pRoot);
    }

    TreeNode kthNode(TreeNode pRoot) {
        if (pRoot == null || k == 0) return null;
        // 遍历到最左节点
        if (pRoot.left != null) {
            TreeNode left = KthNode(pRoot.left, k);
            if (left != null) {
                return left;
            }
        }
        // 遍历pRoot
        k--;
        // 遍历右子树
        if (pRoot.right != null) {
            TreeNode right = KthNode(pRoot.right, k);
            if (right != null) {
                return right;
            }
        }
        return k == 0 ? pRoot : null;
    }
}