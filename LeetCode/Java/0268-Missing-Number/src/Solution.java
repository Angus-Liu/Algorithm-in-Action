import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int missingNumber_1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return n * (n + 1) / 2 - sum;
    }

    public int missingNumber_2(int[] nums) {
        return IntStream.rangeClosed(1,nums.length).sum() - IntStream.of(nums).sum();
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                res = i;
                break;
            }
        }
        return res;
    }
}