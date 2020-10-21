package NO_0283_Move_Zeroes;

import java.util.Arrays;

class Solution {
    public void moveZeroes_1(int[] nums) {
        // nums 中，[0,k)的元素为非 0 元素
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j++] = temp;
                } else {
                    j++;
                }
            }
        }
    }

    public void moveZeroes_2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 0, 1};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}