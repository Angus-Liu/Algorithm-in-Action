package NO_0933_Number_of_Recent_Calls;

import java.util.LinkedList;

class RecentCounter {
    private LinkedList<Integer> deque;

    public RecentCounter() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        deque.addLast(t);
        // 移除双端队列头部不符合的 ping
        while (!deque.isEmpty() && deque.getFirst() < (t - 3000)) {
            deque.removeFirst();
        }

        return deque.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */