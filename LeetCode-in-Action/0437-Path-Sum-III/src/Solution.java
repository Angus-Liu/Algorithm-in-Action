class Solution {

    /**
     * 在以 root 为根节点的二叉树中，寻找和为 sum 的路径，返回路径个数
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 处理包含该节点的情况
        int res = findPath(root, sum);
        // 处理不包含该节点的情况
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    /**
     * 在以 node 为根节点的二叉树中，寻找包含 node 的路径，其和为 num
     *
     * @param node
     * @param num
     * @return
     */
    private int findPath(TreeNode node, int num) {
        // 该题不要求路径终点为叶子节点
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val == num) {
            // 注意，这里不能直接返回 res，因路径中可能有负数，
            // 所以接下来还可能有包含该节点且和为 num 的路径
            res += 1;
        }
        res += findPath(node.left, num - node.val);
        res += findPath(node.right, num - node.val);

        return res;
    }
}