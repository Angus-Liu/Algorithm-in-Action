package NO_0831_Masking_Personal_Information;

class Solution {
    public String maskPII(String s) {
        StringBuilder sb = new StringBuilder();
        int atIdx = s.indexOf('@');
        if (atIdx != -1) {
            s = s.toLowerCase();
            sb.append(s.charAt(0))
                    .append("*****")
                    .append(s.substring(atIdx - 1));
        } else {
            // s = s.replaceAll("[^0-9]", "") 亦可
            s = s.replaceAll("[+\\-()\\s]", "");
            switch (s.length()) {
                case 10 -> sb.append("***-***-");
                case 11 -> sb.append("+*-***-***-");
                case 12 -> sb.append("+**-***-***-");
                case 13 -> sb.append("+***-***-***-");
            }
            sb.append(s.substring(s.length() - 4));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.maskPII("LeetCode@LeetCode.com");
        System.out.println("res = " + res);

        res = solution.maskPII("AB@qq.com");
        System.out.println("res = " + res);

        res = solution.maskPII("1(234)567-890");
        System.out.println("res = " + res);

        res = solution.maskPII("86-(10)12345678");
        System.out.println("res = " + res);
    }
}