package NO_0377_Combination_Sum_IV;

import java.util.Arrays;

class Solution {
    /**
     * 简单递归
     */
    public int combinationSum4_1(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum4_1(nums, target - num);
            }
        }
        return res;
    }

    /**
     * 记忆化搜索
     */
    private int[] memo;

    public int combinationSum4_2(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return search(nums, target);
    }

    private int search(int[] nums, int target) {
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += search(nums, target - num);
            }
        }
        memo[target] = res;
        return res;
    }

    /**
     * 动态规划
     * <p>
     * comb[target] = sum(comb[target - nums[i]]), where 0 <= i < nums.length, and target >= nums[i]
     */
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        memo[0] = 1;
        for (int i = 0; i < target; i++) {
            for (int num : nums) {
                if (i + num <= target) {
                    memo[i + num] += memo[i];
                }
            }
        }
        return memo[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(solution.combinationSum4(nums, 4));  // 7
        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution.combinationSum4(nums, 5));  // 16
        nums = new int[]{3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution.combinationSum4(nums, 10)); // 9
        nums = new int[]{1, 2};
        System.out.println(solution.combinationSum4(nums, 10)); // 89\
    }
}