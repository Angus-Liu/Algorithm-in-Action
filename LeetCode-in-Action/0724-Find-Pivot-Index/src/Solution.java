class Solution {
    public int pivotIndex(int[] nums) {
        int s1 = 0;
        for (int num : nums) {
            s1 += num;
        }
        int s2 = s1;
        for (int i = 0; i < nums.length; i++) {
            s2 -= nums[i];
            if (s2 * 2 == s1 - nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(new Solution().pivotIndex(nums));
        int[] nums2 = {1, 0};
        System.out.println(new Solution().pivotIndex(nums2));
    }
}