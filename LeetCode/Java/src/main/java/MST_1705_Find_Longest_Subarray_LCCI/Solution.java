package MST_1705_Find_Longest_Subarray_LCCI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 前缀和
     */
    public String[] findLongestSubarray(String[] array) {
        Map<Integer, Integer> sumToIdx = new HashMap<>();
        sumToIdx.put(0, -1);
        int start = 0, maxLen = 0;
        for (int i = 0, preSum = 0; i < array.length; i++) {
            preSum += array[i].charAt(0) <= '9' ? -1 : 1;
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
