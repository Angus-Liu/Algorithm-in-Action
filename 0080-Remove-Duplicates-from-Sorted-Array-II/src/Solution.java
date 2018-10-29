import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (j < 2) {
                nums[j] = nums[i];
                j++;
            } else {
                if (nums[i] != nums[j - 2]) {
                    nums[j] = nums[i];
                    j++;
                }
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 1, 2};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}