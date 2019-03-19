public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        // 判断正负性
        boolean negative = false;
        char[] chArr = str.toCharArray();
        int i = 0;
        if (chArr[i] == '-') {
            negative = true;
            i++;
        } else if (chArr[i] == '+') {
            i++;
        }
        // 转换
        long sum = 0;
        while (i < chArr.length) {
            if (chArr[i] < '0' || chArr[i] > '9') {
                return 0;
            }
            sum = sum * 10 + chArr[i++] - '0';
            // 判断是否小于负整数最小值或大于正整数最大值
            if ((negative && -sum < Integer.MIN_VALUE) || (!negative && sum > Integer.MAX_VALUE)) {
                return 0;
            }
        }
        return (int) (negative ? -sum : sum);
    }

    public static void main(String[] args) {
        int res = new Solution().StrToInt("-2147483649");
        System.out.println(res);
    }
}