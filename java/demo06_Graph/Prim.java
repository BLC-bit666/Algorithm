package demo06_Graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-13  20:45
 * @Author: lanai
 * @Description: 普⾥姆 算法，求最小生成树
 */
public class Prim {
    public static Set<GraphEdge> primMST(Graph graph){
        if(graph==null){
            return null;
        }
        PriorityQueue<GraphEdge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        Set<GraphNode> setNode = new HashSet<>();
        Set<GraphEdge> setEdge = new HashSet<>();
        for (GraphNode node : graph.nodes.values()) { // 加 循环 的目的是为了防止 两片不连通的 图
            if (!setNode.contains(node)){
                setNode.add(node);
                queue.addAll(node.edges);
            }
            while(!queue.isEmpty()){ // 从一个点开始，逐步向外扩散，直到遍历所有的点（连通图）
                GraphEdge cur = queue.poll();
                GraphNode toNode = cur.to;
                if(!setNode.contains(toNode)){
                    setNode.add(toNode);
                    setEdge.add(cur);
                    queue.addAll(toNode.edges);
                }
            }
        }
        return setEdge;
    }
}
