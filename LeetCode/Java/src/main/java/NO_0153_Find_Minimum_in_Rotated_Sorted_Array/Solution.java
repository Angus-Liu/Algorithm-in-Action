package NO_0153_Find_Minimum_in_Rotated_Sorted_Array;

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[l] < nums[r]) break; // 剪枝
            if (nums[m] < nums[r]) {
                r = m; // 注意，不能直接赋值为 m + 1，因原 m 可能为最终答案
            } else {
                l = m + 1;
            }
            // System.out.printf("l = %d, r = %d, m = %d\n", l, r, m);
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {15, 16, 17, 11, 12, 13};
        int min = solution.findMin(nums);
        System.out.println("min = " + min);
    }
}