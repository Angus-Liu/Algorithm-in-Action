package chapter_01.section_03;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    public Bag() {
    }

    public void add(Item item) {
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
