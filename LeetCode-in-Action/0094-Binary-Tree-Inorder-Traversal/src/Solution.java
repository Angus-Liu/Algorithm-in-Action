import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    List<Integer> list = new ArrayList<>();

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root != null) {
            inorderTraversal1(root.left);
            list.add(root.val);
            inorderTraversal1(root.right);
        }
        return list;
    }

    /**
     * 迭代实现
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 借助栈的非递归实现
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
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