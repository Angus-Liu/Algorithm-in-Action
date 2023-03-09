package HJ106;

import java.util.Scanner;

/**
 * HJ106 字符逆序
 *
 * @Site <a href="https://www.nowcoder.com/practice/cc57022cb4194697ac30bcb566aeb47b"/>
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            char[] chars = str.toCharArray();
            for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
            System.out.println(new String(chars));
        }
    }
}
