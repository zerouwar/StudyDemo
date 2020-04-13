package cn.chenhuanming.leet.code;

import java.util.Arrays;

/**
 * @author chenhuanming
 * Created at 2018/12/26
 */
public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4,1,5,6,7};

        heapSort(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

    static void heapSort(int[] arr){
        int[] heap = buildMaxHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap[1];
            Utils.exchange(heap,heap[0]--,1);
            keepMaxHeapify(heap,1);
        }
    }

    /**
     * 自底向上，从非叶子节点开始维护堆性质
     *
     * @param arr
     */
    static int[] buildMaxHeap(int[] arr) {
        int[] heap = new int[arr.length+1];
        for (int i = 1; i < heap.length; i++) {
            heap[i] = arr[i-1];
        }

        heap[0] = arr.length;
        for (int i = arr.length / 2; i >= 1; i--) {
            keepMaxHeapify(heap, i);
        }
        return heap;
    }

    /**
     * 维护最大堆性质
     * 比较节点和它的孩子节点，值最大的成为父节点
     * 再把结果递推到树的下面
     * 时间复杂度：o(h),h=lgn
     *
     * @param heap
     * @param i
     */
    static void keepMaxHeapify(int[] heap, int i) {
        int left = i << 1;//aka i*2
        int right = left + 1;

        int largest = i;

        if (left <= heap[0] && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right <= heap[0] && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            Utils.exchange(heap, i, largest);
            keepMaxHeapify(heap, largest);
        }
    }
}
