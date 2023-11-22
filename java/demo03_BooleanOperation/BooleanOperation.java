package demo03_BooleanOperation;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-15  17:45
 * &#064;Description: 布尔运算： 与，或，非
 * &#064;Author: lanai
 */
public class BooleanOperation {
    public static void main(String[] args) {
        or2exchange();
    }

    /**
     * 与下式三次调用或运算可以交换两数的值，注意：此两数不能存放于同一内存，否则将会被置为零
     */
    public static void or2exchange() {
        int a = 10;
        int b = 43;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a + "b=" + b);
    }

    /**
     * 存在一个数字出现奇数次，其余数字均出现偶数次，求此数字
     * 利用或运算的交换律与结合律求出该数字
     *
     * @param arr 数组
     * @return 目标数字
     */
    public static Integer oddTimeOne(int[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }
        int eor = 0;
        for (int i : arr) {
            eor ^= arr[i];
        }
        return eor;
    }

    /**
     * 存在两个数字出现奇数次，其余数字均出现偶数次，求这两个数字
     *
     * @param arr 数组
     */
    public static void oddTimeWTwo(int[] arr) {
        // 1：首先利用或运算的交换律与结合律求出该此两数相或的结果
        if (arr == null || arr.length < 1) {
            System.out.println("格式不对，请重新输入");
        }
        int eor = 0;
        for (int i : arr) {
            eor ^= arr[i];
        }
        /*
            目标数字 a!=b;所以a^b至少存在一位 1
            再利用eor & (~eor + 1) 求出eor最右侧的 1  ★★★★★
         */
        int rightOne = eor & (~eor + 1);
        int eorOne = 0;
        // 求出 a | b
        for (int i : arr) {
            if ((rightOne & arr[i]) == 0) {
                eorOne ^= arr[i];
            }
        }
        System.out.println("一个数是：" + eorOne + " 另一个数是：" + (eor ^ eorOne));
    }

}

