package NO_0150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        // 借助栈实现
        Stack<Integer> nums = new Stack<>();
        for (String s : tokens) {
            // 遇到运算符时，从栈中弹出两个数字进行运算，并将结果压回栈中
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                int a = nums.pop();
                int b = nums.pop();
                if ("+".equals(s)) {
                    nums.push(b + a);
                } else if ("-".equals(s)) {
                    nums.push(b - a);
                } else if ("*".equals(s)) {
                    nums.push(b * a);
                } else if ("/".equals(s)) {
                    nums.push(b / a);
                }
            } else {
                nums.push(Integer.parseInt(s));
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}