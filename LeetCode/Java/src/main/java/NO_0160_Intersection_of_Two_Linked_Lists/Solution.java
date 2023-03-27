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
        if (headA == null || headB == null) return null;
        // 定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部,
        // 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
        // 两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
        ListNode curA = headA, curB = headB;
        // 在这里第一轮体现在curA和curB第一次到达尾部会移向另一链表的表头,
        // 而第二轮体现在如果curA或curB相交就返回交点, 不相交最后就是null==null
        while (curA != curB) {
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