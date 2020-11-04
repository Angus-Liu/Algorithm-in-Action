package NO_1122_Relative_Sort_Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组的相对排序
 * https://leetcode-cn.com/problems/relative-sort-array/
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr2.length;
        Map<Integer, Integer> numToIdx = new HashMap<>();
        Map<Integer, Integer> idxToNum = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            numToIdx.put(arr2[i], i);
            idxToNum.put(i, arr2[i]);
        }
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = numToIdx.getOrDefault(arr1[i], arr1[i] + n);
        }
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = idxToNum.getOrDefault(arr1[i], arr1[i] - n);
        }
        return arr1;
    }

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] buckets = new int[1001];
        for (int a1 : arr1) {
            buckets[a1]++;
        }
        int i = 0;
        for (int a2 : arr2) {
            int count = buckets[a2];
            while (count-- > 0) {
                arr1[i++] = a2;
            }
            buckets[a2] = 0;
        }
        for (int j = 0; j < buckets.length; j++) {
            int count = buckets[j];
            while (count-- > 0) {
                arr1[i++] = j;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] res = s.relativeSortArray2(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }
}