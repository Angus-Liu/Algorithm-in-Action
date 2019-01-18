import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        // 利用二分法找到最接近 x 的数的左边界
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new Solution().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1);
        System.out.println(res);
    }
}