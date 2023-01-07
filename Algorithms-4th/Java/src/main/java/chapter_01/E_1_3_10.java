package chapter_01;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercises 1.3.10
 */
public class E_1_3_10 {
    /**
     * // TODO: angus on 2021/6/13 待优化
     */
    public static void main(String[] args) {
        Stack<String> vars = new Stack<>();
        Stack<String> ops = new Stack<>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals("q")) break;
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                ops.push(str);
            } else if (str.equals(")")) {
                String s1 = vars.pop();
                String s2 = vars.pop();
                String op = ops.pop();
                vars.push("(" + s2 + " " + s1 + " " + op + ")");
            } else {
                vars.push(str);
            }
        }
        StdOut.println(vars.pop());
    }
}
