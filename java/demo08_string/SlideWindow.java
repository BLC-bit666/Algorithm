package demo08_string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-12-19  09:02
 * @Author: lanai
 * @Description: 滑动窗口问题（双指针）
 */
public class SlideWindow {
    /**
     * 应用之一，用于解决窗口移动过程中窗口内的最大值问题
     * @param arr 原数组
     * @param winSize 固定窗口大小
     * @return 0 到 length-winSize 位置窗口中的最大值数组
     */
    public static int[] getMxWindow(int[] arr,int winSize){
        if(arr==null||arr.length==0){
            return null;
        }
        int[] res = new int[arr.length-winSize+1];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for(int i = 0; i < arr.length;i++){
            while(!deque.isEmpty()&&arr[deque.peekLast()]<=arr[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(deque.peekFirst()==i-winSize){
                deque.pollFirst();
            }
            if(i>=winSize-1){
                res[index++] = deque.peekFirst();
            }
        }
        return res;
    }
}
