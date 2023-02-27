package NO_0028_Find_the_Index_of_the_First_Occurrence_in_a_String;

class Solution {
    public int strStr(String haystack, String needle) {
        // 虽然用库函数很简单，不过应该看看 KMP
        // 参考：https://www.zhihu.com/question/21923021/answer/281346746
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello", "ello"));
    }
}