package NO_0077_Combinations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        generateCombination(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    /**
     * 求解组合 C(n, k)，当前已经找到的组合存储在 com 中，需要从 start 中开始搜索新的元素
     */
    private void generateCombination(List<List<Integer>> res, List<Integer> com, int n, int k, int start) {
        if (com.size() == k) {
            res.add(new ArrayList<>(com));
            return;
        }
        // 从 start 开始，因为组合不讲究顺序，类似 [1, 2, 3]、[1, 3, 2]、[2, 3, 1] 等是一种情况，因此限定 start。
        // 这里对 i 的取值使用剪枝法，因为 c 中还有 k - c.size() 个空位，所以 i 的取值范围 [i, n] 中至少要有 k - c.size() 个元素，
        // 因此 i 最多为 max = n - (k - c.size()) + 1，若 i 超过 max，则剩下数数字不足以选出 k 个数
        int max = n - (k - com.size()) + 1;
        for (int i = start; i <= max; i++) {
            // 递归
            com.add(i);
            generateCombination(res, com, n, k, i + 1);
            // 回溯
            com.remove(com.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(3, 2));
    }
}