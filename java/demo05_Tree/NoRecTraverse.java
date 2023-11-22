package demo05_Tree;

import java.util.Stack;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-25  15:35
 * &#064;Description: 树的无递归遍历
 * &#064;Author: lanai
 */
public class NoRecTraverse {
    /**
     * 无递归先序遍历
     *
     * @param head 二叉树头节点
     */
    public static void preTraverse(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            if(head.right!=null) {
                stack.push(head.right);
            }
            if(head.left!=null) {
                stack.push(head.left);
            }
            System.out.println(head.val);
        }
    }

    /**
     * 无递归中序遍历
     *
     * @param head 二叉树头节点
     */
    public static void inTraverse(Node head){
        if(head==null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty()||head!=null){
            if(head!=null){
                stack.push(head);
                head=head.left;
            }else{
                head = stack.pop();
                System.out.println(head.val);
                head=head.right;
            }
        }
    }

    /**
     * 无递归后序遍历
     *
     * @param head 二叉树头节点
     */
    public static void postTraverse(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if(head.right!=null) {
                stack1.push(head.left);
            }
            if(head.left!=null) {
                stack1.push(head.right);
            }
        }
        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().val);
        }
    }
}
