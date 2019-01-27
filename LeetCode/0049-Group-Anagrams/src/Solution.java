import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 查找表法
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // 将每个字符串对应字符数组经排序后得到的字符串作为该字符串的分类标志
            String flag = String.valueOf(chars);
            List<String> list = map.getOrDefault(flag, new ArrayList<>());
            list.add(str);
            map.put(flag, list);
        }
        List<List<String>> res = new ArrayList<>();
        for (String flag : map.keySet()) {
            res.add(map.get(flag));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}