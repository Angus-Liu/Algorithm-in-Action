import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> binaryTreePaths(TreeNode node) {
        List<String> paths = new ArrayList<>();
        // 该节点为空，直接返回
        if (node == null) {
            return paths;
        }
        // 该节点为叶子节点
        if (node.left == null && node.right == null) {
            paths.add(node.val + "");
            return paths;
        }
        // 该节点为非叶子节点，与其子节点返回路径组合
        List<String> leftPaths = binaryTreePaths(node.left);
        for (String leftPath : leftPaths) {
            paths.add(node.val + "->" + leftPath);
        }
        List<String> rightPaths = binaryTreePaths(node.right);
        for (String rightPath : rightPaths) {
            paths.add(node.val + "->" + rightPath);
        }
        return paths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        System.out.println(new Solution().binaryTreePaths(root));
    }
}