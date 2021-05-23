package NO_0706_Design_HashMap;

class MyHashMap {

    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] bucket;
    private int capacity;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        capacity = 10001;
        bucket = new Node[capacity];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hash = key % capacity;
        Node cur = bucket[hash];
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = bucket[hash];
        bucket[hash] = newNode;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hash = key % capacity;
        Node cur = bucket[hash];
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = key % capacity;
        Node head = bucket[hash];
        Node dummyHead = new Node(0, -1);
        dummyHead.next = head;
        Node cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        bucket[hash] = dummyHead.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */