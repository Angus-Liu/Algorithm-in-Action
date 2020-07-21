class Solution {
    /**
     * 题目所给重要条件：给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n）
     * 采用二分法，二分查找时的 mid 用来探测比 mid 小的数有多少个
     */
    public int findDuplicate_1(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int m = l + (r - l) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= m) {
                    count++;
                }
            }
            if (count <= m) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    /**
     * 快慢指针思想：和 slow 是指针, nums[slow] 表示取指针对应的元素
     * 注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
     * 因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
     * 即按照寻找链表环入口的思路来做
     */
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}