public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        boolean hasLoop = false;
        ListNode slow = pHead;
        ListNode fast = pHead;
        // 先判断是否有循环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }
        if (hasLoop) {
            while (pHead != slow) {
                pHead = pHead.next;
                slow = slow.next;
            }
            return pHead;
        }
        return null;
    }
}