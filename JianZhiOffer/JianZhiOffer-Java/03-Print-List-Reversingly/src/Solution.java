import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        while (listNode != null) {
            res.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(res);
        return res;
    }
}