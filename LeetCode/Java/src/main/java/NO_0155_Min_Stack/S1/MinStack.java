package NO_0155_Min_Stack.S1;

import java.util.Stack;

class MinStack {

    Stack<Pair<Integer, Integer>> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        int min = x;
        if (!stack.isEmpty()) {
            min = Math.min(min, getMin());
        }
        stack.push(new Pair<>(x, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().getKey();
    }

    public int getMin() {
        return stack.peek().getValue();
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