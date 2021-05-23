package NO_0035_Search_Insert_Position;

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target)
                return i;
        }
        return nums.length;
    }

    public int searchInsert2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(target == nums[mid])
                return mid;
            if(target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        System.out.println(solution.searchInsert2(nums, 5));
        System.out.println(solution.searchInsert2(nums, 2));
        System.out.println(solution.searchInsert2(nums, 7));
        System.out.println(solution.searchInsert2(nums, 0));
        System.out.println(solution.searchInsert2(nums, 4));
    }
}