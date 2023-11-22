package demo05_Tree;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-25  15:26
 * &#064;Description: 树的节点
 * &#064;Author: lanai
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
        left=null;
        right=null;
    }

    public Node(int val) {
        this.val = val;
        left=null;
        right=null;
    }

}
