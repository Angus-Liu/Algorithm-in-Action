package HJ020;

import java.util.Scanner;

/**
 * HJ20 密码验证合格程序
 *
 * @Site <a href="https://www.nowcoder.com/practice/184edec193864f0985ad2684fbc86841"/>
 */
public class Main {
    private static boolean lackComplexity(String pwd) {
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        for (int i = 0; i < pwd.length(); i++) {
            char c = pwd.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c1 = 1;
            } else if (c >= 'A' && c <= 'Z') {
                c2 = 1;
            } else if (c >= '0' && c <= '9') {
                c3 = 1;
            } else {
                c4 = 1;
            }
        }
        return c1 + c2 + c3 + c4 < 3;
    }

    private static boolean hasRepeatSubStr(String pwd) {
        for (int i = 0; i <= pwd.length() - 6; i++) {
            int lastIdx = pwd.lastIndexOf(pwd.substring(i, i + 3));
            if (lastIdx != i) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String pwd = in.nextLine();
            if (pwd.length() <= 8 || lackComplexity(pwd) || hasRepeatSubStr(pwd)) {
                System.out.println("NG");
            } else {
                System.out.println("OK");
            }
        }
    }
}
