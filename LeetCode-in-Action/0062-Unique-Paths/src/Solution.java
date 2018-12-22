class Solution {
    public int uniquePaths(int m, int n) {
        // 动态规划问题
        int[][] memo = new int[n][m];
        for (int i = 0; i < m; i++) {
            memo[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            memo[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }
        return memo[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(7, 3));
    }
}