package NO_6315_Count_the_Number_of_Vowel_Strings_in_Range;

import java.util.Set;

class Solution {
    private final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (vowels.contains(words[i].charAt(0))
                    && vowels.contains(words[i].charAt(words[i].length() - 1)))
                res++;
        }
        return res;
    }
}
