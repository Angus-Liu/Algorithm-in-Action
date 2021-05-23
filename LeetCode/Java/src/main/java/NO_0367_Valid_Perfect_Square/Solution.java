package NO_0367_Valid_Perfect_Square;

class Solution {
    public boolean isPerfectSquare_1(int num) {
        for (int i = 1; i <= 46340; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    public boolean isPerfectSquare(int num) {
        int left = 0;
        // 直接用 num 会发生溢出，所以要么声明为 long 型，要么限定右边界为 46340（√(2147483647)）
        int right = num < 46340 ? num : 46340;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int product = mid * mid;
            if (product == num) {
                return true;
            } else if (product < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}