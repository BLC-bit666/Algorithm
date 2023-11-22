package demo05_Tree;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-25  20:28
 * &#064;Description: 树的广度优先遍历
 * &#064;Author: lanai
 */
public class BFSTraverse {
    /**
     * 广度优先遍历此树
     *
     * @param head 二叉树头节点
     */
    public static  void bfs(Node head){
        if(head==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            head=queue.poll();
            if(head.left!=null){
                queue.add(head.left);
            }
            if(head.right!=null){
                queue.add(head.right);
            }
            System.out.println(head.val);
        }
    }

    /**
     * 借助Map寻找二叉树的最大宽度
     *
     * @param head 二叉树头节点
     * @return 二叉树最大宽度
     */
    public static int bestBreadTh(Node head){
        if(head==null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Node,Integer> map = new HashMap<>();
        int level = 0;
        int levelCount = 0;
        int max =Integer.MIN_VALUE;
        map.put(head,level);
        queue.add(head);
        while(!queue.isEmpty()){
            head=queue.poll();
            if(level==map.get(head)){
                levelCount++;
            }else{
                max=Math.max(max,levelCount);
                level=map.get(head);
                levelCount=1;
            }
            if(head.left!=null){
                queue.add(head.left);
                map.put(head.left,levelCount+1);
            }
            if(head.right!=null){
                queue.add(head.right);
                map.put(head.right,levelCount+1);
            }
        }
        return max;
    }

    /**
     * 不借助Map查找二叉树的最大宽度
     *
     * @param head 二叉树头节点
     * @return 二叉树最大宽度
     */
    public static int bestBreadThNoMap(Node head){
        if(head==null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        Node levelEnd = head;
        Node nextLevelEnd = head;
        int levelCount = 0;
        int max =Integer.MIN_VALUE;
        queue.add(head);
        while(!queue.isEmpty()){
            head=queue.poll();
            if(head.left!=null){
                queue.add(head.left);
                nextLevelEnd=head.left;
            }
            if(head.right!=null){
                queue.add(head.right);
                nextLevelEnd=head.right;
            }
            if(head!=levelEnd){
                levelCount++;
            }else{
                levelCount++;
                max=Math.max(max,levelCount);
                levelEnd=nextLevelEnd;
                levelCount=0;
            }
        }
        return max;
    }

}
