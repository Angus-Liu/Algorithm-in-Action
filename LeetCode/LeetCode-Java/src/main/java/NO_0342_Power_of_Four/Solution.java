package NO_0342_Power_of_Four;

/**
 * 4的幂
 * https://leetcode-cn.com/problems/power-of-four/
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        String binStr = Integer.toBinaryString(num);
        if (binStr.length() % 2 == 0) return false;
        for (int i = 0; i < binStr.length(); i++) {
            if (i == 0 && binStr.charAt(i) != '1') return false;
            if (i > 0 && binStr.charAt(i) != '0') return false;
        }
        return true;
    }

    public boolean isPowerOfFour2(int num) {
//        if (num <= 0) return false;
//        if (num == 1) return true;
//        return num % 4 == 0 && isPowerOfFour(num / 4);
        return (num > 0) && ((num == 1) || (num % 4 == 0 && isPowerOfFour(num / 4)));
    }

    public boolean isPowerOfFour3(int num) {
        long n = 1;
        while (n < num) {
            n <<= 2;
        }
        return n == num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-1, 0, 1, 2, 4, 5, 16, 32, 64, 1162261466};
        for (int num : nums) {
            System.out.println(num + ": " + s.isPowerOfFour3(num));
        }
    }
}
