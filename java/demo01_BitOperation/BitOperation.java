package demo01_BitOperation;

import demo05_Tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-14  16:40
 * &#064;Description: 位运算
 * &#064;Author: lanai
 */
public class BitOperation {
    public static void main(String[] args) {
        int num = 12345;
        printB(num);
        printB(negation(num));
    }

    /**
     * 通过左移和与运算实现整数的二进制输出
     *
     * @param num 整数
     */
    public static void printB(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static int negation(int num) {
//        return -num;
        return (~num + 1);//取反加1，使得底层二进制的正负数四则运算走同一套电路门
    }

    public static void test(){
        Queue<Node> queue = new LinkedList<>();
    }
}
