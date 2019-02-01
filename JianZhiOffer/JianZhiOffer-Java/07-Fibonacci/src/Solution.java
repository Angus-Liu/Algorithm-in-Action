public class Solution {
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int res = 0, one = 0, two = 1;
        for (int i = 2; i <= n; i++) {
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }
}