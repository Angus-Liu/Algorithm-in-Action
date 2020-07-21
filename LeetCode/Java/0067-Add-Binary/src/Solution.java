class Solution {
    public String addBinary(String a, String b) {
        char[] charsA, charsB;
        if (a.length() > b.length()) {
            charsA = a.toCharArray();
            charsB = b.toCharArray();
        } else {
            charsA = b.toCharArray();
            charsB = a.toCharArray();
        }
        int carry = 0;
        int sum;
        for (int i = charsA.length - 1, j = charsB.length - 1; i >= 0; i--, j--) {
            if (j>= 0) {
                sum = charsA[i] - '0' + charsB[j] - '0' + carry;
            } else {
                sum = charsA[i] - '0' + carry;
            }
            charsA[i] = (char) (sum % 2 + '0');
            carry = sum / 2;
        }
        if (carry != 0) {
            return 1 + new String(charsA);
        }
        return new String(charsA);
    }
}