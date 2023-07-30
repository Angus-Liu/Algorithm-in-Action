package JZ_Offer_II_031;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private final int capacity;

    private final Map<Integer, Node> map;

    private final Node head;

    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
        } else {
            remove(node);
            node.value = value;
        }
        add(node);
        map.put(key, node);
        if (map.size() > capacity) {
            Node needDeleted = tail.prev;
            map.remove(needDeleted.key);
            remove(needDeleted);
        }
    }

    private void add(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private void moveToHead(Node node) {
        remove(node);
        add(node);
    }

    private static class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */