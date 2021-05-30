public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        if (this.left != null) {
            res.append(left);
        }
        res.append(val).append(" ");
        if (this.right != null) {
            res.append(right);
        }
        return res.toString();
    }
}