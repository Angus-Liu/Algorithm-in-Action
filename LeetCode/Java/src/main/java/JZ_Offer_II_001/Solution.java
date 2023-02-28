package JZ_Offer_II_001;

public class Solution {
    public int divide(int a, int b) {
        // 出现溢出时，直接返回最大值
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        // 将 a，b 均转为负数再进行计算，可避免溢出
        boolean negative = false;
        if (a > 0) {
            negative = true;
            a = -a;
        }
        if (b > 0) {
            negative = !negative;
            b = -b;
        }
        int res = 0;
        while (a <= b) {
            int div = b;
            int quo = 1;
            // div >= Inter.MIN_VALUE / 2
            //     = 0x80000000 / 2
            //     = 0x1000 0000 ... 0000 >> 1
            //     = 0x1100 0000 ... 0000
            //     = 0xc0000000
            while (div >= 0xc0000000 && a < div + div) {
                div += div;
                quo += quo;
            }
            a -= div;
            res += quo;
        }
        return negative ? -res : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.divide(Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("res = " + res);

        res = solution.divide(8, 2);
        System.out.println("res = " + res);
    }
}
