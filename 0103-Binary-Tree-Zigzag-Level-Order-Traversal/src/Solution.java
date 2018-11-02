import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if (root == null) {
            return list;
        }
        // 创建一个队列，用于存放所有节点
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        currentLevel.add(root);
        int level = 0;
        while (!currentLevel.isEmpty()) {
            // 创建一个 List 记录当前层所有节点值
            List<Integer> currentList = new LinkedList<Integer>();
            int size = currentLevel.size();
            for (int i = 0; i < size; i++) {
                // poll 获取并移除此列表的头结点
                TreeNode currentNode = currentLevel.poll();
                currentList.add(currentNode.val);
                // 记录每一层的节点值到List<Integer>中
                if (currentNode.left != null) {
                    currentLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    currentLevel.add(currentNode.right);
                }
                // 将当前List<Integer>添加到List<List<Integer>>中
            }
            if (level % 2 != 0) {
                // 将 currentList 倒序，满足题目要求
                Collections.reverse(currentList);
            }
            level++;
            list.add(currentList);
        }
        return list;
    }
}