package demo08_string;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-12-18  20:31
 * @Author: lanai
 * @Description: Manacher 算法：用来解决回文相关问题
 * 核心：回文半径数组
 */
public class Manacher {

    public static int manacher(String s) {
        if (s == null) {
            return -1;
        }
        char[] chars = manacherChar(s);
        int[] pArr = new int[chars.length];
        int r = -1; // 当前所探测到的最有边界
        int c = -1; // 当前回文串的中心位置
        int max = Integer.MIN_VALUE; // 记录最长回文串的中心+1 位置,即原始字符串最长回文串的中心的二倍（若为偶数则中心取左侧）
        for (int i = 0; i < chars.length; i++) {
            pArr[i] = r > i ? Math.min(pArr[2 * c - i], r - i) : 1;// 在四种情况下整体求出不需要算的部分（pArr数组中已记录的部分）

            while (i + pArr[i] < chars.length && i - pArr[i] > -1) { // 向右尝试扩充
                if (chars[i - pArr[i]] == chars[i + pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if(i+pArr[i]>r){ // 判断是否向右扩充，若扩充则更新
                r=i+pArr[i];
                c=i;
            }
            max = Math.max(max,pArr[i]);
        }
        return max/2-1;
    }

    private static char[] manacherChar(String s) {
        char[] res = new char[2 * s.length() + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : s.charAt(i / 2);
        }
        return res;
    }

}
