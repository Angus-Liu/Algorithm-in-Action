class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 利用虚拟头节点简化算法
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode next = dummyHead.next;
        while (cur.next != null) {
            if (next.next != null && cur.next.val == next.next.val) {
                next = next.next;
            } else {
                if (cur.next == next) {
                    cur = cur.next;
                    next = next.next;
                } else {
                    cur.next = next.next;
                    next = next.next;
                }
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 1, 1});
        Solution solution = new Solution();
        head = solution.deleteDuplicates(head);
        System.out.println(head);
    }
}