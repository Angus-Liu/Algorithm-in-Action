import java.util.HashMap;
        import java.util.Map;

class Solution {
    /**
     * 与 290 号问题相似
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic_1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            Character tChar = map.get(sChars[i]);
            if (tChar == null) {
                // 防止有多个字母对应同一个字母
                if (map.containsValue(tChars[i])) {
                    return false;
                }
                map.put(sChars[i], tChars[i]);
            } else {
                if (!tChar.equals(tChars[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        int[] pos1 = new int[256];
        int[] pos2 = new int[256];
        for (int i = s.length() - 1; i >= 0; --i) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (pos1[cs] != pos2[ct]) {
                return false;
            }
            pos1[cs] = pos2[ct] = i;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean isomorphic = solution.isIsomorphic("egg", "ggg");
        System.out.println(isomorphic);
    }
}