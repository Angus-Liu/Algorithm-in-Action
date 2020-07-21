class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        if (ld == rd) {
            // 左子树是满二叉树，右子树是完全二叉树
            // 1 + (2^ld - 1) + countNodes(root.right))
            return (1 << ld) + countNodes(root.right);
        } else {
            // ld > rd
            // 左子树是完全二叉树，右子树是满二叉树
            // 1 + countNodes(root.left) + (2^rd - 1)
            return (1 << rd) + countNodes(root.left);
        }
    }

    /**
     * 获取节点所在子树高度
     */
    public int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        root.left = left;
        TreeNode right = new TreeNode(2);
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        right.left = new TreeNode(5);
        System.out.println(new Solution().countNodes(root));
    }
}