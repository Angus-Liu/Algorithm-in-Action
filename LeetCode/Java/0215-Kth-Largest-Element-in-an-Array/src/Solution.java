import java.util.Arrays;

class Solution {

    public int findKthLargest(int[] nums, int k) {
        // 利用快排的思想，实现时间复杂度为 O(n) 的算法
        return findKthLargest(nums, k - 1, 0, nums.length - 1);
    }

    private int findKthLargest(int[] nums, int k, int l, int r) {
        // 利用快排的思想，实现时间复杂度为 O(n) 的算法
        // [l, j - 1] > nums[l]
        // [j + 1, r] < nums[l]
        int j = l + 1;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[l]) {
                swap(nums, i, j++);
            }
        }
        swap(nums, l, --j);
        if (k == j) {
            return nums[j];
        } else if (k < j) {
            // 排名靠前，在前半部分找
            return findKthLargest(nums, k, l, j - 1);
        } else {
            // 靠后，在后半部分找
            return findKthLargest(nums, k, j + 1, r);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findKthLargest_2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}