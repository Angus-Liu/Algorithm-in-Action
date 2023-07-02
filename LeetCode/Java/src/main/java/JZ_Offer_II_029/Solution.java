package JZ_Offer_II_029;

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}

class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            head = node;
            head.next = head;
        } else if (head.next == head) {
            head.next = node;
            node.next = head;
        } else {
            Node cur = head;
            Node next = head.next;
            Node biggest = head;
            while (!(cur.val <= node.val && node.val <= next.val) && next != head) {
                cur = next;
                next = next.next;
                if (cur.val >= biggest.val) {
                    biggest = cur;
                }
            }
            if (cur.val <= node.val && node.val <= next.val) {
                node.next = next;
                cur.next = node;
            } else {
                node.next = biggest.next;
                biggest.next = node;
            }
        }
        return head;
    }
}
