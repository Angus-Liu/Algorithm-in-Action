package JZ_Offer_II_036;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String token : tokens) {
            if (isOpt(token)) {
                Integer b = nums.pop();
                Integer a = nums.pop();
                nums.push(calc(a, token, b));
            } else {
                nums.push(Integer.valueOf(token));
            }
        }
        return nums.pop();
    }

    private boolean isOpt(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private Integer calc(Integer a, String op, Integer b) {
        // System.out.println(a + " " + op + " " + b);
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        Solution solution = new Solution();
        int res = solution.evalRPN(tokens);
        System.out.println("res = " + res);
    }
}
