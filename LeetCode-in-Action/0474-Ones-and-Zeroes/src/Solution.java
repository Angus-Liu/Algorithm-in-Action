import java.util.Arrays;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // 动态规划
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        for (int i = 0; i < strs.length; i++) {
            int mCost = 0;
            int nCost = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    mCost++;
                } else {
                    nCost++;
                }
            }
            for (int u = m; u >= mCost; u--) {
                for (int v = n; v >= nCost; v--) {
                    dp[u][v] = Math.max(dp[u][v], 1 + dp[u - mCost][v - nCost]);
                }
            }
        }
        return dp[m][n];
    }
}