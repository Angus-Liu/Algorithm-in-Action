import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k == 0 || k > input.length) {
            return new ArrayList<>();
        }
        // 先使用最大堆保存 k 个数，此后，每次和堆顶比较，若比堆顶小，移除堆顶，新数入堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.add(input[i]);
            } else if (input[i] <= maxHeap.peek()) {
                maxHeap.remove();
                maxHeap.add(input[i]);
            }
        }
        return new ArrayList<>(maxHeap);
    }
}