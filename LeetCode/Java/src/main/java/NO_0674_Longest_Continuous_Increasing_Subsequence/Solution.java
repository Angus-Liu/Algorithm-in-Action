package NO_0674_Longest_Continuous_Increasing_Subsequence;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int lcis = 1, cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                lcis = Math.max(lcis, ++cnt);
            } else {
                cnt = 1;
            }
        }
        return lcis;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int lcis = solution.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
        System.out.println("lcis = " + lcis);
        lcis = solution.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2});
        System.out.println("lcis = " + lcis);
    }
}
