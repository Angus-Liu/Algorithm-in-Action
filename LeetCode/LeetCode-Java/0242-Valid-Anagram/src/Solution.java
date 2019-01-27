import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram_1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return String.valueOf(sChars).equals(String.valueOf(tChars));
    }

    public boolean isAnagram_2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                return false;
            } else if (count > 1) {
                map.put(ch, count - 1);
            } else {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }

    public boolean isAnagram(String s, String t) {
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        for (char ch : s.toCharArray()) {
            sCounts[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            tCounts[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] != tCounts[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean isAnagram = solution.isAnagram("anagram", "nagaram");
        System.out.println(isAnagram);
    }
}