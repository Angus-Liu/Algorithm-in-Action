class Solution {
    public int integerBreak(int n) {
        // memo[i] 表示将数字 n 分割（至少是分割成两部分）后得到的最大乘积
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memo[i] = Math.max(memo[i], Math.max(j * (i - j), j * memo[i - j]));
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(2));
    }
}