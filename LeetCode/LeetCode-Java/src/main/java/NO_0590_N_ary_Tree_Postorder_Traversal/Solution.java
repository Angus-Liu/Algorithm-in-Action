package NO_0590_N_ary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<Integer> res = new ArrayList<>();

    /**
     * 递归实现
     */
    public List<Integer> postorder(Node root) {
        if (root != null) {
            for (Node child : root.children) {
                postorder(child);
            }
            res.add(root.val);
        }
        return res;
    }

    /**
     * 迭代实现（借助栈）
     */
    public List<Integer> postorder_2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node.children == null) {
                res.add(stack.pop().val);
            } else {
                // for (int i = node.children.size() - 1; i >= 0; i--) {
                //     stack.push(node.children.get(i));
                // }
                stack.addAll(0, node.children);
                // 表示已遍历过其子节点（不太好，直接改变原节点信息了，但比较简单）
                node.children = null;
            }
        }
        return res;
    }
}