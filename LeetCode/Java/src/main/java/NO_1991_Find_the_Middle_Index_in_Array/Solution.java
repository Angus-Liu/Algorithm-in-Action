package NO_1991_Find_the_Middle_Index_in_Array;

import java.util.Arrays;

class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] nums = {1};
        int[] nums = {1, -1, 4};
        System.out.println(s.findMiddleIndex(nums));
    }
}