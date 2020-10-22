package NO_0172_Factorial_Trailing_Zeroes;

class Solution {
    // 只有 2 * 5 才会使末尾为 0，而阶乘中 2 的个数远远大于 5 的个数，比如 20 = 2 * 2 * 5
    // 所以只需要计算 5 的个数即可
    public int trailingZeroes(int n) {
        if(n < 5) return 0;
        int t = n / 5;
        return t + trailingZeroes(t);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 3, 5, 6, 10, 20, 100};
        for (int n : nums) {
            System.out.println(s.trailingZeroes(n));
        }
    }
}