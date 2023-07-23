package NO_0042_Trapping_Rain_Water;

class Solution {
    public int trap1(int[] height) {
        int water = 0;
        for (int i = 0; i < height.length - 1; ) {
            int r = i + 1;
            int max = height[i + 1];
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > height[i]) {
                    r = j;
                    break;
                }
                if (height[j] >= max) {
                    max = height[j];
                    r = j;
                }
            }
            water += trap1(height, i, r);
            i = r;
        }
        return water;
    }

    private int trap1(int[] height, int l, int r) {
        if (r - l <= 1) return 0;
        int min = Math.min(height[l], height[r]);
        int water = min * (r - l - 1);
        for (int i = l + 1; i < r; i++) {
            water -= height[i];
        }
        return water;
    }

    public int trap2(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        for (int i = 0, maxL = height[0], maxR = height[n - 1]; i < height.length; i++) {
            maxL = Math.max(maxL, height[i]);
            maxLeft[i] = maxL;
            maxR = Math.max(maxR, height[n - i - 1]);
            maxRight[n - i - 1] = maxR;
        }

        int water = 0;
        for (int i = 0; i < height.length; i++) {
            water += Math.min(maxRight[i], maxLeft[i]) - height[i];
        }
        return water;

    }

    public int trap3(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        maxLeft[0] = height[0];
        int[] maxRight = new int[n];
        maxRight[n - 1] = height[n - 1];

        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
            maxRight[n - i - 1] = Math.max(maxRight[n - i], height[n - i - 1]);
        }

        int water = 0;
        for (int i = 1; i < height.length - 1; i++) {
            water += Math.min(maxRight[i], maxLeft[i]) - height[i];
        }
        return water;
    }

    public int trap(int[] height) {
        int l = 0, lMax = 0;
        int r = height.length - 1, rMax = 0;
        int water = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                // 注意 lMax 是在 height[l] < height[r] 时才更新的
                // 此举保证了当前阶段 lMax 是小于 rMax 的
                lMax = Math.max(lMax, height[l]);
                water += lMax - height[l];
                l++;
            } else {
                // height[l] >= height[r]
                rMax = Math.max(rMax, height[r]);
                water += rMax - height[r];
                r--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {4, 2, 0, 3, 2, 5};
        int res = solution.trap(height);
        System.out.println("res = " + res);
    }
}