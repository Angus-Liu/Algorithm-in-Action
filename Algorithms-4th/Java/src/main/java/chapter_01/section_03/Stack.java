package chapter_01.section_03;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public Stack() {
        n = 0;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);

        for (Integer item : intStack) {
            System.out.println(item);
        }
    }
}
