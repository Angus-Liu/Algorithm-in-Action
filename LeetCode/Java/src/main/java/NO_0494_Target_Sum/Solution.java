package NO_0494_Target_Sum;

import java.util.Arrays;

class Solution {

    /**
     * DFS
     */
    public int findTargetSumWays1(int[] nums, int target) {
        return findTargetSumWays(nums, 0, target);
    }

    private int findTargetSumWays(int[] nums, int index, int target) {
        int res = 0;
        if (index == nums.length) return target == 0 ? ++res : res;
        res += findTargetSumWays(nums, index + 1, target + nums[index]);
        res += findTargetSumWays(nums, index + 1, target - nums[index]);
        return res;
    }

    /**
     * DP
     */
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) return 0;
        int n = nums.length, neg = diff / 2;
        // dp[i][j] 表示 nums 的前 i 个数的和为 j 的数目
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) return 0;
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            // 从后往前遍历，使上一轮结果不被提前修改
            for (int i = neg; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[neg];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}