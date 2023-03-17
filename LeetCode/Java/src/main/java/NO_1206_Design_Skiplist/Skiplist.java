package NO_1206_Design_Skiplist;

import java.util.Arrays;
import java.util.Random;

class Skiplist {
    private static final int MAX_LEVEL = 32;
    private static final double P_FACTOR = 0.25;
    private final SkiplistNode head;
    private int level;
    private final Random random;

    public Skiplist() {
        this.head = new SkiplistNode(-1, MAX_LEVEL);
        this.level = 0;
        this.random = new Random();
    }

    public boolean search(int target) {
        SkiplistNode cur = head;
        for (int i = level - 1; i >= 0; i--) {
            // 找到第 i 层小于且最接近 target 的元素
            while (cur.forward[i] != null && cur.forward[i].val < target) {
                cur = cur.forward[i];
            }
        }
        cur = cur.forward[0];
        // 检测当前元素的值是否等于 target
        return cur != null && cur.val == target;
    }

    public void add(int num) {
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
        Arrays.fill(update, head);
        SkiplistNode cur = head;
        for (int i = level - 1; i >= 0; i--) {
            // 找到第 i 层小于且最接近 num 的元素
            while (cur.forward[i] != null && cur.forward[i].val < num) {
                cur = cur.forward[i];
            }
            update[i] = cur;
        }
        int lv = randomLevel();
        level = Math.max(level, lv);
        SkiplistNode newNode = new SkiplistNode(num, lv);
        for (int i = 0; i < lv; i++) {
            // 对第 i 层的状态进行更新，将当前元素的 forward 指向新的节点
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public boolean erase(int num) {
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
        SkiplistNode cur = head;
        for (int i = level - 1; i >= 0; i--) {
            // 找到第 i 层小于且最接近 num 的元素
            while (cur.forward[i] != null && cur.forward[i].val < num) {
                cur = cur.forward[i];
            }
            update[i] = cur;
        }
        cur = cur.forward[0];
        // 如果值不存在则返回 false
        if (cur == null || cur.val != num) {
            return false;
        }
        for (int i = 0; i < level; i++) {
            if (update[i].forward[i] != cur) {
                break;
            }
            // 对第 i 层的状态进行更新，将 forward 指向被删除节点的下一跳
            update[i].forward[i] = cur.forward[i];
        }
        // 更新当前的 level
        while (level > 1 && head.forward[level - 1] == null) {
            level--;
        }
        return true;
    }

    private int randomLevel() {
        int lv = 1;
        // 随机生成 lv
        while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
            lv++;
        }
        return lv;
    }

    private static class SkiplistNode {
        int val;
        SkiplistNode[] forward;

        public SkiplistNode(int val, int maxLevel) {
            this.val = val;
            this.forward = new SkiplistNode[maxLevel];
        }
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */