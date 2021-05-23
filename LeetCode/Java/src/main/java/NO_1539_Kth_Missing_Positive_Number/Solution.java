package NO_1539_Kth_Missing_Positive_Number;

/**
 * 第 k 个缺失的正整数
 * https://leetcode-cn.com/problems/kth-missing-positive-number/
 */
class Solution {
    public int findKthPositive(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            // arr[i] 表示当前这个位置数字大小
            // i + 1 表示这个位置没有缺失时数字的大小
            // 两者之差表示缺失的正整数的个数
            if (arr[i] - (i + 1) >= k)
                return i + k;
        }
        return arr.length + k;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = {2, 3, 4, 7, 11};
        System.out.println(s.findKthPositive(arr, 5));

        int[] arr2 = {10, 11, 12, 13};
        System.out.println(s.findKthPositive(arr2, 5));
    }
}
