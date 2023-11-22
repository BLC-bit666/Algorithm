package demo06_Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-13  11:24
 * @Author: lanai
 * @Description: 宽度优先遍历图
 */
public class BFS {
    public static void bfs(GraphNode graphNode) {
        if (graphNode == null) {
            return;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> set = new HashSet<>();
        queue.add(graphNode);
        set.add(graphNode);
        while(!queue.isEmpty()){
            GraphNode cur = queue.poll();
            System.out.println(cur.value);
            for (GraphNode node : cur.nodes) {
                if(!set.contains(node)){
                    queue.add(node);
                    set.add(node);
                }
            }
        }
    }
}
