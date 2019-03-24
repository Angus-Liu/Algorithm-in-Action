import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val, null, null));
            cur = cur.next;
        }
        map.forEach((k, v) -> {
            v.next = map.get(k.next);
            v.random = map.get(k.random);
        });
        return map.get(head);
    }
}