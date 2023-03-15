package NO_1137_Nth_Tribonacci_Number;

class Solution {
    public int tribonacci(int n) {
        // 0 1 1 2 4 7 13 24
        int t0 = 0, t1 = 1, t2 = 1;
        while (n-- > 0) {
            int tmp = t2;
            t2 = t0 + t1 + t2;
            t0 = t1;
            t1 = tmp;
        }
        return t0;
    }
}
