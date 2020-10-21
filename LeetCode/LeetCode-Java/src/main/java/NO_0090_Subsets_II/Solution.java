package NO_0090_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        used = new boolean[nums.length];
        generateSubsets(nums, 0, subset);
        return res;
    }

    private void generateSubsets(int[] nums, int start, List<Integer> subset) {
        res.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && (i == 0 || (nums[i] != nums[i - 1] || used[i - 1]))) {
                // 递归
                subset.add(nums[i]);
                used[i] = true;
                generateSubsets(nums, i + 1, subset);
                // 回溯
                subset.remove(subset.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
    }
}