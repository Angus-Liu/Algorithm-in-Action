package NO_0024_Swap_Nodes_in_Pairs;

class Solution {
    public ListNode swapPairs(ListNode head) {
        // 借助虚拟头结点简化算法
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            // p.next.next
            ListNode node2 = node1.next;

            // 交换位置
            node1.next = node2.next;
            node2.next = node1;
            p.next = node2;
            // p 指向下一轮交换的前一个节点
            p = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(new Solution().swapPairs(head));
    }
}