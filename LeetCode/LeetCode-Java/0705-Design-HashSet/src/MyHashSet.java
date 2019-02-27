class MyHashSet {

    private boolean[] bucket;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        bucket = new boolean[1000000];
    }

    public void add(int key) {
        bucket[key] = true;
    }

    public void remove(int key) {
        bucket[key] = false;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return bucket[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */