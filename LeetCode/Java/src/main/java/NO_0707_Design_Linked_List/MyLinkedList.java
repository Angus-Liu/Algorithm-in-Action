package NO_0707_Design_Linked_List;

/**
 * 设计链表的实现。您可以选择使用单链表或双链表。
 * 单链表中的节点应该具有两个属性：val 和 next。
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
 * 假设链表中的所有节点都是 0-index 的。
 */
class MyLinkedList {

    private int size;
    private Node head, tail;

    private static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    private Node getNode(int index) {
        if (index >= size) return null;
        Node cur;
        if (index < size / 2) {
            cur = head;
            while (index-- > 0) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            while (++index < size) {
                cur = cur.prev;
            }
        }
        return cur;
    }

    /**
     * 获取链表中第 index 个节点的值。如果索引无效，则返回-1
     */
    public int get(int index) {
        Node cur = getNode(index);
        return cur == null ? -1 : cur.val;
    }

    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     */
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        if (head != null) {
            newHead.next = head;
            head.prev = newHead;
        } else {
            tail = newHead;
        }
        head = newHead;
        size++;
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素。
     */
    public void addAtTail(int val) {
        Node newTail = new Node(val);
        if (tail != null) {
            newTail.prev = tail;
            tail.next = newTail;
        } else {
            head = newTail;
        }
        tail = newTail;
        size++;
    }

    /**
     * 在链表中的第 index 个节点之前添加值为 val 的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * 如果 index 小于 0，则在头部插入节点。
     */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node newNode = new Node(val);
            Node prev = getNode(index - 1);
            assert prev != null;
            newNode.next = prev.next;
            newNode.next.prev = newNode;
            prev.next = newNode;
            newNode.prev = prev;
            size++;
        }

    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点。
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            Node newHead = head.next;
            head.next = null;
            if (newHead != null) {
                newHead.prev = null;
            } else {
                tail = null;
            }
            head = newHead;
        } else if (index == size - 1) {
            Node newTail = tail.prev;
            tail.prev = null;
            if (newTail != null) {
                newTail.next = null;
            } else {
                head = null;
            }
            tail = newTail;
        } else {
            Node delNode = getNode(index);
            assert delNode != null;
            delNode.prev.next = delNode.next;
            delNode.next.prev = delNode.prev;
            delNode.prev = null;
            delNode.next = null;
        }
        size--;
    }

    @Override
    public String toString() {
        Node cur = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(size).append("] ");
        sb.append("head -> ");
        while (cur != null) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        sb.append("tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addAtHead(1);
        System.out.println(linkedList);

        linkedList.addAtTail(3);
        System.out.println(linkedList);

        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        System.out.println(linkedList);

        int val = linkedList.get(1);            //返回2
        System.out.println("val = " + val);

        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList);

        val = linkedList.get(1);            //返回3
        System.out.println("val = " + val);
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
