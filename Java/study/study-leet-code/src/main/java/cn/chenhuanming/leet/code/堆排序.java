package cn.chenhuanming.leet.code;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author chenhuanming
 * Created at 2018/12/26
 */
public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        heapsort(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

    /**
     * 自底向上，从非叶子节点开始维护堆性质
     *
     * @param arr
     */
    static void heapsort(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            keepMaxHeapify(arr, i);
        }
    }

    /**
     * 维护最大堆性质
     * 比较节点和它的孩子节点，值最大的成为父节点
     * 再把结果递推到树的下面
     * 时间复杂度：o(h),h=lgn
     *
     * @param arr
     * @param i
     */
    static void keepMaxHeapify(int[] arr, int i) {
        int left = i << 1;//aka i*2
        int right = left + 1;

        int largest = i;

        if (left < arr.length && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < arr.length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            Utils.exchange(arr, i, largest);
            keepMaxHeapify(arr, largest);
        }
    }
}
