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

    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
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
            } else if (k < n) {
                nums1[i] = nums2[k++];
            } else {
                break;
            }
        }
    }

    /**
     * 更好的解法，不需要先拷贝数组
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1, index1 = m - 1, index2 = n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[index--] = nums1[index1--];
            } else {
                nums1[index--] = nums2[index2--];
            }
        }
        while (index2 >= 0) {
            nums1[index--] = nums2[index2--];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {0};
        int[] nums2 = {1};
        solution.merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}