import java.util.*;

class Solution {
    /**
     * BFS
     */
    public boolean canVisitAllRooms_1(List<List<Integer>> rooms) {
        Set<Integer> res = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        res.add(0);
        queue.add(0);
        while (!queue.isEmpty()) {
            for (Integer room : rooms.get(queue.poll())) {
                if (!res.contains(room)) {
                    queue.add(room);
                    res.add(room);
                }
            }
        }
        return res.size() == rooms.size();
    }

    public boolean canVisitAllRooms_2(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        int res = 1;
        while (!queue.isEmpty()) {
            for (Integer room : rooms.get(queue.poll())) {
                if (!visited[room]) {
                    queue.add(room);
                    visited[room] = true;
                    res++;
                }
            }
        }
        return res == rooms.size();
    }


    /**
     * DFS
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return dfs(rooms, 0, new HashSet<>()) == rooms.size();
    }

    private int dfs(List<List<Integer>> rooms, int room, Set<Integer> res) {
        res.add(room);
        rooms.get(room)
                .stream()
                .filter(r -> !res.contains(r))
                .forEach(r -> dfs(rooms, r, res));
        return res.size();
    }
}