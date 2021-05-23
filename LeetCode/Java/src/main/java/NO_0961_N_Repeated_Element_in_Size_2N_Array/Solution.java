package NO_0961_N_Repeated_Element_in_Size_2N_Array;

import java.util.Arrays;

class Solution {
    public int repeatedNTimes_1(int[] A) {
        int res = A[0];
        int[] countArr = new int[10000];
        for (int i : A) {
            countArr[i]++;
            if (countArr[i] == A.length / 2) {
                res = i;
                break;
            }
        }
        return res;
    }

    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        return A[A.length / 2] == A[A.length - 1] ? A[A.length - 1] : A[A.length / 2 - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedNTimes(new int[]{1, 2, 3, 3}));
    }
}