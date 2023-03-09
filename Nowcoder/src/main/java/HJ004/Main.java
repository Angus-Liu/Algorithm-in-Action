package HJ004;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ4 字符串分隔
 *
 * @Site <a href="https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7"/>
 */
public class Main {
    private static String appendZero(String str) {
        int inNum = str.length() % 8;
        if (inNum == 0) return str;
        char[] chars = new char[8 - inNum];
        Arrays.fill(chars, '0');
        return str + String.valueOf(chars);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = appendZero(in.nextLine());
            for (int i = 0; i < str.length(); i++) {
                if (i % 8 == 7) {
                    System.out.println(str.substring(i - 7, i + 1));
                }
            }
        }
    }
}
