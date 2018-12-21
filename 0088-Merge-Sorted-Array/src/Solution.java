import java.util.Arrays;

class Solution {
    public void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_back = new int[m];
        for (int i = 0; i < m; i++) {
            nums1_back[i] = nums1[i];
        }
        for (int i = 0, n1 = 0, n2 = 0; i < m + n; i++) {
            if (n1 < m && n2 < n) {
                if (nums1_back[n1] <= nums2[n2]) {
                    nums1[i] = nums1_back[n1];
                    n1++;
                } else {
                    nums1[i] = nums2[n2];
                    n2++;
                }
            } else if (n1 < m) {
                nums1[i] = nums1_back[n1];
                n1++;
            } else if (n2 < n) {
                nums1[i] = nums2[n2];
                n2++;
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }
        for (int i = 0, j = n, k = 0; i < m + n; i++) {
            if (j < m + n && k < n) {
                if (nums1[j] <= nums2[k]) {
                    nums1[i] = nums1[j++];
                } else {
                    nums1[i] = nums2[k++];
                }
            } else if (j < m + n) {
                nums1[i] = nums1[j++];
            } else if (k < n) {
                nums1[i] = nums2[k++];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}