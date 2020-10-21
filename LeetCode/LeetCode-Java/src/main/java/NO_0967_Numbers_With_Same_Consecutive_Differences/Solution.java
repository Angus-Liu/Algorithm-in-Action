package NO_0967_Numbers_With_Same_Consecutive_Differences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<Integer> resList = new ArrayList<>();

    public int[] numsSameConsecDiff(int N, int K) {
        int lowerBound = 0;
        if (N > 1) {
            lowerBound = (int) Math.pow(10, N - 1);
        }
        for (int i = 0; i < 10; i++) {
            numsSameConsecDiff(N, K, 1, i, 0, lowerBound);
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            Integer num = resList.get(i);
            res[i] = num;
        }
        return res;
    }

    private void numsSameConsecDiff(int N, int K, int index, int num, int sum, int lowerBound) {
        sum = sum * 10 + num;
        if (index == N) {
            if (sum >= lowerBound && !resList.contains(sum)) {
                resList.add(sum);
            }
            return;
        }
        if (num + K < 10) {
            numsSameConsecDiff(N, K, index + 1, num + K, sum, lowerBound);
        }
        if (num >= K) {
            numsSameConsecDiff(N, K, index + 1, num - K, sum, lowerBound);
        }
    }

    public static void main(String[] args) {
        int[] res = new Solution().numsSameConsecDiff(2, 0);
        System.out.println(Arrays.toString(res));
    }
}