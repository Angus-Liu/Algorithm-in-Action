import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<TreeNode> nodes = new ArrayList<>();

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        inOrderTraverse(pRootOfTree);
        for (int i = 0; i < nodes.size(); i++) {
            if (i - 1 >= 0)
                nodes.get(i).left = nodes.get(i - 1);
            if (i + 1 < nodes.size())
                nodes.get(i).right = nodes.get(i + 1);
        }
        return nodes.get(0);
    }

    private void inOrderTraverse(TreeNode node) {
        if (node == null) return;
        inOrderTraverse(node.left);
        nodes.add(node);
        inOrderTraverse(node.right);
    }
}