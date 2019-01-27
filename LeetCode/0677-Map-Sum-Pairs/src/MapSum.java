import java.util.HashMap;
import java.util.Map;

/**
 * @author Angus
 * @date 2018/10/20
 */
class MapSum {

    /**
     * 前缀树的节点
     */
    private class Node {
        private int value;
        Map<Character, Node> next;

        Node(int value) {
            this.value = value;
            next = new HashMap<>();
        }

        Node() {
            this(0);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            Character c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        // 替换成新的值
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        // 遍历到前缀最后一个点
        for (int i = 0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        // 进行递归，统计所有前缀子节点中的键值
        return sum(cur);
    }

    private int sum(Node node) {
        int res = node.value;
        for (char c : node.next.keySet()) {
            // 进行递归，循环遍历统计所有前缀子节点中的键值
            res += sum(node.next.get(c));
        }
        return res;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
