public class Solution {
    public int Add(int num1, int num2) {
        int sum;
        while (num2 != 0) {
            // 异或即是不进位下的相加
            sum = num1 ^ num2;
            // 位与结果左移一位，得到进位结果
            num2 = (num1 & num2) << 1;
            num1 = sum;
        }
        return num1;
    }
}