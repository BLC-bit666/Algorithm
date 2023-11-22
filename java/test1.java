import java.util.*;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-16  19:16
 * @Author: lanai
 * @Description: TODO
 */
public class test1 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : nums1){
            queue.add(i);
        }
        for(int i : nums2){
            queue.add(i);
        }
        int size = queue.size();
        for(int i =0; i<(size-1)/2;i++){
            queue.poll();
        }
        return size%2==0?(double)((queue.poll())+(queue.poll()))/2:queue.poll();
    }
    public static void main(String[] args) {
        int[] num1 = new int[]{1,2};
        int[] num2 = new int[]{1,2};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : num1) {
            queue.add(i);
        }
    }
}
