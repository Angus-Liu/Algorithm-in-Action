import java.util.List;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 使用虚拟头结点以及滑动窗口（大小为 n + 2）来解决
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }
        // 移动窗口，使得 p 指向待删除节点的前一个节点
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        ListNode delNode = p.next;
        p.next = delNode.next;
        delNode.next = null;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(new Solution().removeNthFromEnd(head, 2));
    }
}