package demo05_Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-27  21:30
 * &#064;Description: 二叉树的序列化与反序列化
 * &#064;Author: lanai
 */
public class SerializeAndDeserialize {
    /**
     * 先序遍历二叉树，以 "_" 作为节点之间的分隔符，以 “#” 表示 null
     *
     * @param head 头节点
     * @return 序列化后的字符串
     */
    public String serialize(Node head) {
        if(head==null){
            return "#_";
        }
        String  res= head.val +"_";
        res += serialize(head.left);
        res += serialize(head.right);
        return res;
    }

    /**
     * 反序列化的启动函数，将序列化字符串，按 “_” 切割后存入队列
     *
     * @param data 序列化字符串
     * @return 反序列化完成后，二叉树的头节点
     */
    public Node deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split("_")));
        return process(queue);
    }

    /**
     * 反序列化的过程，先序建立二叉树
     *
     * @param queue 节点队列
     * @return 反序列化完成后，二叉树的头节点
     */
    public Node process(Queue<String> queue){
        String s = queue.poll();
        if(s.equals("#")){
            return null;
        }
        Node head = new Node(Integer.parseInt(s));
        head.left=process(queue);
        head.right=process(queue);
        return head;
    }
}
