import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int GetNumberOfK_1(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(array).forEach(num -> {
            map.put(num, map.getOrDefault(num, 0) + 1);
        });
        return map.getOrDefault(k, 0);
    }

    /**
     * 因为数组是有序的，所以可以使用二分查找，找到第一个 k 和 最后一个 k 所在位置
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        return getLastK(array, k, 0, array.length - 1) - getFirstK(array, k, 0, array.length - 1);
    }

    private int getFirstK(int[] array, int k, int l, int r) {
        if (l > r) {
            return -1;
        }
        int m = l + (r - l) / 2;
        if (array[m] == k) {
            if (m > 0 && array[m - 1] != k || m == 0) {
                return m;
            } else {
                r = m - 1;
            }
        } else if (array[m] > k) {
            r = m - 1;
        } else {
            l = m + 1;
        }
        return getFirstK(array, k, l, r);
    }

    private int getLastK(int[] array, int k, int l, int r) {
        if (l > r) {
            return -1;
        }
        int m = l + (r - l) / 2;
        if (array[m] == k) {
            if (m < array.length - 1 && array[m + 1] != k || m == array.length - 1) {
                // m 为最后一个 k 的索引，加一是为了方便计算其出现次数
                return m + 1;
            } else {
                l = m + 1;
            }
        } else if (array[m] > k) {
            r = m - 1;
        } else {
            l = m + 1;
        }
        return getLastK(array, k, l, r);
    }
}