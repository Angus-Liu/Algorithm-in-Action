import java.util.LinkedList;

class BSTIterator {

    private LinkedList<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        // 初始化时把所有左子树压入栈
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        // 栈顶节点即为当前最小节点
        TreeNode smallestNode = stack.pop();
        int val = smallestNode.val;
        // 出栈后需要将其右子树及其右子树的左子树压入栈
        smallestNode = smallestNode.right;
        while (smallestNode != null) {
            stack.push(smallestNode);
            smallestNode = smallestNode.left;
        }
        return val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}