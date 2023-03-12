package NO_6316_Rearrange_Array_to_Maximize_Prefix_Score;

import java.util.Arrays;

class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        long posSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            posSum += nums[i];
            if (posSum > 0) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxScore(new int[]{2, -1, 0, 1, -3, 3, -3});
        System.out.println("res = " + res);
    }
}