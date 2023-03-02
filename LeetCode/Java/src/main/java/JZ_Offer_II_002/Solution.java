package JZ_Offer_II_002;

public class Solution {
public String addBinary(String a, String b) {
    int n = Math.max(a.length(), b.length());
    char[] sum = new char[n + 1]; // 考虑到进位情况，sum 长度为 n + 1
    int carry = 0; // 进位
    for (int i = a.length() - 1, j = b.length() - 1, k = n; k >= 0; i--, j--, k--) {
        if (i >= 0 && a.charAt(i) == '1') carry++;
        if (j >= 0 && b.charAt(j) == '1') carry++;
        sum[k] = (char) (carry % 2 + '0');
        carry = carry >= 2 ? 1 : 0;
    }
    // 头部为 0 时需要去掉
    return sum[0] == '1' ? String.valueOf(sum) : String.valueOf(sum, 1, n);
}

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.addBinary("1011", "1011");
        System.out.println("res = " + res);
    }
}
