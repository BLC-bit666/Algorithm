package demo08_string;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-12-07  19:40
 * @Author: lanai
 * @Description: kmp算法
 */
public class Kmp {
    /**
     * 判断字符串 s 是否包含 m ，若包含返回字串在主串的第一个位置索引，不包含返回 -1;
     * @param s
     * @param m
     * @return
     */
    public static int getFirstIndexIfContain(String s, String m) {
        if (s.length() < m.length()) {
            return -1;
        }
        char[] strS = s.toCharArray();
        char[] strM = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(strM); // 获取 next 数组
        while (i1 < strS.length && i2 < strM.length) {
            if (strS[i1] == strM[i2]) { //相同匹配下一个
                i1++;
                i2++;
            } else if (next[i2] == -1) { // 不相同且子串跳到 0 位置，主串++
                i1++;
            } else {
                i2 = next[i2]; // 不相同且子串未跳到 0 位置，跳到当前最大前缀的后一个位置
            }
        }
        return i2 == strM.length ? i1 - i2 : -1;
    }

    /**
     * 求出next数组，每一项代表该位置前的字符串中最长前后缀相同的的长度
     * @param m
     * @return
     */
    private static int[] getNextArray(char[] m) {
        if (m.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[m.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < m.length) {
            if (m[i - 1] == m[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn]; // 跳到最长前缀的后一个位置
            } else {
                next[i++] = 0; // 无前后缀相同的情况
            }
        }
        return next;
    }
}
