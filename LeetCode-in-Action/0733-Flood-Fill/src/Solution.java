import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int[][] vector = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 递归实现
     */
    public int[][] floodFill_1(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        for (int i = 0; i < 4; i++) {
            int nr = sr + vector[i][0];
            int nc = sc + vector[i][1];
            if (nr >= 0 && nr < image.length
                    && nc >= 0 && nc < image[0].length
                    && image[nr][nc] == oldColor) {
                floodFill(image, nr, nc, newColor);
            }
        }
        return image;
    }

    /**
     * 迭代实现
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        int oldColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            image[s[0]][s[1]] = newColor;
            for (int i = 0; i < 4; i++) {
                int nr = s[0] + vector[i][0];
                int nc = s[1] + vector[i][1];
                if (nr >= 0 && nr < image.length
                        && nc >= 0 && nc < image[0].length
                        && image[nr][nc] == oldColor) {
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        image = new Solution().floodFill(image, 1, 1, 2);
        Arrays.stream(image).forEach(row -> {
            System.out.println(Arrays.toString(row));
        });
    }
}