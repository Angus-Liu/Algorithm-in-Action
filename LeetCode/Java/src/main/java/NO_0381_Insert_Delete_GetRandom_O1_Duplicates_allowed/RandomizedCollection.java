package NO_0381_Insert_Delete_GetRandom_O1_Duplicates_allowed;

import java.util.*;

/**
 * O(1) 时间插入、删除和获取随机元素 - 允许重复
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */
class RandomizedCollection {

    Map<Integer, Set<Integer>> vIdxMap;
    List<Integer> vList;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        vIdxMap = new HashMap<>();
        vList = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> vIdxSet = vIdxMap.getOrDefault(val, new HashSet<>());
        vList.add(val);
        vIdxSet.add(vList.size() - 1);
        vIdxMap.put(val, vIdxSet);
        return vIdxSet.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> vIdxSet = vIdxMap.get(val);
        if (vIdxSet == null || vIdxSet.isEmpty()) return false;
        // 找到待删除的索引
        int rIdx = vIdxSet.iterator().next();
        vIdxSet.remove(rIdx);
        // 和数组最后一位数字进行交换
        int lIdx = vList.size() - 1;
        int lVal = vList.get(lIdx);
        vList.set(rIdx, lVal);
        Set<Integer> lvIdxSet = vIdxMap.get(lVal);
        lvIdxSet.add(rIdx);
        lvIdxSet.remove(lIdx);
        vList.remove(lIdx);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return vList.get(new Random().nextInt(vList.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection c = new RandomizedCollection();
        System.out.println(c.insert(1));
        System.out.println(c.insert(1));
        System.out.println(c.insert(2));
        System.out.println(c.getRandom());
        System.out.println(c.remove(1));
        System.out.println(c.getRandom());
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
