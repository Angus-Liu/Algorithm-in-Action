package NO_0086_Partition_List;


class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        while (head != null) {
            if (head.val < x) {
                node1.next = head;
                node1 = node1.next;
            } else {
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;
        }
        node1.next = dummyHead2.next;
        node2.next = null;
        return dummyHead1.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(new int[]{1, 4, 3, 2, 5, 2});
        System.out.println(solution.partition(head, 3));
    }
}