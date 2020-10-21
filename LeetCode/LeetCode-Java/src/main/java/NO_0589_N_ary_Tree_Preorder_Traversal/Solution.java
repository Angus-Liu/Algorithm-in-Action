package NO_0589_N_ary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {

    private List<Integer> res = new ArrayList<>();

    /**
     * 递归写法
     */
    public List<Integer> preorder(Node root) {
        if (root != null) {
            res.add(root.val);
            for (Node child : root.children) {
                preorder(child);
            }
        }
        return res;
    }

    /**
     * 迭代（借用栈实现）
     */
    public List<Integer> preorder_2(Node root) {
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.add(root);
        }
        while (!stack.empty()) {
            Node node = stack.pop();
            res.add(node.val);
            // 注意，这里是逆序，使得左孩子在栈顶
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
        return res;
    }

    /**
     * 迭代（队列当栈用）
     */
    public List<Integer> preorder_3(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.addFirst(root);
        }
        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            res.add(node.val);
            queue.addAll(0, node.children);
        }
        return res;
    }
}