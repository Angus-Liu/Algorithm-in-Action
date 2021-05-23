package NO_0328_Odd_Even_Linked_List;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode o = head;
        ListNode p = head.next;
        ListNode e = p;
        while (o.next != null && e.next != null) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(new Solution().oddEvenList(list));
    }
}