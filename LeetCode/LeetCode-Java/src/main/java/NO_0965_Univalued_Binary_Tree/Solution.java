package NO_0965_Univalued_Binary_Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isUnivalTree(root, root.left) && isUnivalTree(root, root.right);
    }

    private boolean isUnivalTree(TreeNode root, TreeNode child) {
        if (child == null) {
            return true;
        }
        if (root.val != child.val) {
            return false;
        }
        return isUnivalTree(child, child.left) && isUnivalTree(child, child.right);
    }
}