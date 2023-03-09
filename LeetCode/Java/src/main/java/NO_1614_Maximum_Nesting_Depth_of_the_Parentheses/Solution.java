package NO_1614_Maximum_Nesting_Depth_of_the_Parentheses;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int maxDepth1(String s) {
        Deque<Character> queue = new LinkedList<>();
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                queue.addLast(c);
                depth = Math.max(depth, queue.size());
            } else if (c == ')') {
                queue.removeLast();
            }
        }
        return depth;
    }

    public int maxDepth(String s) {
        int depth = 0, cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                depth = Math.max(depth, ++cnt);
            } else if (c == ')') {
                --cnt;
            }
        }
        return depth;
    }
}
