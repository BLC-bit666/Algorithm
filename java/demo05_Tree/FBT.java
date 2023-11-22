package demo05_Tree;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-27  18:37
 * &#064;Description: 判断是否为满二叉树
 * &#064;Author: lanai
 */
public class FBT {
    public static boolean idFBT(Node head){
        if(head==null){
            return true;
        }
        CBTReturnType res = process(head);
        return res.count== (1<<res.high)-1;
    }

    /**
     * 判断一个树是否为满二叉树的过程
     *
     * @param head 头节点
     * @return 包含当前树的高度以及节点个数
     */
    public static CBTReturnType process(Node head){
        if(head==null){
            return new CBTReturnType(0,0);
        }
        CBTReturnType left = process(head.left);
        CBTReturnType right = process(head.right);
        int high=Math.max(left.high, right.high)+1;
        int count=left.count+right.count+1;
        return new CBTReturnType(high,count);
    }

    /**
     * 返回值封装类
     */
    public static class CBTReturnType{
        int high;
        int count;

        public CBTReturnType() {
        }

        public CBTReturnType(int high, int count) {
            this.high = high;
            this.count = count;
        }
    }
}
