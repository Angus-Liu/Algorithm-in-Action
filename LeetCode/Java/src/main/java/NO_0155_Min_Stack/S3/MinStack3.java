package NO_0155_Min_Stack.S3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MinStack3 {

    private final LinkedList<Integer> stack;
    private final LinkedList<Integer> minStack;


    /**
     * initialize your data structure here.
     */
    public MinStack3() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
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