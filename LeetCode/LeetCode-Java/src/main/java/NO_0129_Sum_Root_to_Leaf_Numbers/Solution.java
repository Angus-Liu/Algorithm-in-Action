package NO_0129_Sum_Root_to_Leaf_Numbers;

class Solution {
    public int sumNumbers(TreeNode root) {
        // 利用深搜解决
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int sum) {
        // 重要：非叶子节点，返回 0
        if (node == null) {
            return 0;
        }
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        } else {
            return dfs(node.left, sum) + dfs(node.right, sum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        right.left = new TreeNode(4);
        right.right = new TreeNode(5);
        System.out.println(new Solution().sumNumbers(root));
    }
}