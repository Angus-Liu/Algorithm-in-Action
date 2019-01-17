import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * 分为 x 在 arr 中和不在 arr 中进行讨论
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>(k);
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
        } else if (x >= arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length; i++) {
                res.add(arr[i]);
            }
        } else {
            int l = 0, r = arr.length - 1, m = 0;
            while (l <= r) {
                m = l + (r - l) / 2;
                if (arr[m] == x) {
                    break;
                } else if (arr[m] < x) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

        }


        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new Solution().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        System.out.println(res);
    }
}