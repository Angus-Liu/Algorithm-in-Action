package NO_0231_Power_of_Two;

/**
 * 2的幂
 * https://leetcode-cn.com/problems/power-of-two/
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n <= 0 || n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        String b = Integer.toBinaryString(n);
        for (int i = 1; i < b.length(); i++) {
            if (b.charAt(i) != '0') return false;
        }
        return true;
    }

    public boolean isPowerOfTwo3(int n) {
        // 2 的幂换算成 2 进制显示：2-10，4-100，8-1000...
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 16, 218, -2147483648};
        for (int n : nums) {
            System.out.println(s.isPowerOfTwo3(n));
        }
    }
}
