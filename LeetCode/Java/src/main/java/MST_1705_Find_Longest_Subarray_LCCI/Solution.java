package MST_1705_Find_Longest_Subarray_LCCI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 前缀和
     */
    public String[] findLongestSubarray(String[] array) {
        // 使用哈希表来记录前缀和及其对应最左索引
        Map<Integer, Integer> sumToIdx = new HashMap<>();
        // 为了处理数组中第一个元素开始就是最长子数组的情况，
        // 将前缀和为 0 的索引设为 -1 并加入哈希表中。
        sumToIdx.put(0, -1);
        int start = 0, maxLen = 0;
        for (int i = 0, preSum = 0; i < array.length; i++) {
            // 字符串为数字时前缀和减 1，为字母时前缀和加 1
            preSum += array[i].charAt(0) <= '9' ? -1 : 1;
            // 如果当前前缀和已经存在于哈希表中，则 i 与 preIdx 之间的和为 0，
            // 说明 i 与 preIdx 之间数字和字母数目相同
            if (sumToIdx.containsKey(preSum)) {
                int preIdx = sumToIdx.get(preSum);
                int curLen = i - preIdx;
                if (curLen > maxLen) {
                    maxLen = curLen;
                    start = preIdx + 1;
                }
            } else {
                sumToIdx.put(preSum, i);
            }
        }
        return Arrays.copyOfRange(array, start, start + maxLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] res = solution.findLongestSubarray(new String[]{
                "A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"
        });
        System.out.println(Arrays.toString(res));
        res = solution.findLongestSubarray(new String[]{
                "AA", "1", "2", "A", "1", "BB", "33"
        });
        System.out.println(Arrays.toString(res));
        res = solution.findLongestSubarray(new String[]{
                "42", "10", "O", "t", "y", "p", "g", "B", "96", "H", "5", "v", "P", "52", "25", "96", "b", "L", "Y", "z", "d", "52", "3", "v", "71", "J", "A", "0", "v", "51", "E", "k", "H", "96", "21", "W", "59", "I", "V", "s", "59", "w", "X", "33", "29", "H", "32", "51", "f", "i", "58", "56", "66", "90", "F", "10", "93", "53", "85", "28", "78", "d", "67", "81", "T", "K", "S", "l", "L", "Z", "j", "5", "R", "b", "44", "R", "h", "B", "30", "63", "z", "75", "60", "m", "61", "a", "5", "S", "Z", "D", "2", "A", "W", "k", "84", "44", "96", "96", "y", "M"
        });
        System.out.println(Arrays.toString(res));
    }
}
