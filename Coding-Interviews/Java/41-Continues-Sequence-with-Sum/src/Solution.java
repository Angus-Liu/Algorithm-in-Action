import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3) return res;

        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;

        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(small);
        seq.add(big);
        while (small < middle) {
            if (curSum == sum) {
                res.add(new ArrayList<>(seq));
            }
            while (curSum > sum && small < middle) {
                curSum -= small;
                seq.remove(0);
                small++;
                if (curSum == sum) {
                    res.add(new ArrayList<>(seq));
                }
            }
            big++;
            curSum += big;
            seq.add(big);
        }

        return res;
    }
}