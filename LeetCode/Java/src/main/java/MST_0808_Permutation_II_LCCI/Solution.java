package MST_0808_Permutation_II_LCCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] permutation(String S) {
        int n = S.length();
        // cnt 统计相同字符出现的次数，同时起到分组去重作用
        int[] cnt = new int[52];
        for (int i = 0; i < n; i++) {
            char ch = S.charAt(i);
            if (ch >= 'a') {
                cnt[ch - 'a']++;
            } else {
                cnt[ch - 'A' + 26]++;
            }
        }
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), cnt, n);
        return res.toArray(new String[0]);
    }

    private void dfs(List<String> res, StringBuilder sb, int[] cnt, int n) {
        if (n == 0) {
            res.add(sb.toString());
        } else {
            for (int i = 0; i < 52; i++) {
                if (cnt[i] > 0) {
                    // 递归
                    cnt[i]--;
                    char ch = i < 26 ? (char) (i + 'a') : (char) (i - 26 + 'A');
                    sb.append(ch);
                    dfs(res, sb, cnt, n - 1);
                    // 回溯
                    sb.deleteCharAt(sb.length() - 1);
                    cnt[i]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] res = solution.permutation("aaa");
        System.out.printf("size = %d\nres = %s\n", res.length, Arrays.toString(res));
    }
}
