package NO_1356_Sort_Integers_by_The_Number_of_1_Bits;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 根据数字二进制下 1 的数目排序
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 */
class Solution {

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed()
                .sorted(Comparator.comparingInt(n -> (Integer.bitCount(n) * 10000 + n)))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] sortByBits2(int[] arr) {
        return Arrays.stream(arr)
                .map(n -> (Integer.bitCount(n) * 100000 + n))
                .sorted()
                .map(n -> n % 100000)
                .toArray();
    }

    /**
     * 移位与1
     */
    private int count1Bit1(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }


    /**
     * Brian Kernighan
     */
    private int count1Bit2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    /**
     * Hamming Weight
     */
    private int count1Bit3(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0F0F0F0F) + ((n >>> 4) & 0x0F0F0F0F);
        n = (n & 0x00FF00FF) + ((n >>> 8) & 0x00FF00FF);
        n = (n & 0x0000FFFF) + ((n >>> 16) & 0x0000FFFF);
        return n;
    }

    /**
     * Integer.bitCount()
     */

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.count1Bit3(0x7fffffff));
        System.out.println(Integer.toBinaryString(0x7fffffff));
    }
}