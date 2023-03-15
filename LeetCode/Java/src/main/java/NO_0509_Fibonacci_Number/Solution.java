package NO_0509_Fibonacci_Number;

class Solution {
    public int fib(int n) {
        int cur = 0;
        int next = 1;
        while (n-- > 0) {
            next += cur;
            cur = next - cur;
        }
        return cur;
    }
}