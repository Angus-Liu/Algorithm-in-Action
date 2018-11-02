import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // 利用二叉树的层序遍历，返回每层的最后一个即可
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        // 创建一个队列，用于存放所有节点
        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            int size = currentLevel.size();
            for (int i = 0; i < size; i++) {
                // poll 获取并移除此列表的头结点
                TreeNode currentNode = currentLevel.poll();
                if (i == size - 1) {
                    list.add(currentNode.val);
                }
                // 将该节点的左右孩子推入队列
                if (currentNode.left != null) {
                    currentLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    currentLevel.add(currentNode.right);
                }
            }
        }
        return list;
    }
}