import java.util.Arrays;
import java.util.Random;

class Solution {

    private int[] nums;

    private int[] originalNums;

    public Solution(int[] nums) {
        this.nums = nums;
        this.originalNums = Arrays.copyOf(nums, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.originalNums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, 0, random.nextInt(nums.length));
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */