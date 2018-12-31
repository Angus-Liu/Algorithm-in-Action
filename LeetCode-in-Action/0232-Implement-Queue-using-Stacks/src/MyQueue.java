import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> reverseStack;

    public MyQueue() {
        stack = new Stack<>();
        reverseStack = new Stack<>();
    }

    public void push(int x) {
        while (!stack.isEmpty()) {
            reverseStack.add(stack.pop());
        }
        reverseStack.add(x);
        while (!reverseStack.isEmpty()) {
            stack.add(reverseStack.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
