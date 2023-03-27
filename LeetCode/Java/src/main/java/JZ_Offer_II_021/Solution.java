package JZ_Offer_II_021;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = dummy;
        while (n-- > 0) {
            front = front.next;
        }
        ListNode rear = dummy;
        while (front.next != null) {
            front = front.next;
            rear = rear.next;
        }
        rear.next = rear.next.next;
        return dummy.next;
    }
}
