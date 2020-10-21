package NO_0744_Find_Smallest_Letter_Greater_Than_Target;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        if (letters[right] <= target) {
            return letters[0];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return letters[left];
    }
}