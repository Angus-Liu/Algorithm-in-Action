package NO_0327_Count_of_Range_Sum;

/**
 * 区间和的个数
 * https://leetcode-cn.com/problems/count-of-range-sum/
 */
class Solution {
    // TODO: angus on 2020/11/7 题目要求优化算法复杂度
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-2, 5, -1};
        int res = s.countRangeSum(nums, -2, 10);
        System.out.println("res = " + res);
    }
}