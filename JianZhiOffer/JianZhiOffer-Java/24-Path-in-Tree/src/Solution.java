import java.util.ArrayList;

public class Solution {

    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        findInPath(root, target, 0);
        return res;
    }

    private void findInPath(TreeNode node, int target, int sum) {
        if (node == null) {
            return;
        }
        sum += node.val;
        path.add(node.val);
        // 必须保证是叶子节点
        if (sum == target && node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
        } else if (sum < target) {
            findInPath(node.left, target, sum);
            findInPath(node.right, target, sum);
        }
        path.remove(path.size() - 1);
    }
}