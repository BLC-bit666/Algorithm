package demo08_string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-12-21  15:37
 * @Author: lanai
 * @Description: 利用单调栈解决最小值作用范围问题（找出某数左边和右边第一个小于或大于其的数字（索引））
 */
public class MonotonicStacks {
    /**
     * 定义：数组中累积和与最小值的乘积，假设叫做指标A。
     * 给定一个数组，请返回子数组中，指标A最大的值
     *
     * @param arr
     * @return
     */
    public static int minValue2Subarray(int[] arr) {
        int size = arr.length;
        int[] sums = new int[size];
        sums[0] = arr[0];
        // 区间和数组
        for (int i = 1; i < size; i++) {
            sums[i] = sums[i - 1] + arr[i];
        }
        int max = Integer.MIN_VALUE;
        // 定义栈（单调增减栈）
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                // 弹出并清算此位置
                int j = stack.pop();
                max = Math.max(max, (stack.isEmpty() ? sums[i - 1] : (sums[i - 1] - sums[stack.peek()])) * arr[j]);
            }
            stack.push(i);
        }
        // 清算栈内剩余元素
        while (!stack.isEmpty()) {
            int j = stack.pop();
            max = Math.max(max, (stack.isEmpty() ? sums[size - 1] : (sums[size - 1] - sums[stack.peek()])) * arr[j]);
        }
        return max;
    }
}
