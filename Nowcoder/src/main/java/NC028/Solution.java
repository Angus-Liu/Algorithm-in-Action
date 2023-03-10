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
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : T.toCharArray()) {
            tMap.merge(c, 1, Integer::sum);
        }

        int start = 0, min = Integer.MAX_VALUE;
        Map<Character, Integer> sMap = new HashMap<>();
        for (int l = 0, r = 0; r < S.length(); r++) {
            sMap.merge(S.charAt(r), 1, Integer::sum);
            while (included(sMap, tMap)) {
                if (r - l + 1 < min) {
                    start = l;
                    min = r - l + 1;
                }
                // 窗口左边界缩小
                sMap.merge(S.charAt(l), -1, Integer::sum);
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : S.substring(start, start + min);
    }

    private boolean included(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> e : tMap.entrySet()) {
            if (sMap.getOrDefault(e.getKey(), 0) < e.getValue())
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
