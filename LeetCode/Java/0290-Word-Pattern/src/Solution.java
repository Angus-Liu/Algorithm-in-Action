import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public boolean wordPattern(String pattern, String str) {
        char[] patterns = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (patterns.length != strs.length) {
            return false;
        }
        Map<Character, String> patternMap = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            String s = patternMap.get(patterns[i]);
            if (s == null) {
                // 杜绝 pattern = abba, str = dog dog dog dog 这种情形
                if (patternMap.containsValue(strs[i])) {
                    return false;
                } else {
                    patternMap.put(patterns[i], strs[i]);
                }
            } else {
                if (!s.equals(strs[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        char[] patterns = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (patterns.length != strs.length) {
            return false;
        }
        Map<Character, List<Integer>> patternMap = new HashMap<>();
        Map<String, List<Integer>> strMap = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            List<Integer> patternList = patternMap.get(patterns[i]);
            if (patternList == null) {
                patternList = new ArrayList<>();
            }
            patternList.add(i);
            patternMap.put(patterns[i], patternList);

            List<Integer> strList = strMap.get(strs[i]);
            if (strList == null) {
                strList = new ArrayList<>();
            }
            strList.add(i);
            strMap.put(strs[i], strList);

            boolean isMatch = patternList.containsAll(strList) && strList.containsAll(patternList);
            if (!isMatch) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean pattern = solution.wordPattern("bbba", "dog dog dog cat");
        System.out.println(pattern);
    }
}