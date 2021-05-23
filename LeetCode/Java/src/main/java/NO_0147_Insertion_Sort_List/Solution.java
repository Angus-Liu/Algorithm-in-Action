package NO_0147_Insertion_Sort_List;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);

        while (head != null) {
            ListNode node = dummyHead;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(new int[]{2, 1, 23, 4, 5, 6, -1, 0});
        System.out.println(new Solution().insertionSortList(list));
    }
}