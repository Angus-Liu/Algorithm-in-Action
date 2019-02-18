public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree != null) {
            TreeNode leftNode = convert(pRootOfTree.left, true);
            pRootOfTree.left = leftNode;
            if (leftNode != null) {
                leftNode.right = pRootOfTree;
            }
            TreeNode rightNode = convert(pRootOfTree.right, false);
            pRootOfTree.right = rightNode;
            if (rightNode != null) {
                rightNode.left = pRootOfTree;
            }
            // 需要返回新的头节点
            while (pRootOfTree.left != null) {
                pRootOfTree = pRootOfTree.left;
            }
        }
        return pRootOfTree;
    }

    private TreeNode convert(TreeNode node, boolean isLeftChild) {
        if (node == null) {
            return null;
        }
        TreeNode leftNode = convert(node.left, true);
        node.left = leftNode;
        if (leftNode != null) {
            leftNode.right = node;
        }
        TreeNode rightNode = convert(node.right, false);
        node.right = rightNode;
        if (rightNode != null) {
            rightNode.left = node;
        }
        if (isLeftChild) {
            return node.left == null ? node : leftNode;
        } else {
            return node.right == null ? node : rightNode;
        }
    }
}