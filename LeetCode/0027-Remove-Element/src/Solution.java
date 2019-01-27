import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int newLength = solution.removeElement(nums, 2);
        System.out.println(newLength);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{3, 2, 2, 3};
        newLength = solution.removeElement(nums, 3);
        System.out.println(newLength);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1};
        newLength = solution.removeElement(nums, 1);
        System.out.println(newLength);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{4, 5};
        newLength = solution.removeElement(nums, 5);
        System.out.println(newLength);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 2, 2};
        newLength = solution.removeElement(nums, 2);
        System.out.println(newLength);
        System.out.println(Arrays.toString(nums));
    }
}