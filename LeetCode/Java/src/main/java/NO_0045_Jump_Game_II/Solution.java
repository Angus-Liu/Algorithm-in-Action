package NO_0045_Jump_Game_II;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int maxPos = 0, steps = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.jump(new int[]{2, 3, 1, 1, 4});
        System.out.println("res = " + res);

        res = solution.jump(new int[]{2, 1, 1, 1, 4});
        System.out.println("res = " + res);
    }
}
