class Solution {
    public int climbStairs(int n) {
        // 要求解爬 n 阶台阶有多少中方法，就是求解爬 n - 1 阶台阶和爬 n - 2 阶台阶的方法的和
        // 由此可见，是斐波拉切数列的应用，可使用记忆化搜索和动态规划解决，这里使用动态规划来解决
        int[] memo = new int[n + 1];
        // 注意，这是 memo[0] 取 1
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}