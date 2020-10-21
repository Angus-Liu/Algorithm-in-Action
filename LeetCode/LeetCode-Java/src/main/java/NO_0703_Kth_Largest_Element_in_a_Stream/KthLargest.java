package NO_0703_Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;

class KthLargest {

    /**
     * 优先级队列由小顶堆实现
     */
    private PriorityQueue<Integer> heap;
    private int size;

    /**
     * 借助小顶堆实现
     */
    public KthLargest(int k, int[] nums) {
        size = k;
        heap = new PriorityQueue<>(k);
        for (int val : nums) {
            add(val);
        }
    }

    public int add(int val) {
        if (heap.size() < size) {
            heap.offer(val);
        } else {
            if (val > heap.peek()) {
                heap.poll();
                heap.offer(val);
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
