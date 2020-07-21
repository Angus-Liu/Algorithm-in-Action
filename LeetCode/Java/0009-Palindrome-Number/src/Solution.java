class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int o = x;
        int res = 0;
        while (o > 0) {
            res = res * 10 + o % 10;
            o /= 10;
        }
        return x == res;
    }

    public boolean isPalindrome2(int x) {
        String o = String.valueOf(x);
        String d = new StringBuilder(o).reverse().toString();
        return o.equals(d);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome2(121));
    }
}
