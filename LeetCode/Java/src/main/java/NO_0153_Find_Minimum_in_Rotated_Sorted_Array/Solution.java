package NO_0153_Find_Minimum_in_Rotated_Sorted_Array;

class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= nums[l] && nums[m] <= nums[r]) {
                return nums[l];
            } else if (nums[m] < nums[l]) {
                // 注意，不能直接赋值为 m + 1，因原 m 可能为最终答案
                r = m;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}