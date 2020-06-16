package cn.chenhuanming.leet.code.sort;

import cn.chenhuanming.leet.code.common.Utils;

public class 希尔排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 11, 5, 7, 4, 8, 9, 2};

        shellSort(arr);

        Utils.println(arr);
    }

    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        Utils.exchange(arr, j, j + gap);
                    }
                }
            }
        }
    }
}
