package demo05_Tree;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-27  20:00
 * &#064;Description: 寻找两个节点的最近公共祖先
 * &#064;Author: lanai
 */
public class LowestCommonAncestor {
    /**
     * 寻找两个节点的最近公共祖先
     *
     * 思想：某个子树中
     *      （1）：不存在任一节点，返回null
     *      （2）：存在一个节点，返回该节点，
     *      （3）：存在两个节点：
     *              1）：两个节点在一条路径上，返回最先遇到的节点
     *              2）：两个节点在不同路径上，返回此两节点向上传递的过程中第一次相遇的节点
     *
     * @param head 头节点
     * @param o1 节点一
     * @param o2 节点二
     * @return 两个节点的最近公共祖先
     */
    public static Node lca(Node head,Node o1,Node o2){
        if(head==null||head==o1||head==o2){
            return head;
        }
        Node left = lca(head.left, o1, o2);
        Node right = lca(head.right, o1, o2);
        if(left!=null&&right!=null){
            return head;
        }
        return left!=null?left:right;
    }
}
