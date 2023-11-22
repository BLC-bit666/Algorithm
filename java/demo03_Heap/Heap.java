package demo03_Heap;

import java.util.PriorityQueue;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-17  14:30
 * &#064;Description: 堆排序
 * &#064;Author: lanai
 */
public class Heap {
    /*
    一、将数组抽象成完全二叉树的换算关系
        1、左孩子：i*2+1
        2、右孩子：i*2+2
        3、父节点：(i-1)/2
    二、大根堆：
        定义：完全二叉树中每个字树中的最大元素是该子树的根节点
        HeapInsert:
            每个新插入的节点不断的与其父节点相比较，如果大于父节点则交换位置
     三、小根堆：
        定义：完全二叉树中每个字树中的最小元素是该子树的根节点
        HeapInsert:
            每个新插入的节点不断的与其父节点相比较，如果小于父节点则交换位置
    */
    public static void main(String[] args) {
        int[] arr = createArr(1000, 1000);
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


    /**
     * 堆排序：
     *      1、首先 heapInsert 整个数组，使其成为大根堆，确定最大的数字在根节点
     *      2、将根节点与堆的最后节点相交换，将一个数变为有序，堆长度减一
     *      3、对堆进行 heapify 使其成为大根堆
     *      4、重复 2-3 过程，直到堆为空
     *
     * @param arr 待排序数组
     */
    public static void heapSort(int[] arr){
        if(arr == null|| arr.length<2){
            return;
        }
        /*时间复杂度为：O(n*log n): 将数组中的每个元素逐个加入大根堆中；
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }*/

        // 时间复杂度为：O(n): 将整个数组直接转化为大根堆
        for (int i = arr.length ;i >=0; i--) {
            heapify(arr,i,arr.length);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while(heapSize>0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    /**
     * 将新加入的元素放入堆中
     * @param arr 数组
     * @param index 新加入元素在数组中的下标
     */
    public static  void  heapInsert(int[] arr,int index){
        while(arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    /**
     * 交换数组中任意两个元素
     * @param arr 数组
     * @param i 第一个下标
     * @param j 第二个下标
     */
    private static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    /**
     * 堆的任一节点（子树的根节点）被删除后，仍保持该堆是大根堆
     * @param arr 数组
     * @param index 当前元素下标
     * @param heapSize 当前数组长度
     */
    public static void heapify(int[] arr,int index,int heapSize){
        int left = index*2+1;
        while(left<heapSize){
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest=arr[largest]>arr[index]?largest:index;
            if(largest == index){
                break;
            }
            swap(arr,index,largest);
            index=largest;
            left=index*2+1;
        }
    }

    /**
     * PriorityQueue: 优先队列的底层就是小根堆，可以直接使用，但不建议更改中间节点
     */
    public static void minHeap(){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(9);
        minHeap.add(3);
        minHeap.add(11);
        minHeap.add(1);
        while(!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }
    }

    /**
     * 生成随机的测试数组
     * @param arrMaxLength 数组最大长度
     * @param arrMaxValue 数组元素的最大值
     * @return 随机数组
     */
    public static int[] createArr(int arrMaxLength,int arrMaxValue){
        int[] arr = new int[arrMaxLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*(arrMaxValue+1));
        }
        return arr;
    }
}
