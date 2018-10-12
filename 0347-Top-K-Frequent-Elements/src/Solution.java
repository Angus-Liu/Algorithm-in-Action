import java.util.*;

class Solution {

    private class Freq implements Comparable<Freq> {
        /**
         * 数值及其频次
         */
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            // 优先级队列对首（最小堆堆首）为频次最低的元素
            return this.freq - o.freq;
        }
    }

    public List<Integer> topKFrequent1(int[] nums, int k) {
        // 先用映射记录各个数值及其对应的频次
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            Integer count = map.get(num);
            if (count != null) {
                map.put(num, ++count);
            } else {
                map.put(num, 1);
            }
        }
        // 使用优先级队列实现
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            // 优先级队列中值保留频次最大的前 k 个数值
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            }
            // 频次是否大于优先级队列中队首元素的频次
            else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().e);
        }
        // 虽已 AC，但是结果还不是很完美，与标准答案顺序相反
        return res;
    }

    /**
     * 上一种方法的简化版（省去了 Freq 类）
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 先用映射记录各个数值及其对应的频次
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            Integer count = map.get(num);
            if (count != null) {
                map.put(num, ++count);
            } else {
                map.put(num, 1);
            }
        }
        // 使用优先级队列实现
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // 比较 a 和 b 出现的频次
                return map.get(a) - map.get(b);
            }
        });
        for (int key : map.keySet()) {
            // 优先级队列中值保留频次最大的前 k 个数值
            if (pq.size() < k) {
                pq.add(key);
            }
            // 频次是否大于优先级队列中队首元素的频次
            else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        // 虽已 AC，但是结果还不是很完美，与标准答案顺序相反
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(list);
    }
}