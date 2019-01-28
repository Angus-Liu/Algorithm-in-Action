public class Solution {
    public boolean Find(int target, int[][] array) {
        int row = 0, col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (target > array[row][col]) {
                row++;
            } else if (target < array[row][col]) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(new Solution().Find(5, array));
    }
}