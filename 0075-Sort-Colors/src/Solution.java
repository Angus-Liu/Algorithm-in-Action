import java.util.Arrays;

class Solution {

    public void sortColors(int[] nums) {
        // 利用三路快排的思想，只需要一次遍历就完成排序
        // nums[0, zero] == 0，初始时为空，所以 zero 为 -1
        int zero = -1;
        // nums[two, nums.length - 1] == 2，初始时为空，所以 two 为 nums.length
        int two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 0) {
                swap(nums, ++zero, i);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                // nums[i] == 2
                swap(nums, --two, i);
                // 此时不需要 i++，因为 --two 对应的数字大小仍然不知道
            }
        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sortColors2(int[] nums) {
        int[] count = new int[3];
        // 计数排序法
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}