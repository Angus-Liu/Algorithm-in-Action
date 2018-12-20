import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder_1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //  队列中同时保存节点及其层级信息
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int level = pair.getValue();
            // level == size 时，这时 res 中还没有对应该层节点的 list
            if (level == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);
            if (node.left != null) {
                queue.add(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, level + 1));
            }
        }

        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        // 创建一个队列，用于存放所有节点
        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            // 创建一个List记录当前层所有节点值
            List<Integer> currentList = new LinkedList<>();
            int size = currentLevel.size();
            for (int i = 0; i < size; i++) {
                // poll()获取并移除此列表的头结点
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
            list.add(currentList);
        }
        return list;
    }
}