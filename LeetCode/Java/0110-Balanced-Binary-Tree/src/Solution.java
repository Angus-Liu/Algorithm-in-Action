class Solution {

    /**
     * 检查每个节点的平衡因子，判断该树是否是一课平衡树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 先判断该节点是否满足平衡二叉树性质
        int balanceFactor = getBalanceFactor(root);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        // 递归判断该节点的子树是否满足平衡二叉树性质
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 计算该节点的平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * 返回 node 所在的高度
     *
     * @param node
     * @return
     */
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    /**
     * 更好的解法，只遍历每个节点一次
     */
    private boolean flag = true;

    public boolean isBalanced2(TreeNode root) {
        getHigh(root);
        return flag;
    }

    private int getHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHigh = getHigh(root.left);
        int rightHigh = getHigh(root.right);
        if (Math.abs(leftHigh - rightHigh) > 1) {
            flag = false;
        }
        return Math.max(leftHigh, rightHigh) + 1;
    }
}