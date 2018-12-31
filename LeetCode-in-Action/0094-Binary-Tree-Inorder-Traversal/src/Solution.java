import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    List<Integer> list = new ArrayList<>();

    /**
     * 递归实现
     */
    public List<Integer> inorderTraversal_1(TreeNode root) {
        if (root != null) {
            inorderTraversal_1(root.left);
            list.add(root.val);
            inorderTraversal_1(root.right);
        }
        return list;
    }

    /**
     * 迭代实现（借助栈的非递归实现）
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            // 一路压入最后一个子树的左孩子
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            // 若该节点有右孩子，则下一步压入其右孩子
            node = node.right;
        }
        return list;
    }
}