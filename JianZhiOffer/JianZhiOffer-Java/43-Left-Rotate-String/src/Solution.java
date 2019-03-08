public class Solution {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) return "";
        char[] chArr = str.toCharArray();
        n %= chArr.length;
        reverse(chArr, 0, chArr.length - 1);
        reverse(chArr, 0, chArr.length - n - 1);
        reverse(chArr, chArr.length - n, chArr.length - 1);
        return new String(chArr);
    }

    private void reverse(char[] chArr, int start, int end) {
        while (start < end) {
            char ch = chArr[start];
            chArr[start++] = chArr[end];
            chArr[end--] = ch;
        }
    }
}