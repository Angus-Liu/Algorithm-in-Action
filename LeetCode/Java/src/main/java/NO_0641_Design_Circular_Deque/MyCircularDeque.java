package NO_0641_Design_Circular_Deque;

public class MyCircularDeque {

    private final int[] elems;
    private final int capacity;
    private int size = 0;
    private int head = 0;
    private int tail = 1;

    public MyCircularDeque(int k) {
        elems = new int[k];
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        elems[head] = value;
        head = prevIdx(head);
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        elems[tail] = value;
        tail = nextIdx(tail);
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = nextIdx(head);
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = prevIdx(tail);
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : elems[nextIdx(head)];
    }

    public int getRear() {
        return isEmpty() ? -1 : elems[prevIdx(tail)];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private int prevIdx(int i) {
        return (i - 1 + capacity) % capacity;
    }

    private int nextIdx(int i) {
        return (i + 1) % capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
