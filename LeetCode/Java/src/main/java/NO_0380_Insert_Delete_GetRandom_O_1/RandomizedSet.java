package NO_0380_Insert_Delete_GetRandom_O_1;

import java.util.*;

class RandomizedSet {

    /**
     * map 用于记录元素及其在 list 中索引
     */
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
        size = 0;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            // 因原 list 中元素并未真正删除，故不能直接使用 list.add(val)
            list.add(size, val);
            map.put(val, size++);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            // 将 list 尾部元素替换为待删除元素，size 减 1
            Integer index = map.get(val);
            Integer tail = list.get(--size);
            list.set(index, tail);
            map.put(tail, index);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */