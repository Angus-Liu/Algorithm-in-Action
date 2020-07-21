/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (guess(mid) == 0) {
                res = mid;
                break;
            } else if (guess(mid) == 1) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return res;
    }
}