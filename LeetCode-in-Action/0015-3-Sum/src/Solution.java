import java.util.*;

class Solution {
    /**
     * 使用 Hash 表存储所有数字
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        // 0 本身是个比较特殊的存在，优先考虑
        if (counter.getOrDefault(0, 0) >= 3) {
            addToList(res, 0, 0, 0);
        }
        // 获取 numSet 代替 nums，即移除重复数字
        Set<Integer> keySet = counter.keySet();
        Integer[] numSet = new Integer[keySet.size()];
        numSet = keySet.toArray(numSet);
        // 将 numSet 进一步排序，用以排除 [-1, 0, 1], [-1, 1, 0] 这种重复情况
        Arrays.sort(numSet);
        // 根据不重复数字的两两组合，判断 Hash 表中是否有符合的第三个数字
        for (int i = 0; i < numSet.length; i++) {
            for (int j = i + 1; j < numSet.length; j++) {
                if (numSet[i] * 2 + numSet[j] == 0 && counter.get(numSet[i]) >= 2) {
                    addToList(res, numSet[i], numSet[i], numSet[j]);
                }
                if (numSet[i] + numSet[j] * 2 == 0 && counter.get(numSet[j]) >= 2) {
                    addToList(res, numSet[i], numSet[j], numSet[j]);
                }
                int k = 0 - numSet[i] - numSet[j];
                if (k > numSet[j] && counter.getOrDefault(k, 0) > 0) {
                    addToList(res, numSet[i], numSet[j], k);
                }
            }
        }
        return res;
    }

    private void addToList(List<List<Integer>> res, int i, int j, int k) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        list.add(k);
        res.add(list);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{1}));
    }
}