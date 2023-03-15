package NO_0213_House_Robber_II;

class Solution {
    /**
     * 动态规划，在 198 号问题基础上修改
     */
    public int rob(int[] nums) {
        int n = nums.length;
        return switch (n) {
            case 0 -> 0;
            case 1 -> nums[0];
            case 2 -> Math.max(nums[0], nums[1]);
            // 考虑不抢劫 n-1 号房间和不抢劫 0 号房间的情况
            default -> Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
        };
    }

    private int rob(int[] nums, int start, int end) {
        int pre = nums[start];
        int cur = Math.max(pre, nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int tmp = cur;
            cur = Math.max((pre + nums[i]), cur);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
    }
}