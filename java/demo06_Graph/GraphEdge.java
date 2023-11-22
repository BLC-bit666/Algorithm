package demo06_Graph;

import java.util.Objects;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-13  11:04
 * @Author: lanai
 * @Description: TODO
 */
public class GraphEdge {
    public int  weight;
    public GraphNode from;
    public GraphNode to;

    public GraphEdge(int weight, GraphNode from, GraphNode to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    // region 重写 equals 与 hashCode 方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphEdge graphEdge = (GraphEdge) o;
        return weight == graphEdge.weight && Objects.equals(from, graphEdge.from) && Objects.equals(to, graphEdge.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, from, to);
    }
    // endregion
}
