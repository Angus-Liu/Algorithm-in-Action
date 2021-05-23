package NO_0344_Reverse_String;

class Solution {
    public String reverseString_1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // 对撞指针实现
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return String.valueOf(chars);
    }

    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseString("hello"));
        System.out.println(solution.reverseString("A man, a plan, a canal: Panama"));
    }
}