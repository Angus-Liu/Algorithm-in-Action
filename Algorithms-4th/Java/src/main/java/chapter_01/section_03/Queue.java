package chapter_01.section_03;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    public Queue() {
    }

    public void enqueue(Item item) {
    }

    public Item dequeue() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
