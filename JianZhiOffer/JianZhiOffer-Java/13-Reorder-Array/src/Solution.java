public class Solution {
    public void reOrderArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // 向右移动 left，直到 left 指向偶数
            while (left < right && (array[left] & 1) != 0) {
                left++;
            }
            // 向左移动 right，直到 right 指向奇数
            while (left < right && (array[right] & 1) == 0){
                right--;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
    }
}