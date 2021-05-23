package NO_0118_Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> firstRow = new ArrayList<>(1);
        firstRow.add(1);
        res.add(firstRow);
        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> lastRow = res.get(i);
            List<Integer> nextRow = new ArrayList<>();
            nextRow.add(lastRow.get(0));
            for (int j = 1; j <= i; j++) {
                nextRow.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            nextRow.add(lastRow.get(lastRow.size() - 1));
            res.add(nextRow);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution().generate(10);
        res.forEach(System.out::println);
    }
}