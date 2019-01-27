import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    /**
     * 哈希表
     */
    public int singleNumber_1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        AtomicInteger res = new AtomicInteger();
        set.forEach(res::set);
        return res.get();
    }

    /**
     * 位运算
     */
    public int singleNumber_2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            // 异或
            res ^= num;
        }
        return res;
    }

    /**
     * 归约-位运算
     */
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (left, right) -> left ^ right);
    }
}