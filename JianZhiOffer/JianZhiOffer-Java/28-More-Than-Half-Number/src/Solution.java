import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            int time = map.getOrDefault(i, 0) + 1;
            if (time > array.length / 2) return i;
            map.put(i, time);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new Solution().MoreThanHalfNum_Solution(array));
    }
}