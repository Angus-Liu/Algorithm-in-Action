import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack2.push(node);
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
       return stack2.pop();
    }
}