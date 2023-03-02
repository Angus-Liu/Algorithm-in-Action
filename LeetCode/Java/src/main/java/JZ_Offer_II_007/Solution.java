package JZ_Offer_II_007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private int nextDiff(int[] nums, int i) {
        int tmp = nums[i];
        while (i < nums.length && nums[i] == tmp) {
            i++;
        }
        return i;
    }

    private void twoSum(int[] nums, int fixed, List<List<Integer>> res) {
        int lo = fixed + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[fixed] + nums[lo] + nums[hi];
            if (sum == 0) {
                res.add(List.of(nums[fixed], nums[lo], nums[hi]));
                lo = nextDiff(nums, lo);
            } else if (sum < 0) {
                lo++;
            } else { // sum > 0
                hi--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i = nextDiff(nums, i)) {
            twoSum(nums, i, res);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = solution.threeSum(nums);
        System.out.println("res = " + res);
    }
}
