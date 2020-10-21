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
        // 初始化时，每位数字都是长度为 1 的最长上升子序列
        Arrays.fill(memo, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < memo.length; i++) {
            res = Math.max(res, memo[i]);
        }
        return res;
    }
}