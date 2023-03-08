package NO_0752_Open_the_Lock;

import java.util.*;

class Solution {
    /**
     * BFS
     */
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));

        String start = "0000";
        if (deadendSet.contains(start)) return -1;
        if (start.equals(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(start);

        // 广度优先搜索
        for (int step = 1; !queue.isEmpty(); step++) {
            for (int n = queue.size(); n > 0; n--) {
                String cur = queue.remove();
                List<String> nextLocks = getNextLock(cur);
                for (String nextLock : nextLocks) {
                    if (nextLock.equals(target)) return step;
                    if (!deadendSet.contains(nextLock) && !visitedSet.contains(nextLock)) {
                        queue.add(nextLock);
                        visitedSet.add(nextLock);
                    }
                }
            }
        }
        return -1;
    }

    //    0900  0100  0009
    //        \  |  /
    // 1000 —— 0000 —— 0001
    //       /  |   \
    // 9000   0010   0090
    private List<String> getNextLock(String curLock) {
        List<String> nextLocks = new ArrayList<>();
        char[] curLockChars = curLock.toCharArray();
        for (int i = 0; i < 4; i++) {
            char tmp = curLockChars[i];
            // +1
            curLockChars[i] = (char) ((tmp - '0' + 1) % 10 + '0');
            nextLocks.add(new String(curLockChars));
            // -1: (tmp - '0' - 1 + 10) % 10
            curLockChars[i] = (char) ((tmp - '0' + 9) % 10 + '0');
            nextLocks.add(new String(curLockChars));
            curLockChars[i] = tmp;
        }
        return nextLocks;
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        System.out.println(new Solution().openLock(deadends, "9999"));
    }
}