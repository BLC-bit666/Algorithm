package demo05_Tree;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-25  15:24
 * &#064;Description: 树的递归遍历
 * &#064;Author: lanai
 */
public class RecTraverse {
    /**
     * 先序遍历：第一次来到此节点对其进行操作
     *
     * @param head 二叉树头节点
     */
    public static void preTraverse(Node head){
        if(head==null){
            return;
        }
        System.out.println(head.val);
        preTraverse(head.left);
        preTraverse(head.right);
    }

    /**
     * 先序遍历：第二次来到此节点对其进行操作
     *
     * @param head 二叉树头节点
     */
    public static void inTraversal(Node head){
        if(head==null){
            return;
        }
        inTraversal(head.left);
        System.out.println(head.val);
        inTraversal(head.right);
    }

    /**
     * 先序遍历：第三次来到此节点对其进行操作
     *
     * @param head 二叉树头节点
     */
    public static void postTraversal(Node head){
        if(head==null){
            return;
        }
        postTraversal(head.left);
        postTraversal(head.right);
        System.out.println(head.val);
    }

}
