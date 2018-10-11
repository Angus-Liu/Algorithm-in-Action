import java.util.*;

class Solution {
    /**
     * 使用集合实现
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1) {
            list1.add(num);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            if (list1.contains(num)) {
                list2.add(num);
                // 从 list1 除去已匹配的数值
                list1.remove(Integer.valueOf(num));
            }
        }
        int[] res = new int[list2.size()];
        int i = 0;
        for (int num : list2) {
            res[i++] = num;
        }
        return res;
    }

    /**
     * 使用映射实现
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        // 现将 nums1 出现的数值及频次放入映射中
        for (int num : nums1) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, ++count);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            // 获取映射中该数值出现的频次
            Integer count = map.get(num);
            if (count != null && count != 0) {
                list.add(num);
                // 注意每次匹配后，该数值的频次需要减 1（nums1 和 nums2 匹配的数值的频次要相同）
                map.put(num, --count);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersect1(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
