package NO_0005_Longest_Palindromic_Substring;

class Solution {
    /**
     * 暴力
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        // 初始回文子串为单个字母长度
        int l = 0, maxLen = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > maxLen && isPalindrome(s, i, j)) {
                    l = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(l, l + maxLen);
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }


    /**
     * 动态规划
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n < 2) return s;

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int begin = 0, maxLen = 1;
        char[] chars = s.toCharArray();
        for (int r = 1; r < n; r++) {
            for (int l = r - 1; l >= 0; l--) {
                if (chars[l] == chars[r]) {
                    if (r - l == 1) {
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                } else {
                    dp[l][r] = false;
                }
                if (dp[l][r] && r - l + 1 > maxLen) {
                    begin = l;
                    maxLen = r - l + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}