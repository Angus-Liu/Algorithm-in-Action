package NO_0930_Binary_Subarrays_With_Sum;

class Solution {

    public int numSubarraysWithSum(int[] A, int S) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum > S) {
                    break;
                } else if (sum == S) {
                    res++;
                }
            }
        }

        return res;
    }

    /**
     * 参考
     */
    public int numSubarraysWithSum2(int[] A, int S) {
        if (null == A || A.length == 0) {
            return 0;
        }
        int tempSum = 0, res = 0;
        int[] count = new int[A.length + 1];
        count[0] = 1;
        for (int i : A) {
            tempSum += i;
            if (tempSum >= S) {
                res += count[tempSum - S];
            }
            count[tempSum]++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] A = new int[]{0, 0, 0, 0, 0};
        Solution solution = new Solution();
        System.out.println(solution.numSubarraysWithSum(A, 0));
    }
}
