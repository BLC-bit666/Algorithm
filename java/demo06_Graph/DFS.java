package demo06_Graph;

import java.util.*;


/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-13  11:43
 * @Author: lanai
 * @Description: 深度优先遍历
 */
public class DFS {
    private static void dfs(GraphNode graphNode){
        if(graphNode==null){
            return;
        }
        Stack<GraphNode> stack = new Stack<>();
        Set<GraphNode> set = new HashSet<>();
        stack.add(graphNode);
        set.add(graphNode);
        System.out.println(graphNode.value);
        while(!stack.isEmpty()){
            GraphNode cur = stack.pop();
            for (GraphNode node : cur.nodes) {
                if(!set.contains(node)){
                    stack.add(cur);
                    stack.add(node);
                    set.add(node);
                    System.out.println(node.value);
                    break;
                }
            }
        }
    }
}
