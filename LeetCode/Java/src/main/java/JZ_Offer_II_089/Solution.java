package JZ_Offer_II_089;

class Solution {
    /**
     * 进一步降低空间复杂度
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        if (n == 2) return nums[1];
        for (int i = 2; i < n; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        Solution solution = new Solution();
        int res = solution.rob(nums);
        System.out.println("res = " + res);
    }
}
