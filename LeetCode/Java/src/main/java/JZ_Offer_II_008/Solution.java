package JZ_Offer_II_008;

public class Solution {
    // 滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println("res = " + res);
    }
}
