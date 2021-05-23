package NO_0297_Serialize_and_Deserialize_Binary_Tree;



import java.util.LinkedList;

public class Codec {

    /**
     * Encodes a tree to a single string.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 利用二叉树的层次遍历方式进行序列化
        StringBuilder res = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null) {
                res.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,");
            }
        }
        return res.toString();
    }

    /**
     * Decodes your encoded data to tree.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] dataArr = data.split(",");
        // 层次遍历逆向还原二叉树
        int index = 0;
        TreeNode root = toNode(dataArr[index]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (index < dataArr.length - 2 && !queue.isEmpty()) {
            TreeNode cur = queue.remove();
            // 添加左子节点
            TreeNode leftNode = toNode(dataArr[++index]);
            cur.left = leftNode;
            // 队列中的节点用于为其赋值孩子节点，若该节点本身为 null，
            // 没有孩子节点，便不再添加到队列中，下同理
            if (leftNode != null) {
                queue.add(leftNode);
            }
            // 添加右子节点
            TreeNode rightNode = toNode(dataArr[++index]);
            cur.right = rightNode;
            if (rightNode != null) {
                queue.add(rightNode);
            }
        }

        return root;
    }

    private TreeNode toNode(String val) {
        if (!"null".equals(val)) {
            return new TreeNode(Integer.parseInt(val));
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String data = "1,null,2,3,null,null";
        TreeNode root = codec.deserialize(data);
        String res = codec.serialize(root);
        System.out.println(res);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));