package NO_0648_Replace_Words.one;

import java.util.Arrays;
import java.util.List;

class Solution {

    /**
     * 前缀树的节点
     */
    private class Node {
        boolean isRoot;
        Node[] next;

        Node() {
            next = new Node[26];
        }

        void insert(String word) {
            Node cur = this;
            for (char c : word.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Node();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isRoot = true;
        }

        String replace(String word) {
            Node cur = this;
            StringBuilder root = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (cur.isRoot) {
                    return root.toString();
                } else if (cur.next[c - 'a'] != null) {
                    root.append(c);
                } else {
                    break;
                }
                cur = cur.next[c - 'a'];
            }
            return word;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        Node trie = new Node();
        dict.forEach(trie::insert);
        return Arrays.stream(sentence.split("\\s"))
                .map(trie::replace)
                .reduce((a, b) -> a + " " + b)
                .get();
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String res = new Solution().replaceWords(dict, sentence);
        System.out.println("res = " + res);
    }
}