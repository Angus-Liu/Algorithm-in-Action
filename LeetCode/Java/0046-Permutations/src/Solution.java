import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    /**
     * 用以判断某位数字是否已在排列中
     */
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        // 树形问题，递归回溯法
        used = new boolean[nums.length];
        List<Integer> p = new ArrayList<>();
        generatePermutation(nums, 0, p);
        return res;
    }

    /**
     * 向 p 中的末尾添加第 index + 1 个元素，获得一个有 index + 1 个元素的排列
     *
     * @param nums  原始待排列数组
     * @param index 表示 p 的排列中中已有几个元素
     * @param p     保存了 index 个元素的排列
     */
    private void generatePermutation(int[] nums, int index, List<Integer> p) {
        if (index == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 本次排列中不存在该数字，才进行添加操作
            if (!used[i]) {
                p.add(nums[i]);
                used[i] = true;
                // 递归，寻找下一个数字加入排列
                generatePermutation(nums, index + 1, p);
                // 回溯，消除排列中的该数字及其使用标志
                p.remove(p.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }
}