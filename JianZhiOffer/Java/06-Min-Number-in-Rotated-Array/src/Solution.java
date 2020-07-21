public class Solution {
    public int minNumberInRotateArray(int[] array) {
        return binarySearch(array, 0, array.length - 1);
    }

    private int binarySearch(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (array[mid] >= array[left] && array[mid] <= array[right]) {
            return array[left];
        } else if (array[mid] < array[left]) {
            return binarySearch(array, left, mid);
        } else {
            // array[mid] > array[right]
            return binarySearch(array, mid + 1, right);
        }
    }
}