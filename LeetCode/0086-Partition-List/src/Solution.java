class Solution {
    /**
     * 此方法没有保留两个分区中每个节点的初始相对位置，不可行
     */
    public ListNode partition1(ListNode head, int x) {
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null && cur.val >= x) {
            cur = cur.next;
        }
        while (pre != null && cur != null) {
            if (pre.val >= x) {
                int temp = pre.val;
                pre.val = cur.val;
                cur.val = temp;
                pre = pre.next;
                while (cur != null && cur.val >= x) {
                    cur = cur.next;
                }
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        while (head != null) {
            if (head.val < x) {
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;
            } else {
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = dummyHead2.next;
        return dummyHead1.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(new int[]{1, 4, 3, 2, 5, 2});
        System.out.println(solution.partition(head, 3));
    }
}