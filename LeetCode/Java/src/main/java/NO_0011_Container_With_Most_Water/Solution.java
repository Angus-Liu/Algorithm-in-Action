package NO_0011_Container_With_Most_Water;

class Solution {
    /**
     * 双指针法
     * 这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。
     * 此外，两线段距离越远，得到的面积就越大。我们在由线段长度构成的数组中使用两个
     * 指针，一个放在开始，一个置于末尾。此外，我们会使用变量 maxArea 来持续存储到
     * 目前为止所获得的最大面积。在每一步中，我们会找出指针所指向的两条线段形成的区
     * 域，更新 maxArea，并将指向较短线段的指针向较长线段那端移动一步。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int area;
        for (int lo = 0, hi = height.length - 1; lo < hi; ) {
            if (height[lo] < height[hi]) {
                area = height[lo] * (hi - lo);
                lo++;
            } else {
                area = height[hi] * (hi - lo);
                hi--;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int maxArea = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(maxArea);
    }
}