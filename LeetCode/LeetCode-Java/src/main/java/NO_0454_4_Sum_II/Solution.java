package NO_0454_4_Sum_II;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 查找表法，先将 C 和 D 的所有组合的和存进查找表中
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : C) {
            for (int d : D) {
                int s = c + d;
                map.put(s, map.getOrDefault(s, 0) + 1);

            }
        }
        int res = 0;
        // 利用 A 和 B 的所有组合进行查找
        for (int a : A) {
            for (int b : B) {
                int d = 0 - a - b;
                res += map.getOrDefault(d, 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int count = solution.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        System.out.println(count);
    }
}