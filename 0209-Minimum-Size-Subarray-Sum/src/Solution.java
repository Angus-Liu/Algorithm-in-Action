class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 滑动窗口解法
        // nums[l,r] 为滑动窗口
        int l = 0;
        int r = -1;
        // len 初始化为一个不可能的取值
        int len = nums.length + 1;
        // sum 为窗口中的元素值
        int sum = 0;
        while (l < nums.length) {
            if (sum < s) {
                // 窗口增大
                if (r + 1 < nums.length) {
                    r++;
                    sum += nums[r];
                } else {
                    break;
                }
            } else {
                // sum >= s, 窗口向右滑动
                sum -= nums[l];
                l++;
            }
            if (sum >= s) {
                len = (r - l + 1) < len ? r - l + 1 : len;
            }
        }
        if (len == nums.length + 1) {
            return 0;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int len = solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(len);
        len = solution.minSubArrayLen(6, new int[]{10, 2, 3});
        System.out.println(len);
        len = solution.minSubArrayLen(3, new int[]{1, 1});
        System.out.println(len);
    }
}