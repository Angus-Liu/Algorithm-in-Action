package NO_1129_Shortest_Path_with_Alternating_Colors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    private final int RED = 0, BLUE = 1;
    // red visited: [0][i]; blue visited: [1][i]
    private boolean[][] visited;
    // [0] - edge end as next; [1] - edge color
    private final Queue<int[]> queue = new LinkedList<>();
    // key: cur node, value: all nodes connected to the current node
    private Map<Integer, List<Integer>>[] edgeMaps;
    private final Function<int[][], Map<Integer, List<Integer>>> toMap =
            edges -> Arrays.stream(edges).collect(Collectors.groupingBy(
                    edge -> edge[0], Collectors.mapping(edge -> edge[1], Collectors.toList())
            ));

    private void visitNext(int curIdx, int nextColor) {
        edgeMaps[nextColor]
                .getOrDefault(curIdx, Collections.emptyList())
                .stream()
                .filter(next -> !visited[nextColor][next])
                .forEach(next -> {
                            queue.add(new int[]{next, nextColor});
                            visited[nextColor][next] = true;
                        }
                );
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        edgeMaps = new Map[]{toMap.apply(redEdges), toMap.apply(blueEdges)};
        int[] shortestPath = new int[n];
        Arrays.fill(shortestPath, -1);
        shortestPath[0] = 0;

        visited = new boolean[2][n];
        visited[RED][0] = visited[BLUE][0] = true;
        visitNext(0, RED);
        visitNext(0, BLUE);

        for (int path = 1; !queue.isEmpty(); path++) {
            for (int i = queue.size(); i > 0; i--) {
                int[] edge = queue.remove();
                int cur = edge[0], curColor = edge[1];
                visitNext(cur, curColor == RED ? BLUE : RED);
                if (shortestPath[cur] == -1) shortestPath[cur] = path;
            }
        }
        return shortestPath;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
        int[][] redEdges = {{0, 1}};
        int[][] blueEdges = {{1, 2}};
        int[] shortestPaths = solution.shortestAlternatingPaths(3, redEdges, blueEdges);
        System.out.println("shortestPaths = " + Arrays.toString(shortestPaths));
    }
}
