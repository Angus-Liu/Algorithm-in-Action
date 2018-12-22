import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    /**
     * 用以判断某位数字是否已在排列中
     */
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 较 46 题，添加两个地方，一是首先对 nums 排序，二是往排列中添加数字时，若是与上一个相同则 continue 循环
        if (nums == null || nums.length == 0) {
            return res;
        }
        // 树形问题，递归回溯法
        used = new boolean[nums.length];
        Arrays.sort(nums);
        List<Integer> p = new ArrayList<>();
        generatePermutationUnique(nums, 0, p);
        return res;
    }

    /**
     * 向 p 中的末尾添加第 index + 1 个元素，获得一个有 index + 1 个元素的排列
     *
     * @param nums  原始待排列数组
     * @param index 表示 p 的排列中中已有几个元素
     * @param p     保存了 index 个元素的排列
     */
    private void generatePermutationUnique(int[] nums, int index, List<Integer> p) {
        if (index == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 该数字未被使用，才进行添加操作
            if (!used[i]) {
                // 若该数字其前一个数字相同，而前一个数字未被使用，不予添加（只允许其前一个相同数字使用过后，才让其添加，消除重复情况）
                // 目的在于让相同数字依次使用，消除重复情况
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                p.add(nums[i]);
                used[i] = true;
                // 递归，寻找下一个数字加入排列
                generatePermutationUnique(nums, index + 1, p);
                // 回溯，消除排列中的该数字及其使用标志
                p.remove(p.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1, 1, 1, 3}));
    }
}