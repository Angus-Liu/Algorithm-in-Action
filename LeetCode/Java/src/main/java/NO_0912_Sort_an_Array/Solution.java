package NO_0912_Sort_an_Array;

class Solution {
    // 希尔排序
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        // step 为步长
        for (int step = n / 2; step >= 1; step /= 2) {
            for (int i = step; i < n; i++) {
                int t = nums[i];
                int j;
                for (j = i; j >= step && t < nums[j - step]; j -= step) {
                    nums[j] = nums[j - step];
                }
                nums[j] = t;
            }
        }
        return nums;
    }
}
