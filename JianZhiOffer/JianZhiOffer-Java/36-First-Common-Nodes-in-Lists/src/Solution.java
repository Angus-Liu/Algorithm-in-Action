import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> nodes = new HashSet<>();
        while (pHead1 != null) {
            nodes.add(pHead1);
            pHead1 = pHead1.next;
        }
        ListNode res = null;
        while (pHead2 != null) {
            if (nodes.contains(pHead2)) {
                res = pHead2;
                break;
            }
            pHead2 = pHead2.next;
        }
        return res;
    }
}