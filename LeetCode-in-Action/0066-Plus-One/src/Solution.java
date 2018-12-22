import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] < 10) {
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        System.arraycopy(digits, 0, res, 1, digits.length);
        return res;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9, 9, 9, 9, 9, 9, 9, 9};
        Solution solution = new Solution();
        int[] res = solution.plusOne(digits);
        System.out.println(Arrays.toString(res));
    }
}