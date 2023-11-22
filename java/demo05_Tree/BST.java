package demo05_Tree;

import java.util.Stack;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-26  17:22
 * &#064;Description: TODO
 * &#064;Author: lanai
 */
public class BST {
    public static int preVal = Integer.MIN_VALUE;

    /**
     * 利用中序遍历实现 二叉搜索树的判断
     *
     * @param head 二叉树头节点
     * @return 是否为搜索二叉树
     */
    public static boolean bstRec(Node head){
        if(head==null){
            return true;
        }
        boolean leftBoolean = bstRec(head.left);
        if(!leftBoolean){
            return false;
        }
        if(head.val<=preVal){
            return false;
        }
        preVal=head.val;
        return bstRec(head.right);
    }

    /**
     * 利用栈实现树的中序遍历，从而实现 二叉搜索树的判断
     *
     * @param head 二叉树从头节点
     * @return 是否为搜索二叉树
     */
    public static boolean bstNoRec(Node head){
        if(head==null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty()||head!=null){
            if(head!=null){
                stack.push(head);
                head=head.left;
            }else{
                head = stack.pop();
                if(head.val<=preVal){
                    return false;
                }
                head=head.right;
            }
        }
        return true;
    }
}
