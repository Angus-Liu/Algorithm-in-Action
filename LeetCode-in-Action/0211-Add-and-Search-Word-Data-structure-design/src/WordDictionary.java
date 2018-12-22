import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Angus
 * @date 2018/10/20
 */
class WordDictionary {

    /**
     * 前缀树的节点
     */
    private class Node {
        boolean isWord;
        Map<Character, Node> next;

        Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        Node() {
            this(false);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(root, 0, word);
    }

    /**
     * 递归匹配
     *
     * @param node  带匹配节点
     * @param index 当前需要匹配 word 中的字符的位置
     * @param word  待匹配的单词
     * @return
     */
    private boolean search(Node node, int index, String word) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            // '.' 匹配任意字符
            for (Character nextChar : node.next.keySet()) {
                if (search(node.next.get(nextChar), index + 1, word)) {
                    return true;
                }
            }
            // 循环结束仍未匹配到
            return false;
        } else {
            // 匹配单个字符
            if (node.next.get(c) == null) {
                return false;
            }
            return search(node.next.get(c), index + 1, word);
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */