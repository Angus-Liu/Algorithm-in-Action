package NO_0098_Validate_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isValidBST1(TreeNode root) {
        // 利用二分搜索树的中序遍历来判断
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        if (node.val <= lower || node.val >= upper) return false;
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}