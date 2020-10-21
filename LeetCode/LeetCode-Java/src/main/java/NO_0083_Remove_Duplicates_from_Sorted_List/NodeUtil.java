package NO_0083_Remove_Duplicates_from_Sorted_List;



/**
 * @author Angus
 * @date 2018/11/1
 */
public class NodeUtil {
    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        StringBuilder res = new StringBuilder();
        while (cur != null) {
            res.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        res.append("NULL");
        System.out.println(res.toString());
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = createList(arr);
        printList(head);
    }
}
