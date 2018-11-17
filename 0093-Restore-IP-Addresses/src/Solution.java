import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> restoreIpAddresses(String s) {
        // 除了下面比较简单的方法外，应该还可以使用递归回溯来解决
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12) {
            return res;
        }
        for (int i = 1; i <= 3 && i < s.length(); i++) {
            String p1 = s.substring(0, i);
            if (isLegal(p1)) {
                for (int j = i + 1; j <= 6 && j < s.length(); j++) {
                    String p2 = s.substring(i, j);
                    if (isLegal(p2)) {
                        for (int k = j + 1; k <= 9 && k < s.length(); k++) {
                            String p3 = s.substring(j, k);
                            if (isLegal(p3)) {
                                String p4 = s.substring(k);
                                if (isLegal(p4)) {
                                    res.add(p1 + "." + p2 + "." + p3 + "." + p4);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean isLegal(String p) {
        if (p.startsWith("0")) {
            return "0".equals(p);
        } else {
            return Integer.valueOf(p) <= 255;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("010010"));
    }
}