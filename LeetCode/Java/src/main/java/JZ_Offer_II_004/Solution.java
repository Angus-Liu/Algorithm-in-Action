package JZ_Offer_II_004;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 暴力解法
     */
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) res = entry.getKey();
        }
        return res;
    }

    public int singleNumber(int[] nums) {
        // 用于保存所有数字二进制形式中第 i 位的和
        int[] bitSums = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSums[i] += num & 1;
                num = num >> 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res = (res << 1) + bitSums[i] % 3;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 3, 2};
        int res = solution.singleNumber(nums);
        System.out.println("res = " + res);
    }
}
