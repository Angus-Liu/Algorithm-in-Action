import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        if (deadendSet.contains("0000")) return -1;
        if ("0000".equals(target)) return 0;
        Set<String> visitedSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visitedSet.add("0000");
        // 广度优先搜索
        for (int step = 1; !queue.isEmpty(); step++) {
            System.out.println(queue);
            for (int n = queue.size(); n > 0; n--) {
                String cur = queue.remove();
                List<String> nextLocks = getNextLock(cur);
                for (String nextLock : nextLocks) {
                    if (nextLock.equals(target)) {
                        return step;
                    }
                    if (!deadendSet.contains(nextLock) && !visitedSet.contains(nextLock)) {
                        queue.add(nextLock);
                        visitedSet.add(nextLock);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getNextLock(String curLock) {
        List<String> nextLocks = new ArrayList<>();
        char[] oriLockChars = curLock.toCharArray();
        char[] curLockChars = curLock.toCharArray();
        int[] difs = new int[]{-1, 1};
        for (int i = 0; i < 4; i++) {
            for (int dif : difs) {
                curLockChars[i] += dif;
                if (curLockChars[i] < '0') {
                    curLockChars[i] = '9';
                } else if (curLockChars[i] > '9') {
                    curLockChars[i] = '0';
                }
                nextLocks.add(String.valueOf(curLockChars));
                curLockChars[i] = oriLockChars[i];
            }
        }
        return nextLocks;
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        System.out.println(new Solution().openLock(deadends, "9999"));
    }
}