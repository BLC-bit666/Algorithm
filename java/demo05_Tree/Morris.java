package demo05_Tree;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-12-21  18:01
 * @Author: lanai
 * @Description: Morris遍历
 */
public class Morris {
    /**
     * Morris遍历：时间复杂度：O(n);空间复杂度：O(1)
     * @param head
     */
    public static void morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null; // 代表左子树最右节点
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { // 左子树不为空
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right; // 取左子树最右节点
                }
                if (mostRight.right == null) { // mostRight第一次到达本左字树最右节点
                    mostRight.right = cur; // 使其右孩子指向当前节点cur(本子树根节点)
                    cur = cur.left; // 遍历到左孩子
                    continue;
                } else {
                    mostRight.right = null; // mostRight第一次到达本左字树最右节点，将其还原为 null
                }
            }
            cur = cur.right; 
        }
    }

    /**
     * morris 改 先序遍历
     * @param head
     */
    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.print(" "); // 有左孩子，第一次来到时处理
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.print(" "); // 无左孩子直接处理
            }
            cur = cur.right;
        }
    }

    /**
     * Morris 改 中序遍历
     * @param head
     */
    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.print(" "); // 无左孩子或者有左孩子第二次来到mostRight处理当前节点
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * Morris 改 后续遍历
     * @param head
     */
    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left); // 有左孩子，第二次来到时逆序处理其右边界
                }
            }
            cur = cur.right;
        }
        printEdge(head); // 最后逆序处理整个树的有边右边界
    }

    /**
     * 逆序处理右边界
     * @param head
     */
    public static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(" ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    /**
     * 树的右边界反转（相当于单链表的反转）
     * @param from
     * @return
     */
    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }
    
}
