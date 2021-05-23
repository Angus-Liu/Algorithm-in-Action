package NO_0018_4_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 4) {
            return res;
        }
        // 对 nums 做预处理
        Arrays.sort(nums);
        for (int i = 0; i <= n - 4; i = nextNumIndex(nums, i)) {
            for (int j = i + 1; j <= n - 3; j = nextNumIndex(nums, j)) {
                int t = target - nums[i] - nums[j];
                // 这步是优化
                if (nums[j + 1] + nums[j + 2] > t || nums[n - 1] + nums[n - 2] < t) {
                    continue;
                }
                // 双指针
                int p1 = j + 1;
                int p2 = n - 1;
                while (p1 < p2) {
                    if (nums[p1] + nums[p2] == t) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[p1], nums[p2]));
                        // 指针移动，寻找下一个结果
                        p1 = nextNumIndex(nums, p1);
                        p2 = preNumIndex(nums, p2);
                    } else if (nums[p1] + nums[p2] < t) {
                        p1 = nextNumIndex(nums, p1);
                    } else {
                        // nums[p1] + nums[p2] > t
                        p2 = preNumIndex(nums, p2);
                    }
                }
            }
        }

        return res;
    }

    /**
     * 返回 nums 中与下一个与 nums[index] 不同的数字的索引
     *
     * @param nums
     * @param index
     * @return
     */
    private int nextNumIndex(int[] nums, int index) {
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 返回 nums 中与上一个与 nums[index] 不同的数字的索引
     *
     * @param nums
     * @param index
     * @return
     */
    private int preNumIndex(int[] nums, int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] != nums[index]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}