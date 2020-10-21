package NO_0966_Vowel_Spellchecker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

class Solution {

    private Pattern pattern = Pattern.compile("[aeiou]");

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, String> wordMap = new HashMap<>();
        Map<String, String> wordPatternMap = new HashMap<>();
        for (String word : wordlist) {
            wordMap.put(word, word);
            wordPatternMap.putIfAbsent(word.toLowerCase(), word);
            wordPatternMap.putIfAbsent(wordPattern(word), word);
        }
        // System.out.println(wordMap);
        // System.out.println(wordPatternMap);
        for (int i = 0; i < queries.length; i++) {
            if (wordMap.containsKey(queries[i])) {
                queries[i] = wordMap.get(queries[i]);
                continue;
            }
            String wordPattern = queries[i].toLowerCase();
            if (wordPatternMap.containsKey(wordPattern)) {
                queries[i] = wordPatternMap.get(wordPattern);
                continue;
            }
            wordPattern = wordPattern(queries[i]);
            if (wordPatternMap.containsKey(wordPattern)) {
                queries[i] = wordPatternMap.get(wordPattern);
                continue;
            }
            queries[i] = "";
        }
        return queries;
    }

    private String wordPattern(String word) {
        // return pattern.matcher(word.toLowerCase()).replaceAll("*");
        char[] letters = word.toLowerCase().toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == 'a'
                    || letters[i] == 'e'
                    || letters[i] == 'i'
                    || letters[i] == 'o'
                    || letters[i] == 'u') {
                letters[i] = '*';
            }
        }
        return String.valueOf(letters);
    }

    public static void main(String[] args) {
        String[] wordlist = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        String[] res = new Solution().spellchecker(wordlist, queries);
        System.out.println(Arrays.toString(res));
    }
}