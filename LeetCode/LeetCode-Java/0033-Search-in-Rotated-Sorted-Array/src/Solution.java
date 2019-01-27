class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int low, int high, int target) {
        int res = -1;
        if (low > high) {
            return res;
        }
        int mid = low + (high - low) / 2;
        // 判断是否有序
        if (nums[mid] >= nums[low] && nums[mid] <= nums[high]) {
            // 有序部分采用二分法
            if (nums[mid] == target) {
                res = mid;
            } else if (nums[mid] > target) {
                res = search(nums, low, mid - 1, target);
            } else {
                res = search(nums, mid + 1, high, target);
            }
        } else {
            // 无序部分继续划分，直到有序
            res = search(nums, low, mid, target);
            if (res == -1) {
                res = search(nums, mid + 1, high, target);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2);
        System.out.println(res);
    }
}