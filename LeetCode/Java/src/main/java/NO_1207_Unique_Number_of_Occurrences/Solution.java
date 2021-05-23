package NO_1207_Unique_Number_of_Occurrences;

import java.util.HashMap;
import java.util.Map;

/**
 * 独一无二的出现次数
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int n : arr) {
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }
        return frequency.values().stream().distinct().count() == frequency.size();
    }

    public boolean uniqueOccurrences2(int[] arr) {
        int[] freq = new int[2001];
        for (int i : arr) {
            freq[i + 1000] += 1;
        }
        for (int i = 0; i < freq.length - 1; i++) {
            if (freq[i] == 0) continue;
            for (int j = i + 1; j < freq.length; j++) {
                if (freq[j] == 0) continue;
                if (freq[i] == freq[j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(s.uniqueOccurrences2(arr));
    }
}