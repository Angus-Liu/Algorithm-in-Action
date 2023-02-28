package NO_0209_Minimum_Size_Subarray_Sum;

class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, minLen = Integer.MAX_VALUE;
        int l = 0, r = 0; // 滑动窗口左右指针
        while (true) {
            // System.out.printf("l = %d, r = %d, sum = %d, minLen = %d%n", l, r, sum, minLen);
            if (sum >= target) {
                minLen = Math.min(minLen, r - l);
                sum -= nums[l++];
            } else {
                if (r >= nums.length) break;
                sum += nums[r++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int len = solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(len);
        len = solution.minSubArrayLen(6, new int[]{10, 2, 3});
        System.out.println(len);
        len = solution.minSubArrayLen(3, new int[]{1, 1});
        System.out.println(len);
    }
}