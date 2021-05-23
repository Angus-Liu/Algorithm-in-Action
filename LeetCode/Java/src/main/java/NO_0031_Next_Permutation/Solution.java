package NO_0031_Next_Permutation;

import java.util.Arrays;

/**
 * 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 */
class Solution {
    public void nextPermutation(int[] nums) {
        // 找到左边最后一个较小数
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            // 找到右边最后一个大于较小数的较大数
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) j--;
            // 交换二者，可是当前排列变大
            swap(nums, i, j);
        }
        // 交换后，将右边的数按升序排列，使其变大的幅度最小
        // 翻转 i + 1 之后的数组，相当于按升序排列
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int s) {
        int l = s;
        int r = nums.length - 1;
        while (l < r) swap(nums, r--, l++);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2};
        s.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
