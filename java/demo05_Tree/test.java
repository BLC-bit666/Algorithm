package demo05_Tree;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-27  18:45
 * &#064;Description: TODO
 * &#064;Author: lanai
 * @author lanai
 */
public class test {
    public static void main(String[] args) {

    }


    /**
     * 生成一个树，用于测试
     *
     * @return 二叉树头节点
     */
    public static Node getTree(){
        Node head = new Node(0);
        head.left=new Node(1);
        head.left.left=new Node(5);
        head.left.right=new Node(6);
        head.right=new Node(2);
        head.right.left=new Node(5);
        head.right.right=new Node(6);
        head.right.right.left=new Node(6);
        return head;
    }


}
