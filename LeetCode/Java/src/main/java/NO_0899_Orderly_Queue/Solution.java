package NO_0899_Orderly_Queue;

import java.util.Arrays;

class Solution {
    public String orderlyQueue1(String s, int k) {
        if (k == 1) {
            String res = s;
            for (int i = 0; i < s.length() - 1; i++) {
                s = s.substring(1) + s.charAt(0);
                if (s.compareTo(res) < 0) res = s;
            }
            return res;
        }
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String res = s;
            char minChar = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c > minChar) continue;
                String tmp = s.substring(i) + s.substring(0, i);
                if (c < minChar) {
                    minChar = c;
                    res = tmp;
                } else if (tmp.compareTo(res) < 0) {
                    res = tmp;
                }
            }
            return res;
        }
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.orderlyQueue("baaca", 3);
        System.out.println(res);
        res = solution.orderlyQueue("cba", 1);
        System.out.println(res);
    }
}
