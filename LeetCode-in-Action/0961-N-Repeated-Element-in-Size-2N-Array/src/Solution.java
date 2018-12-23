import java.util.NoSuchElementException;

class Solution {
    public int repeatedNTimes(int[] A) {
        int[] countArr = new int[10000];
        for (int i : A) {
            countArr[i]++;
        }
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] == A.length / 2) {
                return i;
            }
        }
        throw new NoSuchElementException("no result");
    }
}