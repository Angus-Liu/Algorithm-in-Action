package JZ_Offer_II_010;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // 使用 Map 记录前缀和及其出现的次数
        Map<Integer, Integer> sumCnt = new HashMap<>();
        // 将前缀和为 0 的情况初始化为 1
        sumCnt.put(0, 1);
        int preSum = 0, res = 0;
        // 循环遍历数组，计算前缀和及其出现次数
        for (int num : nums) {
            preSum += num;
            // 计算满足条件的子数组的数量
            // 若已有前缀的和为 sum - k，则当前前缀和与其差为 sum - (sum - k) = k，
            // 表示当前前缀与其之间的子数组即为满足条件的子数组
            res += sumCnt.getOrDefault(preSum - k, 0);
            // 更新前缀和出现的次数
            sumCnt.merge(preSum, 1, Integer::sum);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.subarraySum(new int[]{0, 0, 0}, 0);
        System.out.println("res = " + res);
        res = solution.subarraySum(new int[]{-1, 2, -3, 3, 2, 1}, 4);
        System.out.println("res = " + res);
    }
}
