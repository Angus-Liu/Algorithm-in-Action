package NO_0226_Invert_Binary_Tree;



class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 递归反转左右子树
        invertTree(root.left);
        invertTree(root.right);

        // 反转左右子树
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        return root;
    }
}