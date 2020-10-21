package NO_0213_House_Robber_II;

class Solution {
    public int rob(int[] nums) {
        // 动态规划，在 198 号问题基础上修改
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            // 考虑不抢劫 n-1 号房间和不抢劫 0 号房间的情况
            return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
        }

    }

    private int rob(int[] nums, int start, int end) {
        int preMax = nums[start];
        int curMax = Math.max(preMax, nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = curMax;
            curMax = Math.max((preMax + nums[i]), curMax);
            preMax = temp;
        }
        return curMax;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
    }
}