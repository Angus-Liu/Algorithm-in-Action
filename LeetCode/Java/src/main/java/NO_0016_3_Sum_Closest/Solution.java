package NO_0016_3_Sum_Closest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 先对 nums 做预处理，排序
        Arrays.sort(nums);
        // cloSum 为最接近的三数之和，minDiff 则对应其与 target 的接近程度（取绝对值）
        int cloSum = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            // 采用双指针法
            for (int l = i + 1, r = nums.length - 1; l < r; ) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) return sum;
                // 注意，这里 diff 是 target - sum。其决定了后续指针怎么移动。
                // 如果使用 sum - target，则指针移动方向要修改
                int diff = target - sum;
                if (Math.abs(diff) < minDiff) {
                    minDiff = Math.abs(diff);
                    cloSum = sum;
                }
                // 根据接近情况移动指针
                if (diff > 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return cloSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int sumClosest = solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(sumClosest);
    }
}