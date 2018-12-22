class Solution {

    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S, 0);
    }

    private int findTargetSumWays(int[] nums, int index, int S, int sum) {
        int res = 0;
        if (index == nums.length) {
            return sum == S ? ++res : res;
        }
        res += findTargetSumWays(nums, index + 1, S, sum + nums[index]);
        res += findTargetSumWays(nums, index + 1, S, sum - nums[index]);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}