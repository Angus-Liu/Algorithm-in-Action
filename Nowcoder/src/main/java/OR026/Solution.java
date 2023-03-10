package OR026;

/**
 * OR26 最长回文子串
 *
 * @Site <a href="https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af"/>
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param A string字符串
     * @return int整型
     */
    public int getLongestPalindrome(String A) {
        // [0...n-1] 是回文串当且仅当 [0]==[n] 且 [1...n-2] 是回文串
        int n = A.length(), maxLen = 1;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int r = 1; r < n; r++) {
            char a = A.charAt(r);
            for (int l = r - 1; l >= 0; l--) {
                if (a == A.charAt(l)) {
                    if (r - l == 1) {
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                } else {
                    dp[l][r] = false;
                }
                if (dp[l][r] && r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                }
            }
        }
        return maxLen;
    }


    /**
     * 中心扩展法
     */
    public int getLongestPalindrome2(String A) {
        int n = A.length();
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            // 处理以 i 为中心的回文子串
            int len1 = expandAroundCenter(A, i, i);
            // 处理以 i 和 i+1 为中心的回文子串
            int len2 = expandAroundCenter(A, i, i + 1);
            maxLen = Math.max(maxLen, Math.max(len1, len2));
        }
        return maxLen;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.getLongestPalindrome("ababc");
        System.out.println("res = " + res);
    }
}
