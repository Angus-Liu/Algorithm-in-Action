package HJ014;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ14 字符串排序
 *
 * @Site <a href="https://www.nowcoder.com/practice/5af18ba2eb45443aa91a11e848aa6723"/>
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLine();
            }
            Arrays.sort(arr);
            for (String s : arr) {
                System.out.println(s);
            }
        }
    }
}
