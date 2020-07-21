import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length == 0 || hand.length % W != 0) {
            return false;
        }
        // 数组进行排序预处理，并将元素及其出现次数存储在 map 中
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            Integer count = map.get(i);
            map.put(i, count == null ? 1 : ++count);
        }
        for (int h : hand) {
            if (map.get(h) > 0) {
                // 判断 map 中是否有足够的元素构成顺子
                for (int j = 0; j < W; j++) {
                    Integer count = map.get(h + j);
                    if (count != null && count > 0) {
                        map.put(h + j, count - 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // {1,2,3} {2,3,4} {6,7,8} {12,16,20}
        int[] hand = {1, 2, 3, 2, 3, 4, 6, 7, 8, 12, 16, 20};
        boolean res = new Solution().isNStraightHand(hand, 3);
        System.out.println("res = " + res);
    }
}