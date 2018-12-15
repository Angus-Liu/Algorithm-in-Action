import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    /**
     * 哈希表
     */
    public int singleNumber_1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        AtomicInteger res = new AtomicInteger();
        map.forEach((num, count) -> {
            if (count == 1) {
                res.set(num);
            }
        });
        return res.get();
    }

    /**
     * 位运算
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            // 异或
            res ^= num;
        }
        return res;
    }
}