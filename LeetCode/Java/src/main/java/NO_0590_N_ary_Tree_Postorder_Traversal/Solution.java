package NO_0590_N_ary_Tree_Postorder_Traversal;

import java.util.*;

class Solution {

    private final List<Integer> res = new ArrayList<>();

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
    public List<Integer> postorder2(Node root) {
        if (root == null) return res;
        Deque<Node> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node node = stack.getLast();
            if (node.children == null) {
                res.add(stack.removeLast().val);
            } else {
                // 注意，靠右的孩子先入栈
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.addLast(node.children.get(i));
                }
                // 表示已遍历过其子节点（不太好，直接改变原节点信息了，但比较简单）
                // 可改为用一个 map 记录当前节点的孩子全被访问过
                node.children = null;
            }
        }
        return res;
    }

    static class EnhanceNode extends Node {
        boolean childrenHasVisited;

        public EnhanceNode(Node node) {
            this.val = node.val;
            this.children = node.children;
            this.childrenHasVisited = node.children == null || node.children.size() == 0;
        }
    }

    /**
     * 迭代实现（借助栈）
     */
    public List<Integer> postorder3(Node root) {
        if (root == null) return res;
        Deque<EnhanceNode> stack = new ArrayDeque<>();
        stack.addLast(new EnhanceNode(root));
        while (!stack.isEmpty()) {
            EnhanceNode node = stack.getLast();
            if (node.childrenHasVisited) {
                res.add(stack.removeLast().val);
            } else {
                // 注意，靠右的孩子先入栈
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.addLast(new EnhanceNode(node.children.get(i)));
                }
                // 表示已遍历过其子节点
                node.childrenHasVisited = true;
            }
        }
        return res;
    }
}