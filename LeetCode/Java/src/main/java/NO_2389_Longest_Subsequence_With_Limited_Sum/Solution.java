package NO_2389_Longest_Subsequence_With_Limited_Sum;

import java.util.Arrays;

class Solution {
    /**
     * 贪心算法
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0, s = 0; j < nums.length; j++) {
                s += nums[j];
                if (s > queries[i]) break;
                answers[i]++;
            }
        }
        return answers;
    }
}