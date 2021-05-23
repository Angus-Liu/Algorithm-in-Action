package NO_0258_Add_Digits;

/**
 * 各位相加
 * https://leetcode-cn.com/problems/add-digits/
 */
class Solution {
    public int addDigits(int num) {
        // X = 100*a + 10*b + c = 99*a + 9*b + (a+b+c)
        // 对 9 取余（99*a + 9*b 被除掉）即可得到各位之和
        if (num <= 9) return num;
        int n = num % 9;
        return n == 0 ? 9 : n;
    }
}
