public class Solution {

    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        getHigh(root);
        return isBalanced;
    }

    /**
     * 借助于后序遍历，每个节点只需遍历一次
     *
     * @param node
     * @return
     */
    private int getHigh(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHigh = getHigh(node.left);
        int rightHigh = getHigh(node.right);
        if (Math.abs(leftHigh - rightHigh) > 1) {
            isBalanced = false;
        }
        return Math.max(leftHigh, rightHigh) + 1;
    }
}