package NO_0219_Contains_Duplicate_II;

import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * 滑动窗口结合查找表
     * 时间复杂度：O(n)
     * 空间复杂度：O(k)
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 滑动窗口结合查找表，此时滑动窗口即为查找表本身（控制查找表的大小即可控制窗口大小）
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 边添加边查找
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            // 控制查找表（窗口）大小，移除窗口最左边元素
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.containsNearbyDuplicate(new int[]{2, 2, 3, 1, 2, 3}, 2);
        System.out.println(res);
    }
}