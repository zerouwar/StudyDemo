package cn.chenhuanming.leet.code.sort;

import cn.chenhuanming.leet.code.common.Utils;

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
        //建立最大堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            keep(arr, i, arr.length);
        }
        int max = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            Utils.exchange(arr, i, 0);
            keep(arr, 0, --max);
        }
    }

    static void keep(int[] arr, int i, int max) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < max && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < max && arr[right] > arr[largest]) {
            largest = right;
        }
        if (i != largest) {
            Utils.exchange(arr, i, largest);
            keep(arr, largest, max);
        }
    }
}
