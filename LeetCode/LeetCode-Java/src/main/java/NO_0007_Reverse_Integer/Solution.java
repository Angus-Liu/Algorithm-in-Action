package NO_0007_Reverse_Integer;

class Solution {

    public int reverse(int x) {
        int num = x < 0 ? -x : x;
        char[] nums = String.valueOf(num).toCharArray();
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int p = res * 10;
            if (p / 10 == res) {
                res = p + (nums[i] - '0');
            } else {
                return 0;
            }
        }
        return x < 0 ? -res : res;
    }

    public int reverse_2(int x) {
        int num = x < 0 ? -x : x;
        int res = 0;
        while (num > 0) {
            int p = res * 10;
            if (p / 10 == res) {
                res = p + (num % 10);
                num /= 10;
            } else {
                return 0;
            }
        }
        return x < 0 ? -res : res;
    }

    public int reverse_3(int x) {
        long num = x < 0 ? -x : x;
        long res = 0;
        while (num > 0) {
            res = res * 10 + (num % 10);
            num /= 10;
            if (res > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) (x < 0 ? -res : res);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(120));
        System.out.println(new Solution().reverse(1534236469));
    }
}