class Solution {

    public int maxWidthRamp_1(int[] A) {
        return maxWidthRamp(A, 0, A.length - 1);
    }

    private int maxWidthRamp(int[] A, int i, int j) {
        int res = 0;
        if (i >= j) {
            return res;
        }
        if (A[i] > A[j]) {
            res = Math.max(maxWidthRamp(A, i + 1, j), maxWidthRamp(A, i, j - 1));
        } else {
            res = Math.max(res, j - i);
        }
        return res;
    }

    // TODO: 待优化，效率较差
    public int maxWidthRamp(int[] A) {
        int res = 0;
        // 记录上一次最大结果的右边界
        int rBound = 0;
        for (int l = 0; l < A.length - 1; l++) {
            for (int r = A.length - 1; r > l && r > rBound; r--) {
                if (A[l] <= A[r]) {
                    res = Math.max(res, r - l);
                    rBound = r;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 7, 1}));
    }
}