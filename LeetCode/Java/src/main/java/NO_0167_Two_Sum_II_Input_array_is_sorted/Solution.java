package NO_0167_Two_Sum_II_Input_array_is_sorted;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
class Solution {
    /**
     * 对撞指针法
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int lo = 0, hi = numbers.length-1; lo < hi;) {
            int sum = numbers[lo] + numbers[hi];
            if(sum == target) {
                res[0] = lo + 1;
                res[1] = hi + 1;
                break;
            } else if(sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(res));
    }
}