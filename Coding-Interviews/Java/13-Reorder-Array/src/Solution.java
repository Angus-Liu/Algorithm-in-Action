import java.util.Arrays;

public class Solution {
    /**
     * 参考插入排序的思想，将所有奇数插入到数组前部
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                int oddNum = array[i];
                int j;
                for (j = i; j - 1 >= 0 && (array[j - 1] & 1) == 0; j--) {
                    array[j] = array[j - 1];
                }
                array[j] = oddNum;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        new Solution().reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

    /*
    public class InsertionSort {
        public void sort(Comparable[] arr) {
            for (int i = 0; i < arr.length; i++) {
                // 寻找元素 arr[i] 合适的插入位置
                Comparable e = arr[i];
                int j;
                // 插入排序在数据较为有序的情况下效率极高
                for (j = i; j > 0 && e.compareTo(arr[j - 1]) < 0; j--) {
                    // 这一步的作用在于，把比 e 大的数字依次后移一位
                    arr[j] = arr[j - 1];
                }
                // 将待排序元素插入合适位置
                arr[j] = e;
            }
        }
    }
     */
}