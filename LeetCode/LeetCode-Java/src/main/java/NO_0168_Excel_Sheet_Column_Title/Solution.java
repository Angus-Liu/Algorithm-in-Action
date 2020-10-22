package NO_0168_Excel_Sheet_Column_Title;

class Solution {

    char[] letters = {
            'Z', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X',
            'Y'
    };

    public String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            int r = n % 26;
            s.append(letters[r]);
            n /= 26;
            if (r == 0) n--;
        }
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertToTitle(1));
        System.out.println(s.convertToTitle(26));
        System.out.println(s.convertToTitle(28));
        System.out.println(s.convertToTitle(701));
    }
}