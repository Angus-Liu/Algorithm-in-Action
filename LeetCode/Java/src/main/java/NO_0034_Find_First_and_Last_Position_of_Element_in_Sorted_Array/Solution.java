package NO_0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

class Solution {

    private int startIndex = Integer.MAX_VALUE;
    private int endIndex = -1;

    /**
     * 二分查找 + 递归
     */
    public int[] searchRange_1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        searchRange(nums, 0, nums.length - 1, target);
        return new int[]{startIndex == Integer.MAX_VALUE ? -1 : startIndex, endIndex};
    }

    private void searchRange(int[] nums, int l, int r, int target) {
        if (l <= r && nums[l] <= target && nums[r] >= target) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                startIndex = Math.min(startIndex, m);
                endIndex = Math.max(endIndex, m);
                searchRange(nums, l, m - 1, target);
                searchRange(nums, m + 1, r, target);
            } else if (nums[m] < target) {
                searchRange(nums, m + 1, r, target);
            } else {
                searchRange(nums, l, m - 1, target);
            }
        }
    }

    /**
     * 二分查找 + 遍历
     */
    public int[] searchRange(int[] nums, int target) {
        int startIndex = -1, endIndex = -1;
        if (nums == null || nums.length == 0) {
            return new int[]{startIndex, endIndex};
        }
        int l = 0, r = nums.length - 1, m = 0;
        while (l <= r) {
            // 以下代码加上后效率会有所提升
            // if(nums[l] == target && nums[r] == target)
            //     return new int[]{l, r};
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                break;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (nums[m] == target) {
            for (int i = m; i >= 0; i--) {
                if (nums[i] == target) {
                    startIndex = i;
                }
            }
            for (int i = m; i < nums.length; i++) {
                if (nums[i] == target) {
                    endIndex = i;
                }
            }
        }
        return new int[]{startIndex, endIndex};
    }

    public static void main(String[] args) {
        int[] res = new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(res));
    }
}