package NO_0049_Group_Anagrams;

import java.util.*;

class Solution {
    /**
     * 查找表法
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // 将每个字符串对应字符数组经排序后得到的字符串作为该字符串的分类标志
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(res);
    }
}