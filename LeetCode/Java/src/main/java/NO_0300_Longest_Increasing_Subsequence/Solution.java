package NO_0300_Longest_Increasing_Subsequence;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        // 动态规划解法
        if (nums.length == 0) {
            return 0;
        }
        // memo[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
        int[] memo = new int[nums.length];
        int res = 1;
        // 初始化时，每位数字都是长度为 1 的最长上升子序列
        Arrays.fill(memo, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
            res = Math.max(res, memo[i]);
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == 0) dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}