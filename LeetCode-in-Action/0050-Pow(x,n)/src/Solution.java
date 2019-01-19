class Solution {
    public double myPow_1(double x, int n) {
        return Math.pow(x, n);
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double res = 1;
        long power = Math.abs((long)n);
        while (power != 0) {
            if ((power & 1) == 1) {
                res *= x;
            }
            x *= x;
            power >>= 1;
        }
        return n < 0 ? 1 / res : res;
    }
}