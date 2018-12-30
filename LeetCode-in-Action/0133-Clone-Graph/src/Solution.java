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
        if (newNode != null) {
            return newNode;
        }
        newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode);
        for (UndirectedGraphNode tempNode : node.neighbors) {
            newNode.neighbors.add(cloneGraph(tempNode));
        }
        return newNode;
    }
}