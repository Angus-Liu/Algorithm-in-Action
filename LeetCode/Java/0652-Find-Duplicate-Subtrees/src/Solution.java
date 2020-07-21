import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        findDuplicateSubtrees(root, map, res);
        return res;
    }

    /**
     * 后序遍历，将路径作为 map 的 key，路径出现次数作为 value
     * 先确定子树的结构，继而得到整棵树的重复子树情况
     */
    private String findDuplicateSubtrees(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
        if (node == null) {
            return "#";
        }
        String leftPath = findDuplicateSubtrees(node.left, map, res);
        String rightPath = findDuplicateSubtrees(node.right, map, res);
        String path = node.val + leftPath + rightPath;
        map.put(path, map.getOrDefault(path, 0) + 1);
        // 因 TreeNode 未重写 equals 和 hashCode 方法，
        // 故而需要根据 path 的出现次数，限制 res 中相同子树只添加一次
        if (map.get(path) == 2) {
            res.add(node);
        }
        return path;
    }
}