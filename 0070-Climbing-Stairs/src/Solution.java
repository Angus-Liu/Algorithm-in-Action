class Solution {
    public int climbStairs_1(int n) {
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

    public int climbStairs_2(int n) {
        int m = 1, res = 1;
        for (int i = 2; i <= n; i++) {
            m = (res += m) - m;
        }
        return res;
    }

    public int climbStairs(int n) {
        int m = 1, res = 1;
        while (--n > 0)
            m = (res += m) - m;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 10; i++) {
            System.out.println(solution.climbStairs(i));
        }
    }
}