package NO_0349_Intersection_of_Two_Arrays;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection_1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                // 这里仍然用 set 是为了除去 nums2 中的重复数值
                set2.add(num);
            }
        }
        int[] res = new int[set2.size()];
        int i = 0;
        for (int num : set2) {
            res[i++] = num;
        }
        return res;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int i = 0;
        for (int num : set1) {
            res[i++] = num;
        }
        return res;
    }
}
