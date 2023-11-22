package demo06_Graph;


import java.util.*;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-13  21:12
 * @Author: lanai
 * @Description: 迪杰斯特拉算法，用于最短路径算法，计算一个节点到其他节点的最短路径。
 */
public class Dijkstra {

    /**
     * 计算一个节点到其他节点的最短路径
     *
     * @param node
     * @return
     */
    public static HashMap<GraphNode, Integer> dijkstraMST(GraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<GraphNode, Integer> map = new HashMap<>();
        HashSet<GraphNode> set = new HashSet<>();
        map.put(node, 0);
        GraphNode minNode = getMinDistanceAndUnselectedNode(map, set);
        while (minNode != null) {
            Integer distance = map.get(minNode);
            for (GraphEdge edge : minNode.edges) {
                GraphNode toNode = edge.to;
                if (!set.contains(toNode)) {
                    map.put(toNode, distance + edge.weight);
                } else {
                    map.put(toNode, Math.min(map.get(toNode), distance + edge.weight));
                }
            }
            set.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(map, set);
        }
        List<Integer> list = new ArrayList<>();
        list.sort((o1, o2) -> o2-o1);
        return map;
    }

    /**
     * 找到距离起点（最初给定的一个点）最近且未被选择的点
     *
     * @param distanceMap
     * @param touchedNodes
     * @return
     */
    public static GraphNode getMinDistanceAndUnselectedNode(HashMap<GraphNode, Integer> distanceMap, HashSet<GraphNode> touchedNodes) {
        GraphNode minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<GraphNode, Integer> entry : distanceMap.entrySet()) {
            GraphNode node = entry.getKey();
            Integer distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minDistance = distance;
                minNode = node;
            }
        }
        return minNode;

    }
}
