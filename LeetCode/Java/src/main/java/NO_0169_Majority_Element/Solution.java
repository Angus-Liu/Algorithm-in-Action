package NO_0169_Majority_Element;

import java.util.Arrays;

class Solution {
    public int majorityElement_1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票算法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count++;
            } else {
                if (num == res) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return res;
    }
}