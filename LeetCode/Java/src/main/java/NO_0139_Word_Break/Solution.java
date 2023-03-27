package NO_0139_Word_Break;

import java.util.*;

class Solution {

    // 可以类比于背包问题
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        // memo[i] 表示 s 中索引为 [0,  i - 1] 范围的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // [0, i - 1] 的字符串可被拆分，当前仅当任一子串 [0, j - 1] 及 [j, i - 1] 可被拆分
                if (memo[j] && dict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        System.out.println(new Solution().wordBreak("aaaaaaa", new ArrayList<>(Arrays.asList("aaaa", "aaa"))));
    }
}