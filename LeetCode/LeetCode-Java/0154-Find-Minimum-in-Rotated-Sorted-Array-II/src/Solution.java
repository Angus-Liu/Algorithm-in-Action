class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[l] > nums[m]) {
                r = m;
            } else {
                // nums[l] <= nums[m] <= nums[r]，排除重复值
                r -= 1;
            }
        }
        return nums[l];
    }
}