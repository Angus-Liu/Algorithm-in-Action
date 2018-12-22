import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 先对 nums 做预处理，排序
        Arrays.sort(nums);
        // sum 为三数之和，diff 则对应其与 target 的接近程度（取绝对值）
        int sum = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - sum);

        for (int i = 0; i < nums.length; i++) {
            // 采用双指针法
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int s = nums[i] + nums[l] + nums[r];
                int d = target - s;
                if (s == target) {
                    return s;
                } else {
                    if (Math.abs(d) < diff) {
                        diff = Math.abs(d);
                        sum = s;
                    }
                    // 根据接近情况移动指针
                    if (d > 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int sumClosest = solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(sumClosest);
    }
}