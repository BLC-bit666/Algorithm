package demo05_Tree;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-27  20:25
 * &#064;Description: 寻找某一节点的后继节点
 * &#064;Author: lanai
 */
public class Successor {
    /**
     * 寻找某一节点的后继节点
     *
     * @param node 给定节点
     * @return 后继节点
     */
    public static SuccessNode findSuccess(SuccessNode node){
        if(node.right!=null){
            node=node.right;
            while(node.left!=null){
                node=node.left;
            }
            return node;
        }else{
            SuccessNode parent=node.parent;
            while(parent!=null&&parent.left!=node){
                node=parent;
                parent=parent.parent;
            }
            return parent;
        }
    }
    public static class SuccessNode{
        public int val;
        public SuccessNode left;
        public SuccessNode right;
        public SuccessNode parent;

        public SuccessNode() {
        }

        public SuccessNode(int val, SuccessNode left, SuccessNode right, SuccessNode parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
