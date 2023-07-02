package JZ_Offer_II_028;

import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        Deque<Node> stack = new ArrayDeque<>();
        stack.addLast(head);
        Node dummyHead = new Node();
        Node cur = dummyHead;
        while (!stack.isEmpty()) {
            Node top = stack.removeLast();
            if (top.next != null) {
                stack.addLast(top.next);
                top.next = null;
            }
            if (top.child != null) {
                stack.addLast(top.child);
                top.child = null;
            }
            cur.next = top;
            top.prev = cur;
            cur = cur.next;
        }
        dummyHead.next.prev = null;
        return dummyHead.next;
    }
}
