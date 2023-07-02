package JZ_Offer_II_026;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur1 = head;
        ListNode cur2 = reverse(slow.next);
        slow.next = null;
        while (cur2 != null) {
            ListNode cur2Next = cur2.next;
            cur2.next = cur1.next;
            cur1.next = cur2;
            cur1 = cur2.next;
            cur2 = cur2Next;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
