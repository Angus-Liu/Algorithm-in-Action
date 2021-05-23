package NO_0002_Add_Two_Numbers;

class Solution {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode pre = null;
        int carried = 0;
        while (n1 != null || n2 != null) {
            int a = n1 == null ? 0 : n1.val;
            int b = n2 == null ? 0 : n2.val;
            if (n1 != null) {
                n1.val = (a + b + carried) % 10;
            } else {
                pre.next = new ListNode((a + b + carried) % 10);
                n1 = pre.next;
            }
            carried = (a + b + carried) / 10;
            pre = n1;
            n1 = n1.next;
            if (n2 != null) {
                n2 = n2.next;
            }
        }
        pre.next = carried != 0 ? new ListNode(carried) : null;
        return l1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{5});
        ListNode l2 = new ListNode(new int[]{5});
        System.out.println(new Solution().addTwoNumbers(l1, l2));
    }
}