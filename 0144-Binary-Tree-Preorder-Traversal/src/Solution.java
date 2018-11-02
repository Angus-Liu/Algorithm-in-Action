import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    List<Integer> list = new ArrayList<>();

    /**
     * 递归算法，若非递归需借助栈实现
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }

    /**
     * 迭代实现（借助栈）
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.empty()) {
            while(node != null) {
                list.add(node.val);
                stack.push(node);
                // 访问左孩子
                node = node.left;
            }
            node = stack.pop();
            // 访问右孩子
            node = node.right;
        }
        return list;
    }
}