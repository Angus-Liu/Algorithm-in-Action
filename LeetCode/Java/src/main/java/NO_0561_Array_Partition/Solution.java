package NO_0561_Array_Partition;

import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().arrayPairSum(new int[]{1, 4, 3, 2}));
    }
}