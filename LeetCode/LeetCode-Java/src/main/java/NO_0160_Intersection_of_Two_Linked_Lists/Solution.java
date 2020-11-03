package NO_0160_Intersection_of_Two_Linked_Lists;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 哈希表，不满足 O(1) 空间复杂度
     */
    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 比较链表长度
     */
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLen(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    /**
     * 指针追逐
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            // 第一轮结束时，指针指向另一条链表的头结点，继续遍历，这样便消除了两条链表的长度差
            // 第二轮若链表相交，就返回相交节点，否者，最后返回 null
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode res = new Solution().getIntersectionNode(node, node);
        System.out.println(res);
    }
}