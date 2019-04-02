public class Solution {

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k == 0) return null;
        // 遍历到最左节点
        if (pRoot.left != null) {
            TreeNode left = KthNode(pRoot.left, k);
            if (left != null) {
                return left;
            }
        }
        // k == 1 时即为结果
        if (k == 1) return pRoot;
        if (pRoot.right != null) {
            TreeNode right = KthNode(pRoot.right, --k);
            if (right != null) {
                return right;
            }
        }
        return null;
    }
}