package NO_0404_Sum_of_Left_Leaves;

class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        // 左孩子存在，且为叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
//            System.out.println("root.left.val: " + root.left.val);
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        System.out.println(new Solution().sumOfLeftLeaves(root));
    }
}