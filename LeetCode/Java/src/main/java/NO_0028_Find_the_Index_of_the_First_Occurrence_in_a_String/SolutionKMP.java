package NO_0028_Find_the_Index_of_the_First_Occurrence_in_a_String;

class SolutionKMP {
    public int strStr(String haystack, String needle) {
        char[] src = haystack.toCharArray();
        char[] pat = needle.toCharArray();
        // 构造 next 表
        int[] next = buildNext(pat);
        int n = src.length, m = pat.length;
        // 主串指针，模式串指针
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (j < 0 || src[i] == pat[j]) {
                // 匹配时比较下一个字符
                i++;
                j++;
            } else {
                // 失配时，模式串回退
                j = next[j];
            }
        }
        return j == m ? i - j : -1;
    }

    /**
     * 根据模式串构建 next 数组
     */
    private int[] buildNext(char[] pat) {
        int m = pat.length;
        int[] next = new int[m]; // next[] 表
        next[0] = -1;
        // 主串指针，模式串指针
        int i = 0, j = -1;
        while (i < m - 1) {
            if (j < 0 || pat[i] == pat[j]) { // 匹配
                next[++i] = ++j;
            } else { // 失配
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionKMP().strStr("leetcode", "leeto"));
    }
}