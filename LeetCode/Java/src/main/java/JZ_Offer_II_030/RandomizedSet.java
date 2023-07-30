package JZ_Offer_II_030;

import java.util.*;

class RandomizedSet {

    /**
     * map 用于记录元素及其在 list 中索引
     */
    private Map<Integer, Integer> indices;
    private List<Integer> nums;
    private Random random;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        indices = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
        size = 0;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        } else {
            // 因原 list 中元素并未真正删除，故不能直接使用 list.add(val)
            nums.add(size, val);
            indices.put(val, size++);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (indices.containsKey(val)) {
            // 将 list 尾部元素替换为待删除元素，size 减 1
            Integer index = indices.get(val);
            Integer tail = nums.get(--size);
            nums.set(index, tail);
            indices.put(tail, index);
            indices.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get(random.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
