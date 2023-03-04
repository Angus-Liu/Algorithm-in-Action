package NO_0895_Maximum_Frequency_Stack;

import java.util.*;

class FreqStack {

    // key = val, value = freq
    private final Map<Integer, Integer> freq;

    // key = freq, value = val group
    private final TreeMap<Integer, List<Integer>> freqGroup;

    public FreqStack() {
        freq = new HashMap<>();
        freqGroup = new TreeMap<>(Comparator.reverseOrder());
    }

    public void push(int val) {
        int f = freq.merge(val, 1, Integer::sum);
        freqGroup.computeIfAbsent(f, key -> new ArrayList<>()).add(val);
    }

    public int pop() {
        Map.Entry<Integer, List<Integer>> maxFreq = freqGroup.firstEntry();
        List<Integer> maxFreqGroup = maxFreq.getValue();
        int val = maxFreqGroup.remove(maxFreqGroup.size() - 1);
        freq.merge(val, -1, Integer::sum);
        if (maxFreqGroup.isEmpty()) freqGroup.remove(maxFreq.getKey());
        return val;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);//堆栈为 [5]
        freqStack.push(7);//堆栈是 [5,7]
        freqStack.push(5);//堆栈是 [5,7,5]
        freqStack.push(7);//堆栈是 [5,7,5,7]
        freqStack.push(4);//堆栈是 [5,7,5,7,4]
        freqStack.push(5);//堆栈是 [5,7,5,7,4,5]
        int res = freqStack.pop();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
        System.out.println(res);
        res = freqStack.pop();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
        System.out.println(res);
        res = freqStack.pop();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
        System.out.println(res);
        res = freqStack.pop();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。
        System.out.println(res);

    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
