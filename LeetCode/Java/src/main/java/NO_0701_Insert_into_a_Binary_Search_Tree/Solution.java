package NO_0701_Insert_into_a_Binary_Search_Tree;

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                } else {
                    cur = cur.left;
                }
            } else if (cur.val < val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                } else {
                    cur = cur.right;
                }
            } else {
                break;
            }
        }
        return root;
    }
}