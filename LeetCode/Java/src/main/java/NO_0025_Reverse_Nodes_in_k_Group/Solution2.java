package NO_0025_Reverse_Nodes_in_k_Group;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        // pre 为前一组尾节点
        ListNode pre = dummyHead, tail;
        while (head != null) {
            tail = head;
            for (int i = 1; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    pre.next = head;
                    return dummyHead.next;
                }
            }
            // 需保存下一段头节点用于后续翻转
            ListNode next = tail.next;
            reverse(head, tail);
            // reverse 之后 newHead = tail, newTail = head
            // 将前一段与当前段连接，并移到下一段准备翻转
            pre.next = tail;
            pre = head;
            head = next;
        }
        return dummyHead.next;
    }

    private void reverse(ListNode head, ListNode tail) {
        ListNode pre = null, cur = head, next;
        while (pre != tail) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println("head = " + head);
        Solution2 solution = new Solution2();
        head = solution.reverseKGroup(head, 2);
        System.out.println("head = " + head);
    }
}