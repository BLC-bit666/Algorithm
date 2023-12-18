package demo07_Greedy;

import java.util.PriorityQueue;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-23  20:31
 * @Author: lanai
 * @Description: 贪心算法解决金条切割问题：给你一个数组，
 * 每个元素代表需要切割成块的大小，数组总元素和代表初始金块的大小，
 * 每次切割需要花费与现在金块大小相同的费用；如：50->20+30;花费50
 */
public class CutGold {
    /**
     * 利用小根堆的特性，每次弹出最小的两个，完美实现huffmanTree
     * @param nums
     * @return
     */
    public static int huffmanTree(int nums){
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums);
        int sum =0;
        int cur;
        while(queue.size()>1){
            cur= queue.poll()+queue.poll();
            sum+=cur;
            queue.add(cur);
        }
        return sum;
    }
}
