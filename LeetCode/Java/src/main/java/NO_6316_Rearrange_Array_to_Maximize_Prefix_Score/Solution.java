package NO_6316_Rearrange_Array_to_Maximize_Prefix_Score;

import java.util.Arrays;

class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        long posSum = 0;
        int negCnt = 0;
        for (int num : nums) {
            if (num > 0) {
                posSum += num;
            } else if (num < 0) {
                negCnt++;
            }
        }
        if (posSum <= 0) return 0;
        int res = n - negCnt;
        Arrays.sort(nums);
        for (int i = negCnt - 1; i >= 0; i--) {
            if ((posSum += nums[i]) > 0) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxScore(new int[]{2, -1, 0, 1, -3, 3, -3});
        System.out.println("res = " + res);

        // 1 1 1 1 0 0 -1 -1 -1 -1
    }
}