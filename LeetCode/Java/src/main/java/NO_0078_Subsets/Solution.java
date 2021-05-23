package NO_0078_Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        generateSubsets(nums, 0, subset);
        return res;
    }

    private void generateSubsets(int[] nums, int start, List<Integer> subset) {
        res.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            generateSubsets(nums, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
    }
}