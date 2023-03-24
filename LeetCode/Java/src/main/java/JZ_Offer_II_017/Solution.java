package JZ_Offer_II_017;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }
        int minL = 0;
        int minR = contains(sMap, tMap) ? t.length() - 1 : Integer.MAX_VALUE;
        for (int l = 0, r = t.length(); r < s.length(); r++) {
            sMap.merge(s.charAt(r), 1, Integer::sum);
            while (contains(sMap, tMap)) {
                if (r - l < minR - minL) {
                    minL = l;
                    minR = r;
                }
                sMap.merge(s.charAt(l++), -1, Integer::sum);
            }
        }
        return minR == Integer.MAX_VALUE ? "" : s.substring(minL, minR + 1);
    }

    private boolean contains(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (sMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.minWindow("ADOBECODEBCANC", "ABC");
        System.out.println("res = " + res);
    }
}
