import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 参考《算法（第4版）》- 3.2 二叉查找树
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            // 待删除节点在左子树中
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            // 待删除节点在右子树中
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // key == root.val，root 为待删除节点
            if (root.left == null) {
                // 返回右子树作为新的根
                return root.right;
            } else if (root.right == null) {
                // 返回左子树作为新的根
                return root.left;
            } else {
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                TreeNode successor = min(root.right);
                successor.right = deleteMin(root.right);
                successor.left = root.left;
                return successor;
            }
        }
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    private static void printTree(TreeNode node) {
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur != null) {
                res.append(cur.val).append(",");
                queue.add(cur.left);
                queue.add(cur.right);
            } else {
                res.append("null,");
            }
        }
        System.out.println(res.toString());
    }

    public static void main(String[] args) {
        // 5,3,6,2,4,x,7
        // 5,4,6,2,x,x,7
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(6);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(2);
        left.right = new TreeNode(4);
        right.right = new TreeNode(7);

        printTree(root);

        new Solution().deleteNode(root, 3);

        printTree(root);
    }
}