package demo01_BitOperation;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-24  20:18
 * @Author: lanai
 * @Description: 使用位运算提速->八皇后问题
 */
public class NQueens {
    // region 常规方法（无动态规划）
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record, n);
    }

    public static int process1(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }
    // endregion

    // region 使用位运算为常规方法提速
    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int upperLim = n == 32 ? -1 : (1 << n) - 1;
        return process2(upperLim, 0, 0, 0);
    }

    /**
     * 位运算加速八皇后问题的常规解法
     * @param upperLim 根据皇后的个数来划分全局限制
     * @param colLim 整体列限制
     * @param leftDiaLim 整体左对角线限制
     * @param rightDiaLim 整体右对角线限制
     * @return 所有可能的解法数
     */
    public static int process2(int upperLim, int colLim, int leftDiaLim,
                               int rightDiaLim) {
        if (colLim == upperLim) {
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        // 所有可选皇后的位置（1：可选）
        pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            // 取出最右侧可选皇后的位置（取出最右侧的 1）
            mostRightOne = pos & (~pos + 1);
            // 减去此可选位置
            pos = pos - mostRightOne;
            res += process2(upperLim, colLim | mostRightOne, // 给出下一行的列限制
                    (leftDiaLim | mostRightOne) << 1,   //给出下一行的左对角线限制
                    (rightDiaLim | mostRightOne) >>> 1); //给出下一行的右对角线限制
        }
        return res;
    }
    // endregion

    /**
     * 测试两种方法的快慢
     * @param args
     */
    public static void main(String[] args) {
        int n = 14;

        long start = System.currentTimeMillis();
        System.out.println(num2(n));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(num1(n));
        end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

    }
}
