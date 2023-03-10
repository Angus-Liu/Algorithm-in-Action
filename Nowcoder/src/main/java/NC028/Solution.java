package NC028;

import java.util.HashMap;
import java.util.Map;

/**
 * NC28 最小覆盖子串
 *
 * @Site <a href="https://www.nowcoder.com/practice/c466d480d20c4c7c9d322d12ca7955ac"/>
 */
public class Solution {
    /**
     * @param S string字符串
     * @param T string字符串
     * @return string字符串
     */
    public String minWindow(String S, String T) {
        Map<Character, Integer> tCnt = new HashMap<>();
        for (char c : T.toCharArray()) {
            tCnt.merge(c, 1, Integer::sum);
        }

        int start = 0, minLen = Integer.MAX_VALUE;
        Map<Character, Integer> sCnt = new HashMap<>();
        for (int left = 0, right = 0; right < S.length(); right++) {
            sCnt.merge(S.charAt(right), 1, Integer::sum);
            while (included(sCnt, tCnt)) {
                if (right - left + 1 < minLen) {
                    start = left;
                    minLen = right - left + 1;
                }
                // 窗口左边界缩小
                sCnt.merge(S.charAt(left), -1, Integer::sum);
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : S.substring(start, start + minLen);
    }

    private boolean included(Map<Character, Integer> sCnt, Map<Character, Integer> tCnt) {
        for (Map.Entry<Character, Integer> e : tCnt.entrySet()) {
            if (sCnt.getOrDefault(e.getKey(), 0) < e.getValue())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.minWindow("abcAbA", "AA");
        System.out.println("res = " + res);
    }
}
