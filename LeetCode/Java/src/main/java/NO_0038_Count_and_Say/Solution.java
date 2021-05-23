package NO_0038_Count_and_Say;

class Solution {
    public String countAndSay(int n) {
        String res = "1";
        StringBuilder next = new StringBuilder();
        for (int i = 1; i < n; i++) {
            next.delete(0, next.length());
            int count = 0;
            for (int j = 0, k = 0; k <= res.length(); ) {
                if (k == res.length()) {
                    next.append(count).append(res.charAt(j));
                    break;
                } else if (res.charAt(k) == res.charAt(j)) {
                    count++;
                    k++;
                } else {
                    next.append(count).append(res.charAt(j));
                    j = k;
                    count = 0;
                }
            }
            res = next.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 30; i++) {
            System.out.println(solution.countAndSay(i));
        }
    }
}