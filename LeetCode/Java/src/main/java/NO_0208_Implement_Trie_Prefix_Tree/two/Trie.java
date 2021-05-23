package NO_0208_Implement_Trie_Prefix_Tree.two;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Angus
 * @date 2018/10/20
 */
class Trie {

    boolean isTail;
    Map<Character, Trie> next;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        next = new HashMap<>();
        isTail = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Trie());
            }
            cur = cur.next.get(c);
        }
        cur.isTail = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isTail;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie cur = this;
        for (char c : prefix.toCharArray()) {
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

/**
 * Your one.Trie1 object will be instantiated and called as such:
 * one.Trie1 obj = new one.Trie1();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
