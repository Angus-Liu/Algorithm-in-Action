class Solution {
    public int findMaxConsecutiveOnes_1(int[] nums) {
        int res = 0;
        int i = 0, j = 0;
        while (i < nums.length) {
            if (j < nums.length && nums[j] == 1) {
                j++;
            } else if (j == nums.length || nums[j] == 0) {
                res = Math.max(res, j - i);
                i = ++j;
            }
        }
        return res;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 0;
            }

        }
        return Math.max(res, count);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        int res = new Solution().findMaxConsecutiveOnes(nums);
        System.out.println(res);
    }
}