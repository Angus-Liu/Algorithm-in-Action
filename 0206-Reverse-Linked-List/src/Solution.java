/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 递归实现
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 递归到最后一个节点
        if (head == null || head.next == null) {
            return head;
        }
        // 将最后一个节点作为新的头节点保留
        ListNode newHead = reverseList(head.next);
        // 将后一个节点指向当前节点
        head.next.next = head;
        // 防止在原头节点处成环
        head.next = null;
        return newHead;
    }

    /**
     * 借助三个指针实现
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        // 递归到最后一个节点
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            // 进行变换
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}