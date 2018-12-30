import java.util.Arrays;
import java.util.List;

class Solution {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        List<String> wordList = Arrays.asList(wordlist);
        for (int i = 0; i < queries.length; i++) {
            boolean similar = false;
            for (int j = 0; j < wordlist.length; j++) {
                if (wordList.contains(queries[i])) {
                    similar = true;
                    break;
                }

                if (similarVowel(queries[i], wordlist[j])) {
                    queries[i] = wordlist[j];
                    similar = true;
                    break;
                }

                if (similar(queries[i].toLowerCase(), wordlist[j].toLowerCase())) {
                    queries[i] = wordlist[j];
                    similar = true;
                    break;
                }
            }
            if (!similar) {
                queries[i] = "";
            }
        }
        return queries;
    }

    private boolean similarVowel(String strA, String strB) {
        if (strA.length() != strB.length()) {
            return false;
        }
        for (int i = 0; i < strA.length(); i++) {
            char chA = strA.charAt(i);
            char chB = strB.charAt(i);
            if (isVowel(chA) && isVowel(chB)) {
                continue;
            }
            if (chA != chB) {
                return false;
            }
        }
        return true;
    }

    private boolean similar(String strA, String strB) {
        if (strA.length() != strB.length()) {
            return false;
        }
        for (int i = 0; i < strA.length(); i++) {
            char chA = strA.charAt(i);
            char chB = strB.charAt(i);
            if (chA != chB) {
                return false;
            }
        }
        return true;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public static void main(String[] args) {
        String[] wordList = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        String[] res = new Solution().spellchecker(wordList, queries);
        System.out.println(Arrays.toString(res));
    }
}