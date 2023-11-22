package demo06_Graph;


import java.util.*;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-13  19:23
 * @Author: lanai
 * @Description: TODO
 */
public class Kruskal {
    /**
     * 克鲁斯卡尔 算法，求图最小生成树
     * @param graph
     * @return
     */
    public static Set<GraphEdge> kruskalMST(Graph graph){
        if(graph==null){
            return null;
        }
        MySet mySet = new MySet((List<GraphNode>) graph.nodes.values());
        PriorityQueue<GraphEdge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        Set<GraphEdge> res = new HashSet<>();
        queue.addAll(graph.edges);
        while(!queue.isEmpty()){
            GraphEdge cur = queue.poll();
            if(!mySet.isSameSet(cur.from,cur.to)){
                res.add(cur);
                mySet.union(cur.from,cur.to);
            }
        }
        return res;
    }
    /**
     * 用 Map 结构暂时代替并查集（暂时没学）
     */
    public static class MySet{
        public Map<GraphNode, List<GraphNode>> setMap;
        public MySet(List<GraphNode> nodes){
            for (GraphNode node : nodes) {
                List<GraphNode> list = new ArrayList<>();
                list.add(node);
                setMap.put(node,list);
            }
        }

        /**
         * 判断两个点是否在同一集合 --> 判断此边是否会构成环
         * @param from 边的出节点
         * @param to 边的入节点
         * @return 是否在同一集合
         */
        public boolean isSameSet(GraphNode from,GraphNode to){
            return setMap.get(from)==setMap.get(to);
        }

        /**
         * 将两个点所在的集合合并
         * @param from 点一
         * @param to 点二
         */
        public void union(GraphNode from,GraphNode to){
            List<GraphNode> froms = setMap.get(from);
            List<GraphNode> tos = setMap.get(to);
            for (GraphNode node : tos) {
                froms.add(node);
                setMap.put(node,froms);
            }
        }
    }
}
