package HJ101;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ101 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 *
 * @Site <a href="https://www.nowcoder.com/practice/dd0c6b26c9e541f5b935047ff4156309"/>
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int order = in.nextInt();
            Arrays.sort(arr, (a, b) -> order == 0 ? a.compareTo(b) : b.compareTo(a));
            for (Integer num : arr) {
                System.out.print(num + " ");
            }
        }
    }
}
