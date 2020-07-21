class Solution {

    public int maxDepth(Node root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(Node node, int depth) {
        if (node == null) return depth;
        int maxDepth = depth + 1;
        for (Node child : node.children) {
            maxDepth = Math.max(maxDepth, maxDepth(child, depth + 1));
        }
        return maxDepth;
    }

    public int maxDepth_2(Node root) {
        if (root == null) return 0;
        int maxDepth = 1;
        for (Node child : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth_2(child) + 1);
        }
        return maxDepth;
    }

    public int maxDepth_3(Node root) {
        if (root == null) return 0;
        int maxDepth = 0;
        for (Node child : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth_3(child));
        }
        return maxDepth + 1;
    }
}