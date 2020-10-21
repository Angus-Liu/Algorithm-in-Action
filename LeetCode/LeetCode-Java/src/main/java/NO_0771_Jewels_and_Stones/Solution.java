package NO_0771_Jewels_and_Stones;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numJewelsInStones(String J, String S) {
        char[] jArr = J.toCharArray();
        char[] sArr = S.toCharArray();
        int[] alphabet = new int['z' - 'A' + 1];
        for (char jewel : jArr) {
            alphabet[jewel - 'A'] = 1;
        }
        int res = 0;
        for (char stone : sArr) {
            res += alphabet[stone - 'A'];
        }
        return res;
    }

    public int numJewelsInStones2(String J, String S) {
        char[] jewels = J.toCharArray();
        char[] stones = S.toCharArray();
        Set<Character> jewelSet = new HashSet<>();
        for (char jewel : jewels) {
            jewelSet.add(jewel);
        }
        int res = 0;
        for (char stone : stones) {
            if (jewelSet.contains(stone)) {
                res++;
            }
        }
        return res;
    }
}