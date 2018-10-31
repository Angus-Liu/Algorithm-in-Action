import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 查找表法
     * 将所有元素放入查找表，之后对于每一个元素 a，查找 target - a 是否存在
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] twoSum = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(twoSum));
    }
}