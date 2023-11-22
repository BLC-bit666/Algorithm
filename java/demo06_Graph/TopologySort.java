package demo06_Graph;

import java.util.*;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-13  18:55
 * @Author: lanai
 * @Description: 拓扑排序（如依赖问题）
 */
public class TopologySort {
    public static List<GraphNode> topologySort(Graph graph){
        if(graph==null){
            return null;
        }
        Map<GraphNode,Integer> map = new HashMap<>();
        Queue<GraphNode> queue = new LinkedList<>();
        for (GraphNode node : graph.nodes.values()) {
            map.put(node,node.in);
            if(node.in==0){
                queue.add(node);
            }
        }
        List<GraphNode> res = new ArrayList<>();
        while(!queue.isEmpty()){
            GraphNode cur = queue.poll();
            res.add(cur);
            for (GraphNode node : cur.nodes) {
                map.put(node,map.get(node)-1);
                if(map.get(node)==0){
                    queue.add(node);
                }
            }
        }
        return res;
    }
}
