package NO_0155_Min_Stack;

import java.util.ArrayList;
import java.util.List;

class MinStack {

    private List<Integer> stack;
    private List<Integer> minList;
    private int size;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new ArrayList<>();
        minList = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
        if (size == 0) {
            minList.add(x);
        } else {
            minList.add(Math.min(minList.get(size - 1), x));
        }
        size++;
    }

    public void pop() {
        stack.remove(size - 1);
        minList.remove(size - 1);
        size--;
    }

    public int top() {
        return stack.get(size - 1);
    }

    public int getMin() {
        return minList.get(size - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */