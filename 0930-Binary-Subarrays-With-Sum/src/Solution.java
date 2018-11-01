/**
 * 930. 和相同的二元子数组
 * <p>
 * 在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。
 * <p>
 * 示例：
 * <p>
 * 输入：A = [1,0,1,0,1], S = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * <p>
 * 提示：
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] 为 0 或 1
 */
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            count += numSubarraysWithSum(A, S, i + 1, A[i], 0);
        }
        return count;
    }

    private int numSubarraysWithSum(int[] A, int S, int index, int sum, int count) {
        if (sum == S) {
            ++count;
        }
        if (index >= A.length) {
            return count;
        }
        sum += A[index];

        return numSubarraysWithSum(A, S, index + 1, sum, count);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2);
        solution.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0);
        solution.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 0);
    }
}
