class Solution {
    public int dominantIndex(int[] nums) {
        // 找出最大值和次大值
        int max = -1, maxIndex = -1, secondMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return max >= secondMax * 2 ? maxIndex : -1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,3,2};
        int i = new Solution().dominantIndex(nums);
        System.out.println(i);
    }
}