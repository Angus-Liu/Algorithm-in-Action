import java.util.ArrayList;
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
     * 非递归写法（借用栈实现）
     */
    public List<Integer> preorderByStack(Node root) {
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.add(root);
        }
        while(!stack.empty()) {
            Node node = stack.pop();
            res.add(node.val);
            // 注意，这里是逆序，使得左孩子在栈顶
            for (int i = node.children.size() -1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
        return res;
    }
}