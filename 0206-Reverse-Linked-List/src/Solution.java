/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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
}