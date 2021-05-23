package NO_0455_Assign_Cookies;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 贪心算法
        Arrays.sort(g);
        Arrays.sort(s);

        // gi 用来表示当前分配孩子贪心指数的索引，初始时指向最贪心的孩子
        int gi = g.length - 1;
        // si 用来表示当前分配饼干尺寸大小的索引，初始时指向最大的饼干
        int si = s.length - 1;
        int res = 0;
        while (gi >= 0 && si >= 0) {
            if (s[si] >= g[gi]) {
                // 将当前饼干分给当前孩子
                res++;
                gi--;
                si--;
            } else {
                // 查看是否满足次贪心的孩子
                gi--;
            }
        }
        return res;
    }
}