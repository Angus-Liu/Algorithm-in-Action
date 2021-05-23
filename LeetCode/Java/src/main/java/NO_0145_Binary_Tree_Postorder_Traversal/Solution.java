package NO_0145_Binary_Tree_Postorder_Traversal;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    List<Integer> list = new ArrayList<>();


    /**
     * 递归实现
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }

    /**
     * 后续遍历栈方式
     * 需要增加一个节点记录，用于记录上次出栈的节点
     * 1、如果栈顶元素非空且左节点存在，将其入栈，重复该过程。
     *    若不存在则进入第2步（该过程和中序遍历一致）
     * 2、判断上一次出栈节点是否当前节点的右节点，或者当前节
     *    点是否存在右节点，满足任一条件，将当前节点输出，并
     *    出栈。否则将右节点压栈。跳至第1步
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode lastNode = null;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == lastNode) {
                lastNode = stack.pop();
                list.add(node.val);
                node = null;
            } else {
                node = node.right;
            }
        }
        return list;
    }
}
