import java.util.Arrays;

class Solution {

    /**
     * memo[i][c] 表示使用索引为[0...i]的这些元素，是否可以完全填充一个容量为c的背包
     * -1 表示未计算，0 表示不可以，1 表示可以填充
     */
    private int[][] memo;

    /**
     * 方式一：记忆化搜索
     *
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {
        // 本题可以类比于“0-1 背包问题” - 从多个数字中挑选出满足 sum/2 的数字
        int sum = 0;
        // 先计算所有数字的和
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        memo = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    private boolean tryPartition(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || index < 0) {
            // sum < 0 表示不能分配该数字，index < 0 则表示无数字可分配
            return false;
        }
        // 两种情况：分配与不分配该数字
        // 存在重叠子问题，使用记忆化搜索
        if (memo[index][sum] != -1) {
            return memo[index][sum] == 1;
        }
        boolean res = tryPartition(nums, index - 1, sum) || tryPartition(nums, index - 1, sum - nums[index]);
        memo[index][sum] = res ? 1 : 0;
        return res;
    }

    /**
     * 方式二：使用动态规划
     * 状态：考虑分配第 index 个数字
     * 状态转移：res = try(nums, index - 1, sum) || try(nums, index - 1, sum - nums[index])
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        // 先计算所有数字的和
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        // 类比于背包问题中物品个数
        int n = nums.length;
        // 类比于背包问题中背包的容量
        int C = sum / 2;

        // memo[C] 表示当前数字是否满足分配
        boolean[] memo = new boolean[C + 1];
        for (int i = 0; i <= C; i++) {
            memo[i] = (nums[0] == i);
        }

        for (int i = 1; i < n; i++) {
            for (int j = C; j >= nums[i]; j--) {
                // 不分配和分配两种情况
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }
        return memo[C];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new Solution().canPartition(new int[]{1, 2, 3, 5}));
    }
}