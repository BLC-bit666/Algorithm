package demo06_Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-13  10:59
 * @Author: lanai
 * @Description: TODO
 */
public class Graph {
    public Map<Integer,GraphNode> nodes;
    public Set<GraphEdge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
