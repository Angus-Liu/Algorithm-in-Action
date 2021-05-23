package NO_0098_Validate_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isValidBST(TreeNode root) {
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

    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidBST2(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        } else if (root.val <= min || root.val >= max) {
            return false;
        } else {
            return isValidBST2(root.left, root.val, min) && isValidBST2(root.right, max, root.val);
        }
    }
}