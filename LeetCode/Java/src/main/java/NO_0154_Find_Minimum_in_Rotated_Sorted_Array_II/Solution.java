package NO_0154_Find_Minimum_in_Rotated_Sorted_Array_II;

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r && nums[l] >= nums[r]) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            } else if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                // nums[m] == nums[r]，排除重复值
                r -= 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 1, 3, 3};
        int min = solution.findMin(nums);
        System.out.println("min = " + min);
    }
}