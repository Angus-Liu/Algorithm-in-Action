package NO_0752_Open_the_Lock;

import java.util.*;

class Solution2 {
    /**
     * 双向BFS
     */
    public int openLock(String[] deadends, String target) {
        // 将deadends转换成Set，加快判断元素是否存在的速度
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));

        String start = "0000";
        if (deadendSet.contains(start)) return -1;
        if (start.equals(target)) return 0;

        // 定义起点和终点的Set
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        // 定义访问过的状态的Set
        Set<String> visitedSet = new HashSet<>();
        beginSet.add(start);
        endSet.add(target);
        visitedSet.add(start);
        visitedSet.add(target);

        int step = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 从集合大小较小的一端进行扩展，能够减少搜索的深度和宽度，提高搜索效率
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> nextSet = new HashSet<>();
            for (String cur : beginSet) {
                List<String> nextLocks = getNextLock(cur);
                for (String nextLock : nextLocks) {
                    // 如果endSet中已经存在nextLock，说明双向BFS已经相遇，返回步数
                    if (endSet.contains(nextLock)) return step + 1;
                    if (!deadendSet.contains(nextLock) && !visitedSet.contains(nextLock)) {
                        nextSet.add(nextLock);
                        visitedSet.add(nextLock);
                    }
                }
            }
            beginSet = nextSet;
            step++;
        }
        return -1;
    }

    /**
     * 获取当前锁下一步能够到达的所有状态
     */
    private List<String> getNextLock(String curLock) {
        List<String> nextLocks = new ArrayList<>();
        char[] curLockChars = curLock.toCharArray();
        for (int i = 0; i < 4; i++) {
            char tmp = curLockChars[i];
            // 向上转动一格
            curLockChars[i] = (char) ((tmp - '0' + 1) % 10 + '0');
            nextLocks.add(new String(curLockChars));
            // 向下转动一格
            curLockChars[i] = (char) ((tmp - '0' + 9) % 10 + '0');
            nextLocks.add(new String(curLockChars));
            // 恢复字符数组中的原始字符，方便下一次循环使用
            curLockChars[i] = tmp;
        }
        return nextLocks;
    }
}

