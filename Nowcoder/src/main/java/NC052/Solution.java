package NC052;

import java.util.*;

/**
 * NC52 有效括号序列
 *
 * @Site <a href="https://www.nowcoder.com/practice/37548e94a270412c8b9fb85643c8ccc2"/>
 */
public class Solution {

    private static final Map<Character, Character> MAP =
            new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};

    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // write code here
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (MAP.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != MAP.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isValid("]");
        System.out.println("res = " + res);
    }
}
