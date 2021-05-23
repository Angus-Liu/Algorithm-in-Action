package NO_0263_Ugly_Number;

/**
 * 丑数
 * https://leetcode-cn.com/problems/ugly-number/
 */
public class Solution {
    public boolean isUgly(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        if (num % 2 == 0) return isUgly(num / 2);
        if (num % 3 == 0) return isUgly(num / 3);
        if (num % 5 == 0) return isUgly(num / 5);
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 1, 6, 8, 14, Integer.MIN_VALUE, Integer.MAX_VALUE};
        for (int num : nums) {
            System.out.println(s.isUgly(num));
        }
    }
}
