package NO_0371_Sum_of_Two_Integers;

/**
 * 两整数之和
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 */
public class Solution {
    public int getSum(int a, int b) {
        // 异或为无进位的加
        int sum = a ^ b;
        // 位与加左移得到进位
        int carry = (a & b) << 1;
        return carry == 0 ? sum : getSum(sum, carry);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getSum(10, -10));
    }
}
