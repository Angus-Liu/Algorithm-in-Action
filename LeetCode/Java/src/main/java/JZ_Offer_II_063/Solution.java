package JZ_Offer_II_063;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    static class Trie {
        private boolean isEnd = false;
        private final Trie[] next = new Trie[26];

        public Trie() {
        }

        public Trie(List<String> words) {
            for (String word : words) {
                insert(word);
            }
        }

        public void insert(String word) {
            Trie cur = this;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (cur.next[i] == null) {
                    cur.next[i] = new Trie();
                }
                cur = cur.next[i];
            }
            cur.isEnd = true;
        }
    }

    public String searchRootOrSelf(Trie trie, String word) {
        StringBuilder root = new StringBuilder();
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (trie.next[i] == null) return word;
            root.append(c);
            if (trie.next[i].isEnd) {
                return root.toString();
            }
            trie = trie.next[i];
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie(dictionary);
        return Arrays.stream(sentence.split(" "))
                .map(word -> searchRootOrSelf(trie, word))
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        List<String> dictionary = List.of("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String res = new Solution().replaceWords(dictionary, sentence);
        System.out.println("res = " + res);
    }
}
