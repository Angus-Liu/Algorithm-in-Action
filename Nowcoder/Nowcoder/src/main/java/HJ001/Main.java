package HJ001;

import java.util.Scanner;

/**
 * HJ1 字符串最后一个单词的长度
 *
 * @Site <a href="https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da"/>
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            int idx = str.lastIndexOf(' ');
            System.out.println(str.length() - idx - 1);
        }
    }
}
