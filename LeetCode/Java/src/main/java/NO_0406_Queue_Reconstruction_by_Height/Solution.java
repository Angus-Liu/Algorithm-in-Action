package NO_0406_Queue_Reconstruction_by_Height;

import java.util.Arrays;

/**
 * 根据身高重建队列
 */
class Solution {

    /**
     * 假设输入为：
     * [7,0], [4,4], [7,1], [5,0], [6,1], [5,2]
     * 先按照身高升序，排位信息逆序排序，得到待重建队列：
     * [4,4], [5,2], [5,0], [6,1], [7,1], [7,0]
     * 下面进行队列重建，每次取待重建队列第一个，即剩下人员中最矮的那个人获取位置加入重建队列：
     * 重建队列剩余空位          当前人员属性   最终确定队列位置
     * [ 0, 1, 2, 3, 4, 5 ]     [ 4, 4 ]            4
     * 我的身高是 4，我前面要有 4 个人比我高，所以我应该排在第 5 个空位 4 号处；
     * [ 0, 1, 2, 3, 5 ]        [ 5, 2 ]            2
     * 我的身高是 5，我前面要有 2 个人比我高，所以我应该排在第 3 个空位 2 号处；
     * [ 0, 1, 3, 5 ]           [ 5, 0 ]            0
     * 我的身高是 5，我前面要有 0 个人比我高，所以我应该排在第 1 个空位 0 号处；
     * [ 1, 3, 5 ]              [ 6, 1 ]            3
     * 我的身高是 6，我前面要有 1 个人比我高，所以我应该排在第 2 个空位 3 号处；
     * [ 1, 5 ]                 [ 7, 1 ]            5
     * 我的身高是 7，我前面要有 1 个人比我高，所以我应该排在第 2 个空位 5 号处；
     * [ 1 ]                    [ 7, 0 ]            1
     * 我的身高是 7，我前面要有 0 个人比我高，所以我应该排在第 1 个空位 1 号处；
     */
    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][];
        // 按身高排序，身高相同时，按排位逆序
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        for (int[] p : people) {
            // 先确定较矮的人所在的所在位置
            for (int i = 0, j = p[1]; i < res.length; i++) {
                if (res[i] != null || j-- > 0) continue;
                res[i] = p;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = s.reconstructQueue(people);
        System.out.println(Arrays.deepToString(res));
    }
}
