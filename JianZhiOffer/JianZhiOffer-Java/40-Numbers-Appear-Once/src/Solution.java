import java.util.HashSet;
import java.util.Set;

/**
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 */
public class Solution {
    public void FindNumsAppearOnce_1(int[] array, int num1[], int num2[]) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        Integer[] res = new Integer[2];
        set.toArray(res);
        num1[0] = res[0];
        num2[0] = res[1];
    }

    /**
     * 要求时间复杂度为 O(n)，空间复杂度为 O(1)
     * 借助于异或运算，相同数字异或得0
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int xorRes = 0;
        // 因相同数异或得 0，故此时 xorRes 相当于为两个只出现一次的数字的异或结果
        for (int num : array) {
            xorRes ^= num;
        }
        // 找到 xorRes 二进制表示中第一个 1
        int bitOfOne = 1;
        for (int i = 1; i < 32; i++) {
            if ((xorRes & bitOfOne) != 0) break;
            bitOfOne <<= 1;
        }
        // 根据 xorRes 二进制表示中第一个 1 的结果将数组分为两份，
        for (int num : array) {
            // 这样就把两个只出现一次的数字分开了，再次异或即可得出结果
            if ((num & bitOfOne) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1], num2 = new int[1];
        new Solution().FindNumsAppearOnce(array, num1, num2);
        System.out.println("num1 = " + num1[0]);
        System.out.println("num2 = " + num2[0]);
    }
}