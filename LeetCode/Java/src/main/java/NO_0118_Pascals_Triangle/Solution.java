package NO_0118_Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        res.add(List.of(1));
        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> pre = res.get(i);
            List<Integer> cur = new ArrayList<>();
            cur.add(pre.get(0));
            for (int j = 1; j <= i; j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(pre.get(i));
            res.add(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution().generate(10);
        res.forEach(System.out::println);
    }
}