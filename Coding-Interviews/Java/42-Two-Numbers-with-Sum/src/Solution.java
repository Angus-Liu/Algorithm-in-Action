import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        Integer num1 = -1, num2 = -1;
        int low = 0, high = array.length - 1;
        while (low < high) {
            int s = array[low] + array[high];
            if (s == sum) {
                if (array[low] * array[high] < num1 * num2 || num1 == -1 || num2 == -1) {
                    num1 = array[low];
                    num2 = array[high];
                }
                low++;
            } else if (s < sum) {
                low++;
            } else {
                high--;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        if (num1 != -1 && num2 != -1) {
            res.add(num1);
            res.add(num2);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 11, 15};
        ArrayList<Integer> res = new Solution().FindNumbersWithSum(array, 15);
        System.out.println("res = " + res);
    }
}