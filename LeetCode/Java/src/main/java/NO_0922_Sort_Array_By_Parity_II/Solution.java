package NO_0922_Sort_Array_By_Parity_II;

import java.util.Arrays;

/**
 * 按奇偶排序数组 II
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 */
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int evenIndex = 0;
        int oddIndex = 1;
        for (int num : A) {
            if (num % 2 == 0) {
                res[evenIndex] = num;
                evenIndex += 2;
            } else {
                res[oddIndex] = num;
                oddIndex += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = new int[]{4, 2, 5, 7};
        int[] res = s.sortArrayByParityII(A);
        System.out.println(Arrays.toString(res));

        A = new int[]{648, 831, 560, 986, 192, 424, 997, 829, 897, 843};
        res = s.sortArrayByParityII(A);
        System.out.println(Arrays.toString(res));
    }
}