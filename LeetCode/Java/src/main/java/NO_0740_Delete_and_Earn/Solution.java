package NO_0740_Delete_and_Earn;

import java.util.Arrays;

class Solution {
    /**
     * 动态规划：思路和 198 一样
     */
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int max = Arrays.stream(nums).max().orElse(nums[0]);
        int[] sums = new int[max + 1];
        for (int num : nums) {
            sums[num] += num;
        }
        int pre = sums[0];
        int cur = Math.max(sums[0], sums[1]);
        for (int i = 2; i < max + 1; i++) {
            int tmp = cur;
            cur = Math.max(pre + sums[i], cur);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.deleteAndEarn(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6});
        // 0 1 2 3 4 5 6
        // 0 3 2 0 4 15 6
        // 0 3 3 3 7 18 13
        System.out.println("res = " + res);
        res = solution.deleteAndEarn(new int[]{3, 4, 2});
        System.out.println("res = " + res);
    }
}
