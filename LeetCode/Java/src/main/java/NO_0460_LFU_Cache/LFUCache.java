package NO_0460_LFU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author angus
 * @date 2019/9/29
 */
class LFUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        // 在缓存中
        if (map.containsKey(key)) {
            // 更新次数
            Node vNode = map.get(key);
            vNode.freq++;
            // 调整链表
            if (vNode == head) {
                if (vNode.freq >= vNode.succeed.freq) {

                }
            } else if (vNode == tail) {

            } else {

            }
            return vNode.value;
        }
        // 不在缓存中
        return -1;
    }

    public void put(int key, int value) {
        // 在缓存中
        // 不在缓存中（涉及到要不要删缓存）
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
