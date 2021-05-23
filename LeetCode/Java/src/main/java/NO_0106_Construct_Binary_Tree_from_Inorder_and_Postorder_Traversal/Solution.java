package NO_0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;



class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie) {
            return null;
        }
        // 后序遍历最后一个节点为根节点
        int rootVal = postorder[pe];
        TreeNode root = new TreeNode(rootVal);
        // 确定根节点在中序遍历中的位置
        int im = is;
        while (im < ie && inorder[im] != rootVal) {
            im++;
        }
        // 根据根节点在中序遍历中的位置得到左右子树的中序遍历和后序遍历序列
        root.left = buildTree(inorder, is, im - 1, postorder, ps, ps + (im - 1 - is));
        root.right = buildTree(inorder, im + 1, ie, postorder, ps + (im - is), pe - 1);
        return root;
    }


    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode tree = new Solution().buildTree(inorder, postorder);
    }
}