package NO_0206_Reverse_Linked_List;

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
     * 递归
     */
    public ListNode reverseList1(ListNode head) {
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
     * 迭代：借助三个指针实现
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            // 进行变换
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 迭代：dummyHead + 头插法
     */
    public ListNode reverseList(ListNode head) {
        // 虚拟头结点一开始并不连接到链表头结点（或者理解为构造了一条新的链表更为合适）
        ListNode dummyHead = new ListNode(0);
        while (head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
        }
        return dummyHead.next;
    }
}