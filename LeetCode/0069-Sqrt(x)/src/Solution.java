class Solution {
    public int mySqrt(int x) {
        int res = x;
        int low = 1;
        int high = x / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // 防止乘法溢出
            if (mid < x / mid) {
                // res 并不是一次就得到的，而是慢慢逼近
                res = mid;
                low = mid + 1;
            } else if (mid > x / mid ) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new Solution().mySqrt(2147395599);
        System.out.println(i);
    }
}