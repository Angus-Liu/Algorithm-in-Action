class Solution {
    public boolean isPowerOfThree_1(int n) {
        if (n <= 0) {
            return false;
        }
        for (int i = n; i > 1; i /= 3) {
            if (i % 3 != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPowerOfThree(int n) {
        // 1162261467是3的19次幂，是整数范围内最大的3的幂次
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfThree(27));
        System.out.println(new Solution().isPowerOfThree(45));
    }
}