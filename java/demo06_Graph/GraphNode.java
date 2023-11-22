package demo06_Graph;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-13  10:59
 * @Author: lanai
 * @Description: TODO
 */
public class GraphNode {
    public int value;
    public int in;
    public int out;
    public ArrayList<GraphNode> nodes;
    public ArrayList<GraphEdge> edges;

    // region 重写 equals 与 hashCode 方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return value == graphNode.value && in == graphNode.in && out == graphNode.out && Objects.equals(nodes, graphNode.nodes) && Objects.equals(edges, graphNode.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, in, out, nodes, edges);
    }

    public GraphNode(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
    // endregion
}
