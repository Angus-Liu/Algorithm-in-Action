package NO_0039_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> c = new ArrayList<>();
        generateCombination(candidates, target, 0, c, 0);
        return res;
    }

    private void generateCombination(int[] candidates, int target, int index, List<Integer> c, int cSum) {
        if (cSum > target) {
            return;
        } else if (cSum == target) {
            res.add(new ArrayList<>(c));
            return;
        }
        // 限制 index，为了防止组合重复
        for (int i = index; i < candidates.length; i++) {
            // 递归
            c.add(candidates[i]);
            generateCombination(candidates, target, i, c, cSum + candidates[i]);
            // 回溯
            c.remove(c.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 5}, 8));
    }
}