import java.util.Arrays;

/**
 * @author Angus
 * @date 2018/10/20
 */
public class NumArray2 {

    private int[] nums;

    public NumArray2(int[] nums) {
        this.nums = nums;
        // 使得的数组的第 i 位存储的是 0-i 位的和
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? nums[j] : nums[j] - nums[i - 1];
    }

    public static void main(String[] args) {
        NumArray2 obj = new NumArray2(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}
