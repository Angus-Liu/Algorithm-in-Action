package JZ_Offer_II_023;

class Solution {
    /**
     * 指针追逐
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        // 定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部,
        // 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
        // 两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
        ListNode curA = headA, curB = headB;
        // 在这里第一轮体现在 curA 和 curB 第一次到达尾部会移向另一链表的表头,
        // 而第二轮体现在如果 curA 或 curB 相交就返回交点, 不相交最后就是 null == null
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
