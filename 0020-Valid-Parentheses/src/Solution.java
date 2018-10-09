import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 先将所有左括号入栈，用以后续匹配右括号
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 如果开头不是一个左括号，直接匹配失败
                if (stack.isEmpty()) {
                    return false;
                }
                // 将栈中左括号弹出，与右括号进行匹配
                char topChar = stack.pop();
                if (topChar == '(' && c != ')') {
                    return false;
                }
                if (topChar == '[' && c != ']') {
                    return false;
                }
                if (topChar == '{' && c != '}') {
                    return false;
                }
            }
        }
        // 匹配完所有右括号之后确保栈为空，才代表匹配成功
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
    }
}
