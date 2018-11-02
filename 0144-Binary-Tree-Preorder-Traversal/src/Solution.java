import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> list = new ArrayList<>();

    /**
     * 递归算法，若非递归需借助栈实现
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
}