import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (valid(A[i], A[j], A[k])) {
                        return A[i] + A[j] + A[k];
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 判断三边是否可以构成三角形
     */
    private boolean valid(int i, int j, int k) {
        return i + j > k
                && i + k > j
                && j + k > i
                && Math.abs(i - j) < k
                && Math.abs(i - k) < j
                && Math.abs(j - k) < i;
    }

    public static void main(String[] args) {
        int res = new Solution().largestPerimeter(new int[]{3, 2, 3, 4});
        System.out.println(res);
    }
}