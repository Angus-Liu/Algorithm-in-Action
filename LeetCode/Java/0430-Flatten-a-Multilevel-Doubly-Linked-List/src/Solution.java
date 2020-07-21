import java.util.LinkedList;

class Solution {
    /**
     * 借助栈
     */
    public Node flatten_1(Node head) {
        if (head == null) return null;
        LinkedList<Node> stack = new LinkedList<>();
        Node cur = head;
        while (true) {
            if (cur.child != null) {
                // 将 next 节点入栈
                if (cur.next != null) {
                    stack.push(cur.next);
                }
                // 将子链表扁平化
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
            // 遍历子链表的下一个节点或是从栈中弹出 next 节点
            if (cur.next != null) {
                cur = cur.next;
            } else if (!stack.isEmpty()) {
                Node next = stack.pop();
                cur.next = next;
                next.prev = cur;
                cur = next;
            } else {
                return head;
            }
        }
    }

    /**
     * 递归
     */
    public Node flatten(Node head) {
        if (head == null) return null;
        Node cur = head;
        // 向后遍历
        while (cur != null) {
            // 存在子链表，进行递归
            if (cur.child != null) {
                // 保留 next 节点
                Node next = cur.next;
                // 得到扁平化后的子链表，与之相连
                Node child = flatten(cur.child);
                cur.next = child;
                child.prev = cur;
                cur.child = null;
                // 连接原 next
                if (next != null) {
                    while (cur.next != null) {
                        cur = cur.next;
                    }
                    cur.next = next;
                    next.prev = cur;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}