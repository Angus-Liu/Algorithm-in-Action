package STR_TO_IP;

import java.util.*;


public class Solution {
    /**
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        ArrayList<String> res = new ArrayList();
        int n = s.length();
        if (n < 4) return res;
        for (int i = 1; i < 4 && i < n; i++) {
            String s1 = s.substring(0, i);
            System.out.println("s1 = " + s1);
            int n1 = Integer.parseInt(s1);
            if (n1 != 0 && s1.startsWith("0")) break;
            if ((i > 1 && n1 == 0) || n1 > 255) break;
            for (int j = i + 1; j < i + 4 && j < n; j++) {
                String s2 = s.substring(i, j);
                System.out.println("s2 = " + s2);
                int n2 = Integer.parseInt(s2);
                if (n2 != 0 && s2.startsWith("0")) break;
                if ((j - i > 1 && n2 == 0) || n2 > 255) break;
                for (int k = j + 1; k < j + 4 && k < n; k++) {
                    String s3 = s.substring(j, k);
                    System.out.println("s3 = " + s3);
                    int n3 = Integer.parseInt(s3);
                    if (n3 != 0 && s3.startsWith("0")) break;
                    if ((k - j > 1 && n3 == 0) || n3 > 255) break;
                    if (n - k > 3) continue;
                    String s4 = s.substring(k, n);
                    System.out.println("s4 = " + s4);
                    int n4 = Integer.parseInt(s4);
                    if (n4 != 0 && s4.startsWith("0")) continue;
                    if ((n > k + 1 && n4 == 0) || n4 > 255) continue;
                    res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> res = solution.restoreIpAddresses("0000");
        System.out.println("res = " + res);
    }
}
