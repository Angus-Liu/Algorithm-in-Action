import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int FirstNotRepeatingChar_1(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingChar_2(String str) {
        int[] dic = new int[256];
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            dic[ch]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (dic[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (str.indexOf(chars[i]) == str.lastIndexOf(chars[i])) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int res = new Solution().FirstNotRepeatingChar("google");
        System.out.println("res = " + res);
    }
}