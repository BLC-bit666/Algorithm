package demo05_Tree;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-27  19:19
 * &#064;Description: 判断是否为平衡二叉树
 * &#064;Author: lanai
 */
public class BBT {
    public static boolean isBBT(Node head){
        return process(head).flag;
    }

    /**
     * 判断是否为平衡二叉树的过程
     *
     * 思想：树形DP-->向左树和右树要信息（构造返回值类型）：
     *      （1）：从黑盒中获取左右子树的信息
     *      （2）：拆盒，拿到信息后结合自身条件做出判断
     *      （3）：将本子树信息返回给父节点
     *
     * @param head 头节点
     * @return 包含本二叉树是否为平衡二叉树，本二叉树的高度
     */
    public static BBTReturnType process(Node head){
        if(head==null){
            return new BBTReturnType(true,0);
        }
        BBTReturnType left = process(head.left);
        BBTReturnType right = process(head.right);
        boolean flag = left.flag&& right.flag&&(Math.abs(left.high- right.high)<2);
        int high=Math.max(left.high, right.high)+1;
        return new BBTReturnType(flag,high);
    }

    /**
     * 返回值封装类
     */
    public static class BBTReturnType{
        boolean flag;
        int high;

        public BBTReturnType() {
        }

        public BBTReturnType(boolean flag, int high) {
            this.flag = flag;
            this.high = high;
        }
    }
}
