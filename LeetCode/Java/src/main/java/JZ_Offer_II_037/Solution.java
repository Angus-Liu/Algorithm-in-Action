package JZ_Offer_II_037;

import java.util.Arrays;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int topIdx = -1;
        for (int asteroid : asteroids) {
            while (true) {
                if (topIdx == -1 || asteroid > 0) {
                    asteroids[++topIdx] = asteroid;
                    break;
                }
                int topAsteroid = asteroids[topIdx];
                if (topAsteroid < 0) {
                    asteroids[++topIdx] = asteroid;
                    break;
                }
                if (topAsteroid == -asteroid) {
                    topIdx--;
                    break;
                } else if (topAsteroid < -asteroid) {
                    topIdx--;
                } else {
                    break;
                }
            }
        }
        return Arrays.copyOf(asteroids, topIdx + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] asteroids = new int[]{5, 10, -5, 8, -8, 10, 2, -5};
        int[] res = solution.asteroidCollision(asteroids);
        System.out.println("res = " + Arrays.toString(res));
    }
}
