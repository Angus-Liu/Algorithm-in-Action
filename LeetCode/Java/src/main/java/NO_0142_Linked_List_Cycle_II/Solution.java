package NO_0142_Linked_List_Cycle_II;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * 哈希表
     */
    public ListNode detectCycle_1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 双指针
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // slow 保存 fast 和 slow 相遇的节点
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            while (slow != head) {
                slow = slow.next;
                head = head.next;
            }
            return slow;
        }
        return null;
    }
}