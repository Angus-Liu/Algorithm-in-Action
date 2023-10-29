package JZ_Offer_II_039

import java.util.*

class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = Stack<Int>();
        stack.push(-1);
        var maxArea = 0;
        for ((i, value) in heights.withIndex()) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                val height = heights[stack.pop()];
                val width = i - stack.peek() - 1;
                maxArea = maxArea.coerceAtLeast(height * width);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            val height = heights[stack.pop()];
            val width = heights.size - stack.peek() - 1;
            maxArea = maxArea.coerceAtLeast(height * width);
        }
        return maxArea;
    }
}