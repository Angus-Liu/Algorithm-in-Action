package two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    /**
     * 前缀树的节点
     */
    private class Node {
        boolean isRoot;
        Map<Character, Node> next = new HashMap<>();

        void insert(String word) {
            Node cur = this;
            for (char c : word.toCharArray()) {
                cur.next.putIfAbsent(c, new Node());
                cur = cur.next.get(c);
            }
            cur.isRoot = true;
        }

        String replace(String word) {
            Node cur = this;
            StringBuilder root = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (cur.isRoot) {
                    return root.toString();
                }
                if (cur.next.containsKey(c)) {
                    root.append(c);
                } else {
                    return word;
                }
                cur = cur.next.get(c);
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