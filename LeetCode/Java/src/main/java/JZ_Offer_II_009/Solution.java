package JZ_Offer_II_009;

public class Solution {

    /**
     * 滑动窗口法
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int prod = 1;
        for (int l = 0, r = 0; r < nums.length; r++) {
            prod *= nums[r];
            while (l <= r && prod >= k) {
                prod /= nums[l++];
            }
            // r >= l 表明 prod < k，此时 l 和 r 之间有多少个数字，就有多少个符合要求的子数组
            res += r - l + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
        System.out.println("res = " + res);
    }
}