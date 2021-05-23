package NO_0019_Remove_Nth_Node_From_End_of_List;

class Solution {
    /**
     * 使用虚拟头结点以及滑动窗口（大小为 n + 2）来解决
     */
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 双指针
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

    private int m;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        m = n;
        if (head == null) {
            return null;
        }
        removeNthFromEnd(head.next, m);
        if (m-- == 0) {
            head.next = head.next.next;
        }
        if (m == 0) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1});
        System.out.println(new Solution().removeNthFromEnd(head, 1));
    }
}