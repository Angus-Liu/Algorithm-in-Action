package JZ_Offer_II_022;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head; // 慢指针
        ListNode fast = head; // 快指针
        while (fast != null && fast.next != null) { // 寻找环
            slow = slow.next; // 慢指针移动一步
            fast = fast.next.next; // 快指针移动两步
            if (slow == fast) { // 找到环
                // ▕———————————k—————————————▏
                // ▕————k-i———|——————i———————▏
                // head    环入口点 c     slow，fast 相遇点
                //  ↓         ↓              ↓
                //  X —→ X —→ X —→ X —→ X —→ X —→ X
                //            ↑                   ︳
                //            └─——————————————————┘
                // 假设到相遇点 fast 走了 2k 步，则 slow 走了 k 步
                // 再设环入口点 c 到相遇点的距离为 i，则头节点 head 到环入口点 c 的距离为 k - i
                // 在相遇点时，fast 比 slow 多 k 步，减去 c 到相遇点的 i 步，就是 slow 从相遇点到 c 的距离
                // 故 slow 再次到环入口点 c 的距离也为 k - i
                // 由此便可得到环入口点位置
                ListNode ptr = head; // 新建指针 ptr，从链表头出发
                while (ptr != slow) { // 寻找环入口点
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr; // 返回环入口点
            }
        }
        return null;
    }
}
