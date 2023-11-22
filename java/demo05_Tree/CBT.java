package demo05_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-27  18:52
 * &#064;Description: 判断是否为完全二叉树
 * &#064;Author: lanai
 */
public class CBT {

    /**
     * 判断是否为完全二叉树
     *
     * @param head
     * @return
     */
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        boolean flag = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if ((head.left == null && head.right != null)||(!flag && (head.right != null||head.left != null ))) {
                return false;
            }
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
            if (head.left == null || head.right == null) {
                flag = false;
            }
        }
        return true;
    }
}
