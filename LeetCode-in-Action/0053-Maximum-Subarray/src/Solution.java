class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            // 正值继续传递，负值及时终止
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        System.out.println(new Solution().maxSubArray(nums));
    }
}