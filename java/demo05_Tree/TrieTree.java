package demo05_Tree;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-11-23  11:05
 * @Author: lanai
 * @Description: 前缀树算法
 */
public class TrieTree {
    /**
     * 前缀树节点结构
     */
    public static class TrieNode {
        /**
         * 经过此节点（字符）的字符串数量
         */
        int pass;
        /**
         * 以此节点（字符）为结尾节点的字符串的数量
         */
        int end;
        /**
         * 此字符的后续字符
         * nexts[i]==null ：无
         * nexts[i]!=null ：char=i+'a';
         */
        TrieNode[] nexts;

        public TrieNode() {
            pass=0;
            end=0;
            nexts=new TrieNode[26];
        }
    }

    public TrieNode root = new TrieNode();
    
    /**
     * 向前缀树中添加字符串
     * @param word
     */
    public void insert(String word){
        if(word == null){
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.pass++;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i]-'a';
            if(node.nexts[index]==null){
                    node.nexts[index] = new TrieNode();
            }
            node=node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    /**
     * 查找某字符串被添加过几次
     * @param word
     * @return
     */
    public int search(String word){
        if(word == null){
            return 0;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i]-'a';
            if(node.nexts[index]==null){
              return 0;
            }
            node=node.nexts[index];
        }
        return node.end;
    }

    /**
     * 从前缀树上删除某字符串
     * @param word
     */
    public void delete(String word){
        if(search(word)==0){
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.pass--;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i]-'a';
            if(--node.nexts[index].pass==0){
                node.nexts[index] = null;   // 释放本节点之后的所有节点
                return;
            }
            node=node.nexts[index];
        }
        node.end--;
    }

    /**
     * 查找以某字符串开头的所有字符串的数量
     * @param pre
     * @return
     */
    public int preFixNum(String pre){
        if(pre == null){
            return 0;
        }
        char[] chars = pre.toCharArray();
        TrieNode node = root;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i]-'a';
            if(node.nexts[index]==null){
                return 0;
            }
            node=node.nexts[index];
        }
        return node.pass;
    }
}
