package NO_0026_Remove_Duplicates_from_Sorted_Array;

import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        // 双指针
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 1, 2};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}