public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return constructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode constructBinaryTree(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        // 前序遍历的第一个节点即是根节点
        if (ps > pe || is > ie) {
            return null;
        }
        int rootValue = pre[ps];
        TreeNode root = new TreeNode(rootValue);
        // 在中序遍历中找到根节点，将树分为左右子树，递归该过程重建子树
        for (int i = is; i <= ie; i++) {
            if (in[i] == rootValue) {
                // int leftLength = i - is;
                // int rightLength = ie - i;
                root.left = constructBinaryTree(pre, ps + 1, ps + i - is, in, is, i - 1);
                root.right = constructBinaryTree(pre, ps + i - is + 1, pe, in, i + 1, ie);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};
        TreeNode tree = new Solution().reConstructBinaryTree(pre, in);
        System.out.println(tree);
    }
}