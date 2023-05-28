package JZ_Offer_II_059;

import java.util.PriorityQueue;

class KthLargest {

    private final PriorityQueue<Integer> pq;
    private final int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.remove();
        }
        assert !pq.isEmpty();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */