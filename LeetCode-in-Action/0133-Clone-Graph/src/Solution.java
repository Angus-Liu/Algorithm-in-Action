import java.util.HashMap;
import java.util.Map;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 * int label;
 * List<UndirectedGraphNode> neighbors;
 * UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode newNode = map.get(node.label);
        // 深度遍历，克隆 node
        if (newNode == null) {
            newNode = new UndirectedGraphNode(node.label);
            // 先放入 map 中，避免自环引起栈溢出
            map.put(newNode.label, newNode);
            for (UndirectedGraphNode neighborNode : node.neighbors) {
                newNode.neighbors.add(cloneGraph(neighborNode));
            }
        }
        return newNode;
    }
}