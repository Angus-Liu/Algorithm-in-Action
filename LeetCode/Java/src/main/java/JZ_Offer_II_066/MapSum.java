package JZ_Offer_II_066;

import java.util.HashMap;
import java.util.Map;

class MapSum {

    private final Trie root;

    private final Map<String, Integer> kv;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Trie();
        kv = new HashMap<>();
    }

    public void insert(String key, int val) {
        Trie cur = root;
        int diff = val - kv.getOrDefault(key, 0);
        for (char c : key.toCharArray()) {
            int idx = c - 'a';
            if (cur.next[idx] == null) {
                cur.next[idx] = new Trie();
            }
            cur = cur.next[idx];
            cur.val += diff;
        }
        kv.put(key, val);
    }

    public int sum(String prefix) {
        Trie cur = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (cur.next[idx] == null) {
                return 0;
            }
            cur = cur.next[idx];
        }
        return cur.val;
    }

    static class Trie {
        private int val = 0;
        private Trie[] next = new Trie[26];
    }

    public static void main(String[] args) {
        MapSum ms = new MapSum();
        ms.insert("apple", 3);
        System.out.println(ms.sum("ap"));
        ms.insert("app", 2);
        ms.insert("apple", 2);
        System.out.println(ms.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
