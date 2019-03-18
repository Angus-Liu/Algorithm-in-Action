class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            Node cur = this;
            StringBuilder res = new StringBuilder();
            while (cur != null) {
                res.append(cur.val);
                if (cur.next != null) {
                    res.append(" -> ");
                }
                cur = cur.next;
            }
            return res.toString();
        }
    }

    private Node head;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node cur = head;
        while (index-- > 0) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        size++;
        Node newHead = new Node(val);
        if (head != null) {
            newHead.next = head;
        }
        head = newHead;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        size++;
        Node newTail = new Node(val);
        if (head == null) {
            head = newTail;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newTail;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else {
            Node cur = head;
            while (--index > 0) {
                cur = cur.next;
            }
            Node newNode = new Node(val);
            newNode.next = cur.next;
            cur.next = newNode;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        Node prev = head;
        while (--index > 0) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        // 链表变为1-> 2-> 3
        linkedList.addAtIndex(1, 2);
        // 返回2
        linkedList.get(1);
        // 现在链表是1-> 3
        linkedList.deleteAtIndex(1);
        // 返回3
        System.out.println(linkedList.get(1));
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */