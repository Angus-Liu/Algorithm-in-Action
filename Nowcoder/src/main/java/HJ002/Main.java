package HJ002;

import java.util.Scanner;

/**
 * HJ2 计算某字符出现次数
 *
 * @Site <a href="https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1"/>
 */
public class Main {
    private static char lowerCase(char ch) {
        // A = 65, a = 97
        return ch < 'a' ? (char) (ch + 32) : ch;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            char ch = lowerCase(in.nextLine().charAt(0));
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (lowerCase(str.charAt(i)) == ch) count++;
            }
            System.out.println(count);
        }
    }
}
