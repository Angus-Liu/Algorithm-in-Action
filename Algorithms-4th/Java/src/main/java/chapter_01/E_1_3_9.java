package chapter_01;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercises 1.3.9
 * 编写一段程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。
 * 例如，给定输入：1+2)*3-4)*5-6)))
 * 你的程序应该输出：((1+2)*((3-4)*(5-6)))
 */
public class E_1_3_9 {
    public static void main(String[] args) {
        // 1+2)*3-4)*5-6)))
        // ((1+2)*((3-4)*(5-6)))
        Stack<String> S = new Stack<>();
        StdOut.print("Please input expression(q to exit)：");
        while (!StdIn.isEmpty()) {
            char ch = StdIn.readChar();
            if (ch == ' ') continue;
            if (ch == 'q') break;
            if (ch == ')') {
                String num2 = S.pop();
                String operator = S.pop();
                String num1 = S.pop();
                S.push("( " + num1 + " " + operator + " " + num2 + " )");
            } else {
                S.push(Character.toString(ch));
            }
        }
        StdOut.println(S.pop());
    }
}
