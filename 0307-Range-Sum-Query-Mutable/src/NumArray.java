/**
 * @author Angus
 * @date 2018/10/20
 */
class NumArray {

    /**
     * 给定数据的数组
     */
    private int[] nums;

    /**
     * 线段树对应的数组
     */
    private int[] tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[4 * nums.length];
        buildSegmentTree(0, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        update(0, 0, nums.length - 1, i, val);
    }

    public int sumRange(int i, int j) {
        if (nums.length == 0) {
            return 0;
        }
        return sumRange(0, 0, nums.length - 1, i, j);
    }

    /**
     * 构建线段树
     *
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l > r) {
            return;
        }
        // 递归退出条件
        if (l == r) {
            tree[treeIndex] = nums[l];
            return;
        }
        // 计算出左右孩子所在的索引
        int leftTreeIndex = 2 * treeIndex + 1;
        int rightTreeIndex = 2 * treeIndex + 2;
        // 直接写为 (l + r) / 2 ，l + r 的值可能会发生溢出
        int mid = l + (r - l) / 2;
        // 递归创建左子树根节点对应的线段树
        buildSegmentTree(leftTreeIndex, l, mid);
        // 递归创建右子树根节点对应的线段树（注意此时的 l 为 mid + 1）
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        // 综合左右子树获得根节点的值（与业务相关）
        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }

    private void update(int treeIndex, int l, int r, int index, int val) {
        if (l == r) {
            tree[treeIndex] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = 2 * treeIndex + 1;
        int rightTreeIndex = 2 * treeIndex + 2;
        if (index <= mid) {
            // 待更新节点在左子树中
            update(leftTreeIndex, l, mid, index, val);
        } else {
            // 待更新节点在右子树中
            update(rightTreeIndex, mid + 1, r, index, val);
        }
        // 更新该节点的值
        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }

    /**
     * 线段树的查询求和
     *
     * @param treeIndex
     * @param l
     * @param r
     * @return
     */
    private int sumRange(int treeIndex, int l, int r, int queryL, int queryR) {
        // 退出条件为搜索范围即为该线段树范围
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        // 根据 [queryL, queryR] 区间范围开始递归
        int mid = l + (r - l) / 2;
        int leftIndex = 2 * treeIndex + 1;
        int rightIndex = 2 * treeIndex + 2;
        if (queryL >= mid + 1) {
            // 搜索范围在改线段树的右子树中
            return sumRange(rightIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            // 搜索范围在改线段树的左子树中
            return sumRange(leftIndex, l, mid, queryL, queryR);
        }
        // 搜索范围同时在该线段树的左右子树中
        int leftResult = sumRange(leftIndex, l, mid, queryL, mid);
        int rightResult = sumRange(rightIndex, mid + 1, r, mid + 1, queryR);
        return leftResult + rightResult;
    }

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{1, 3, 5});
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */