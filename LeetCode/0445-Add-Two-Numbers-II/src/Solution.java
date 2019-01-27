import java.util.LinkedList;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> stack1 = new LinkedList<>();
        LinkedList<ListNode> stack2 = new LinkedList<>();
        LinkedList<ListNode> temp;
        while (l1 != null) {
            stack1.addLast(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.addLast(l2);
            l2 = l2.next;
        }
        if (stack1.size() < stack2.size()) {
            temp = stack1;
            stack1 = stack2;
            stack2 = temp;
        }
        ListNode head = stack1.peekFirst();
        int sum = 0;
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode n1 = stack1.removeLast();
            ListNode n2 = stack2.removeLast();
            sum = n1.val + n2.val + carry;
            n1.val = sum % 10;
            carry = sum / 10;
        }
        while (carry != 0) {
            if (!stack1.isEmpty()) {
                ListNode n1 = stack1.removeLast();
                sum = n1.val + carry;
                n1.val = sum % 10;
                carry = sum / 10;
            } else {
                ListNode newHead = new ListNode(carry);
                newHead.next = head;
                return newHead;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{7, 4, 4, 5});
        ListNode l2 = new ListNode(new int[]{2, 5, 5, 5});
        System.out.println(new Solution().addTwoNumbers(l1, l2));
    }
}