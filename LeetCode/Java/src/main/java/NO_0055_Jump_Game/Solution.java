package NO_0055_Jump_Game;

class Solution {
    public boolean canJump1(int[] nums) {
        int n = nums.length;
        boolean[] res = new boolean[n];
        res[0] = true;
        for (int i = 0; i < n; i++) {
            if (!res[i]) break;
            for (int j = i + 1; j <= i + nums[i] && j < n; j++) {
                res[j] = true;
            }
        }
        return res[n - 1];
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        // 贪心策略下，可达的最远位置，初始化为0
        int furthestPosition = 0;
        // 遍历每一层云梯，更新可达的最远位置
        for (int i = 0; i < n; i++) {
            // 当可达的最远位置能到达i，才有讨论意义
            if (furthestPosition >= i) {
                furthestPosition = Math.max(furthestPosition, i + nums[i]);
            }
        }
        // 若可达的最远位置超过云梯顶层，那顶层就一定可达
        return furthestPosition >= n - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println("res = " + res);
        res = solution.canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println("res = " + res);
    }
}