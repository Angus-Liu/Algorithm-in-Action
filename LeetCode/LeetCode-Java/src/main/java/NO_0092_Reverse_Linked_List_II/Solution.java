package NO_0092_Reverse_Linked_List_II;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 最终为 m 位置的前一点
        ListNode mPre = dummyHead;
        // 最终为 n 位置的后一点
        ListNode nNext;
        // 待反转的两点
        ListNode cur;
        ListNode next;
        for (int i = 0; i < m - 1; i++) {
            mPre = mPre.next;
        }
        cur = mPre.next;
        next = cur.next;
        nNext = next;
        for (int i = 0; i < n - m; i++) {
            // 进行反转
            nNext = next.next;
            next.next = cur;
            // 移动到下一个反转处
            cur = next;
            next = nNext;
        }
        // 反转完毕，需要将两端与 mPre 和 nNext 连接
        mPre.next.next = nNext;
        mPre.next = cur;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(new Solution().reverseBetween(head, 1, 5));
    }
}