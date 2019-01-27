import java.util.LinkedList;

class Solution {
    public String decodeString(String s) {
        LinkedList<String> strStack = new LinkedList<>();
        LinkedList<Integer> countStack = new LinkedList<>();
        int i = 0;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (i < chars.length) {
            // 遇到数字，压入次数栈
            while (Character.isDigit(chars[i])) {
                sb.append(chars[i++]);
            }
            if (sb.length() != 0) {
                countStack.addLast(Integer.valueOf(sb.toString()));
                sb.delete(0, sb.length());
            }
            // 遇到字符串，压入字符串栈
            while (i < chars.length && Character.isLetter(chars[i])) {
                sb.append(chars[i++]);
            }
            if (sb.length() != 0) {
                strStack.addLast(sb.toString());
                sb.delete(0, sb.length());
            }
            // 遇到左括号压入字符串栈作为标志位
            if (i < chars.length && chars[i] == '[') {
                strStack.addLast("[");
                i++;
            }
            // 遇到右括号，从字符串栈中弹出左括号之前的所有字符串，从次数栈中弹出次数，得出结果后重新压入字符串栈
            if (i < chars.length && chars[i] == ']') {
                String str = "";
                while (!strStack.isEmpty()) {
                    if (!"[".equals(strStack.peekLast())) {
                        str = strStack.pollLast() + str;
                    } else {
                        // 移除作为标志位的左括号
                        strStack.pollLast();
                        break;
                    }
                }
                int count = countStack.removeLast();
                for (int j = 0; j < count; j++) {
                    sb.append(str);
                }
                strStack.addLast(sb.toString());
                sb.delete(0, sb.length());
                i++;
            }
        }
        while (!strStack.isEmpty()) {
            sb.append(strStack.removeFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Solution().decodeString("3[a2[c]]"));
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
        System.out.println(new Solution().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(new Solution().decodeString("3[a]2[b4[F]c]"));
    }
}