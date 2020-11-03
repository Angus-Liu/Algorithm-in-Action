package NO_0941_Valid_Mountain_Array;

/**
 * 有效的山脉数组
 * https://leetcode-cn.com/problems/valid-mountain-array/
 */
class Solution {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;
        int i = 0;
        int j = A.length - 1;
        while (i < j && A[i + 1] > A[i]) i++;
        while (j > i && A[j - 1] > A[j]) j--;
        return i == j && i > 0 && j < A.length - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A1 = new int[]{2, 1};
        System.out.println(s.validMountainArray(A1));
        int[] A2 = new int[]{3, 5, 5};
        System.out.println(s.validMountainArray(A2));
        int[] A3 = new int[]{0, 3, 2, 1};
        System.out.println(s.validMountainArray(A3));
    }
}
