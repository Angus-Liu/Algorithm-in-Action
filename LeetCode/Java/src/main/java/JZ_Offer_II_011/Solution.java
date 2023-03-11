package JZ_Offer_II_011;

import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * 前缀和
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIdx = new HashMap<>();
        sumToIdx.put(0, -1);
        int maxLen = 0;
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i] == 0 ? -1 : 1;
            if (sumToIdx.containsKey(preSum)) {
                maxLen = Math.max(maxLen, i - sumToIdx.get(preSum));
            } else {
                sumToIdx.put(preSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findMaxLength(new int[]{0, 1});
        System.out.println("res = " + res);
        res = solution.findMaxLength(new int[]{0, 1, 0, 0, 1});
        System.out.println("res = " + res);
    }
}
