import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // 使用深度优先遍历解决
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, res, path, 0, sum);
        return res;
    }

    private void dfs(TreeNode node, List<List<Integer>> res, LinkedList<Integer> path, int pathSum, int sum) {
        path.addLast(node.val);
        pathSum += node.val;

        // 判断是否为叶子节点
        if (node.left == null && node.right == null) {
            if (pathSum == sum) {
                res.add(new LinkedList<>(path));
            }
        } else {
            if (node.left != null) {
                dfs(node.left, res, path, pathSum, sum);
            }
            if (node.right != null) {
                dfs(node.right, res, path, pathSum, sum);
            }
        }
        // 介于 Java 值传递的原因，只需修改 path，无需修改 pathSum
        // 本次访问结束，弹出该节点
        path.removeLast();
//        System.out.println(path);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        System.out.println(new Solution().pathSum(root, 12));
    }
}