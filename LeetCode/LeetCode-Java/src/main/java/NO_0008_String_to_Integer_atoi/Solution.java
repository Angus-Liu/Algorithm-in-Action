package NO_0008_String_to_Integer_atoi;

import java.util.Arrays;

class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chArr = str.toCharArray();
        int len = chArr.length;
        int i = 0;
        // 去掉空格
        while (i < len && chArr[i] == ' ') {
            i++;
        }
        if (i == len) {
            return 0;
        }
        // 判断是否是负数
        boolean negative = false;
        if (chArr[i] == '-') {
            negative = true;
            i++;
        } else if (chArr[i] == '+') {
            i++;
        }
        long sum = 0;
        while (i < len) {
            if (chArr[i] < '0' || chArr[i] > '9') {
                break;
            }
            sum = sum * 10 + chArr[i] - '0';
            // 判断是否会溢出 -‭2147483648‬ ~ ‭2147483647
            if (sum > Integer.MAX_VALUE) {
                if (negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            i++;
        }
        return (int) (negative ? -sum : sum);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{" ", "42", " -42", "4193 with words", "-2147483649", "2147483647", "2147483648", "+1", "9223372036854775808", "-91283472332"};
        Solution solution = new Solution();
        Arrays.stream(strs).forEach(str -> {
            System.out.printf("str: %-20s  num: %d\n", str, solution.myAtoi(str));
        });
    }
}