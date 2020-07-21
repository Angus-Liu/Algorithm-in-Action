import java.util.LinkedList;

public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        // 借助一个辅助栈，把输入的第一个序列中的数字依次压入该辅助栈
        // 并按照第二个序列的顺序依次从该栈中弹出数字
        LinkedList<Integer> stack = new LinkedList<>();
        int pushIndex = 0, popIndex = 0;
        stack.push(pushA[pushIndex++]);
        while (popIndex < popA.length) {
            // 若栈顶不是待弹出数字，说明还需要从压入序列中压入数字
            while (stack.peek() != popA[popIndex]) {
                if (pushIndex < pushA.length) {
                    stack.push(pushA[pushIndex++]);
                } else {
                    return false;
                }
            }
            stack.pop();
            popIndex++;
        }
        return true;
    }
}