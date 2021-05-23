package NO_0139_Word_Break;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 可以类比于背包问题
        int n = s.length();
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
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