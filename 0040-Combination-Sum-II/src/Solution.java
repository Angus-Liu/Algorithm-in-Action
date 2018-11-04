import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> c = new ArrayList<>();
        used = new boolean[candidates.length];
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
            if (!used[i] && (i == 0 || (candidates[i] != candidates[i - 1] || used[i - 1]))) {
                // 递归
                c.add(candidates[i]);
                used[i] = true;
                generateCombination(candidates, target, i, c, cSum + candidates[i]);
                // 回溯
                c.remove(c.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}