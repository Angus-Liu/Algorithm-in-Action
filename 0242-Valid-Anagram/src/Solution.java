import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return String.valueOf(sChars).equals(String.valueOf(tChars));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean isAnagram = solution.isAnagram("anagram", "nagaram");
        System.out.println(isAnagram);
    }
}