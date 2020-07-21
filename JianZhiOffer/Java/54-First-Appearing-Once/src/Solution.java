import java.util.*;

public class Solution {
    List<Character> list = new ArrayList<>();
    Set<Character> set = new HashSet<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        list.add(ch);
        if (set.contains(ch)) {
            set.remove(ch);
        } else {
            set.add(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (!set.isEmpty()) {
            for (Character ch : list) {
                if (set.contains(ch)) {
                    return ch;
                }
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String str = "google";
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            solution.Insert(ch);
            char res = solution.FirstAppearingOnce();
            System.out.println(res);
        }
    }
}