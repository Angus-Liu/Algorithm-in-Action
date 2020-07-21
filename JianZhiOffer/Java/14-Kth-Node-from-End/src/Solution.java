public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode start = head, end = head;
        for (int i = 0; i < k - 1; i++) {
            if (end.next != null) {
                end = end.next;
            } else {
                return null;
            }
        }
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        return start;
    }
}